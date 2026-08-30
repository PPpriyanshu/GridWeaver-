package com.gridweaver.controller;
import com.gridweaver.dto.EnergySummary;
import com.gridweaver.service.EnergyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/energy")
public class EnergyController {
    private final EnergyService energyService;
    public EnergyController(EnergyService energyService){
        this.energyService=energyService;
    }
    @GetMapping("/device/{deviceId}")
    public EnergySummary getEnergyByDEnergyService(@PathVariable Long deviceId){
        return energyService.getEnergyByDevice(deviceId);
    }

}
