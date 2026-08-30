package com.gridweaver.controller;

import com.gridweaver.entity.Device;
import com.gridweaver.service.DeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public Device createDevice(@RequestBody Device device){
        return deviceService.createDevice(device);

    }
     @PutMapping("/{id}")
    public Device updateDevice(@PathVariable Long id, 
                                @RequestBody Device device){
        return deviceService.UpdateDevice(id, device);
    }
    

    @GetMapping
    public java.util.List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }
   
    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Long id){
        return deviceService.getDeviceById(id);
    }
    @GetMapping("/{id}/status")
    public String getDeviceStatus(@PathVariable Long id){
        Device device = deviceService.getDeviceById(id);
        return device.getStatus().toString();
    }
    

    @DeleteMapping("/{id}")
    public void deleteDeviceById(@PathVariable Long id){
        deviceService.DeleteDeviceById(id);
       
    }



}
