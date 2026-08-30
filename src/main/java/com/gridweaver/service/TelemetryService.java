package com.gridweaver.service;

import com.gridweaver.dto.TelemetryRequest;
import com.gridweaver.entity.Device;
import com.gridweaver.entity.Telemetry;
import com.gridweaver.repository.DeviceRepository;
import com.gridweaver.repository.TelemetryRepository;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.List;
@Service
public class TelemetryService {
    private final TelemetryRepository telemetryRepository;
    private final DeviceRepository deviceRepository;
    private final SimpMessagingTemplate messagingTemplate;

    public TelemetryService(TelemetryRepository telemetryRepository, DeviceRepository deviceRepository,SimpMessagingTemplate messagingTemplate) {
        this.telemetryRepository = telemetryRepository;
        this.deviceRepository = deviceRepository;
        this.messagingTemplate=messagingTemplate;
    }
    public Telemetry getLatestTelemetryByDeviceId(Long deviceId){
        return telemetryRepository.findTopByDevice_IdOrderByTimestampDesc(deviceId)
        .orElseThrow(()-> new RuntimeException("Telemetry not found for the Device"+ deviceId));
    }
    public Telemetry createTelemetry(TelemetryRequest request) {
        Device device = deviceRepository.findById(request.getDeviceId())
                .orElseThrow(() -> new RuntimeException("Device not found."));

        Telemetry telemetry = new Telemetry();
        telemetry.setDevice(device);
        telemetry.setVoltage(request.getVoltage());
        telemetry.setCurrent(request.getCurrent());
        telemetry.setPower(request.getPower());
        telemetry.setEnergy(request.getEnergy());
        telemetry.setTemperature(request.getTemperature());

        Telemetry savedTelemetry = telemetryRepository.save(telemetry);
        messagingTemplate.convertAndSend("/topic/telemetry", savedTelemetry);
        return savedTelemetry;
    }

    public List<Telemetry> getAllTelemetry() {
        return telemetryRepository.findAll();
    }

    public List<Telemetry> getTelemetryByDeviceId(Long deviceId) {
        return telemetryRepository.findByDeviceId(deviceId);
    }

    public void deleteTelemetryById(Long id) {
        telemetryRepository.deleteById(id);
    }
}
