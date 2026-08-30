package com.gridweaver.service;

import com.gridweaver.entity.Device;
import com.gridweaver.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    public Device createDevice(Device device){
        return deviceRepository.save(device);
    }
    public Device UpdateDevice(Long id , Device updateDevice ){
        Device device =deviceRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Device not found"));

        device.setDeviceName(updateDevice.getDeviceName());
        device.setDeviceType(updateDevice.getDeviceType());
        device.setLocation(updateDevice.getLocation());
        device.setStatus(updateDevice.getStatus());

        return deviceRepository.save(device);

    }

    public List<Device> getAllDevices(){
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id){
        return deviceRepository.findById(id).orElse(null);
    }
    public Device DeleteDeviceById(Long id){
        Device device = deviceRepository.findById(id).orElse(null);
        if (device != null) {
            deviceRepository.deleteById(id);
        }
        return device;
    }



}