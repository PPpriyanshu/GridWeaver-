package com.gridweaver.dto;

import java.time.LocalTime;
public class TelemetryResponce {

    private Long id;
    private Long deviceId;
    private double Voltage;
    private double current;
    private double power;
    private double energy;
    private double temperature;
    private LocalTime timestamp;

    public TelemetryResponce(){

    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getDeviceId(){
        return deviceId;
    } 
    public void setDeviceId(Long deviceId){
        this.deviceId=deviceId;
    }
    public double getVoltage(){
        return Voltage;
    }
    public void setVoltage(double voltage){
        this.Voltage=voltage;
    }
    public double getCurrent(){
        return current;
    }
    public void setCurrent(double current){
        this.current=current;
    }
    public double getEnergy(){
        return energy;
    }
    public void setEnergy(double energy){
        this.energy=energy;
    }
    public double getPower(){
        return power;
    }
    public void serPower(double power){
        this.power=power;
    }
    public double getTemperature(){
        return temperature;
    }
    public void setTemperature(double temperature){
        this.temperature=temperature;
    }
    public LocalTime getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(LocalTime timestamp){
        this.timestamp=timestamp;
    }

}
