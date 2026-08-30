package com.gridweaver.service;
import com.gridweaver.dto.Alert;
import com.gridweaver.entity.Device;
import com.gridweaver.entity.Telemetry;
import com.gridweaver.repository.DeviceRepository;
import com.gridweaver.repository.TelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {
    private final DeviceRepository deviceRepository;
    private final TelemetryRepository telemetryRepository;
    public AlertService(DeviceRepository deviceRepository,
                        TelemetryRepository telemetryRepository) {
        this.deviceRepository = deviceRepository;
        this.telemetryRepository = telemetryRepository;
    }

    public List<Alert> getaAlerts() {
        List<Alert> alerts = new ArrayList<>();
        List<Device> devices = deviceRepository.findAll();

        for (Device device : devices) {
            if ("MAINTENANCE".equalsIgnoreCase(String.valueOf(device.getStatus()))) {
                alerts.add(new Alert(device.getId(), device.getDeviceName(),
                        "MAINTENANCE", "Device is under maintenance", "WARNING"));
            }

            if ("OFFLINE".equalsIgnoreCase(String.valueOf(device.getStatus()))) {
                alerts.add(new Alert(device.getId(), device.getDeviceName(),
                        "OFFLINE", "Device is Offline", "CRITICAL"));
            }

            Telemetry telemetry = telemetryRepository
                    .findTopByDevice_IdOrderByTimestampDesc(device.getId())
                    .orElse(null);
            if (telemetry != null) {
                if (telemetry.getTemperature() > 45) {
                    alerts.add(new Alert(device.getId(), device.getDeviceName(),
                            "HIGH_TEMPERATURE", "Device temperature is above 45°C", "CRITICAL"));
                }
                if (telemetry.getPower() > 1500) {
                    alerts.add(new Alert(device.getId(), device.getDeviceName(),
                            "HIGH_POWER", "Device power consumption is above 1500 W", "WARNING"));
                }
            }
        }

        return alerts;
    }
}


