package com.gridweaver.dto;

public class TelemetryRequest {
    private Long deviceId;
    private Long voltage;
    private long current;
    private Long power;
    private Long energy;
    private Long temperature;

    public TelemetryRequest(){

    }

    public Long getDeviceId(){
        return deviceId;
    }

    public void setDeviceId(Long deviceid){
        this.deviceId=deviceid;
    }
    public Long getVoltage(){
        return voltage;
    }
    public void setVoltage(long voltage){
        this.voltage=voltage;
    }
    public Long getCurrent(){
        return current;
    }
    public void setCurrent(Long current){
        this.current=current;
    }
    public Long getPower(){
        return power;
    }
    public void setPower(Long power){
        this.power=power;
    }
    public Long getEnergy(){
        return energy;
    }
    public void setEnergy(Long energy){
        this.energy=energy;
    }
    public Long getTemperature(){
        return temperature;
    }
    public void setTemperature(Long temperature){
        this.temperature=temperature;
    }


}
