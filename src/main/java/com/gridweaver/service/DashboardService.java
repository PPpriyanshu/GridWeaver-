package com.gridweaver.service;
import com.gridweaver.dto.DashboardSummary;
import com.gridweaver.entity.Device;
import com.gridweaver.entity.Telemetry;
import com.gridweaver.repository.DeviceRepository;
import com.gridweaver.repository.TelemetryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    private final DeviceRepository deviceRepository;
    private final TelemetryRepository telemetryRepository;

    public DashboardService(DeviceRepository deviceRepository,
                            TelemetryRepository telemetryRepository) {
        this.deviceRepository = deviceRepository;
        this.telemetryRepository = telemetryRepository;
    }
    public DashboardSummary getDashboardsummary(){
        List<Device> devices=deviceRepository.findAll();
        long totalDevice= devices.size();
        long onlineDevice=devices.stream()
        .filter(device -> device.getStatus()!=null)
        .filter(device->device.getStatus().toString().equalsIgnoreCase("ONLINE")).count();

        long offlineDevice=devices.stream()
         .filter(device -> device.getStatus()!=null)
        .filter(device->device.getStatus().toString().equalsIgnoreCase("OFFLINE")).count();

        long maintenanceDevices=devices.stream()
         .filter(device -> device.getStatus()!=null)
        .filter(device->device.getStatus().toString().equalsIgnoreCase("MAINTENANCE")).count();

        double totalPower=0;
        double totalEnergy=0;
        for (Device device : devices) {
            if (device.getId()!=null){
               Telemetry lataesTelemetry = telemetryRepository
        .findTopByDevice_IdOrderByTimestampDesc(device.getId())
        .orElse(null);

                if(lataesTelemetry!=null){
                    totalPower+=lataesTelemetry.getPower();
                    totalEnergy+=lataesTelemetry.getEnergy();
                }
            }
        }
      
                return new DashboardSummary(
                    totalDevice,
                     onlineDevice,
                      offlineDevice,
                       maintenanceDevices,
                       totalPower,
                        totalEnergy
);

        
    }




}
