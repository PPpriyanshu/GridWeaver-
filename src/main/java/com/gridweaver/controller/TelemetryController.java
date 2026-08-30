package com.gridweaver.controller;
import org.springframework.web.bind.annotation.*;
import com.gridweaver.dto.TelemetryRequest;
import com.gridweaver.service.TelemetryService;
import com.gridweaver.entity.Telemetry;

import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {
    private TelemetryService telemetryService;

    public TelemetryController(TelemetryService telemetryService) {
        this.telemetryService = telemetryService;
    }

    @PostMapping
    public Telemetry createTelemetry(@RequestBody TelemetryRequest request){
        return telemetryService.createTelemetry(request);
    }
    @GetMapping
    public List<Telemetry> getAllTelemetry(){
        return telemetryService.getAllTelemetry();
    }
    
    @GetMapping("/device/{deviceId}/latest")
    public Telemetry getTelemetryByDeviceId(@PathVariable Long deviceId){
        return telemetryService.getLatestTelemetryByDeviceId(deviceId);
    }
    @DeleteMapping("/{id}")
    public void deleteTelemetrtById(@PathVariable Long id){
        telemetryService.deleteTelemetryById(id);
    }

}
