package com.gridweaver.service;
import  com.gridweaver.dto.EnergySummary;
import  com.gridweaver.entity.Device;
import  com.gridweaver.entity.Telemetry;
import com.gridweaver.repository.DeviceRepository;
import  com.gridweaver.repository.TelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyService {
    private final DeviceRepository deviceRepository;
    private final TelemetryRepository telemetryRepository;

    public EnergyService(DeviceRepository deviceRepository,
        TelemetryRepository telemetryRepository){
            this.deviceRepository=deviceRepository;
            this.telemetryRepository=telemetryRepository;
        }
        public EnergySummary getEnergyByDevice(Long deviceId){
            Device device =deviceRepository.findById(deviceId)
            .orElseThrow(()-> new RuntimeException("device not found"));
            
            List<Telemetry> telemetryList = telemetryRepository.findAll().stream()
                .filter(telemetry -> telemetry.getDevice() != null
                    && deviceId.equals(telemetry.getDevice().getId()))
                .toList();
             double totalEnergy = telemetryList.stream()
                .mapToDouble(telemetry -> telemetry != null ? telemetry.getEnergy() : 0.0)
                .sum();

            EnergySummary summary = new EnergySummary();
            summary.setDeviceId(device.getId());
            summary.setDeviceName(device.getDeviceName());
            summary.setTotalEnergy((long) totalEnergy);
            return summary;
        }


}
