package com.gridweaver.dto;

public class EnergySummary {
      
    
    private double totalEnergy;

     private Long deviceId;
    private String deviceName;
    

    public EnergySummary(){
    }
         public EnergySummary(Long deviceId, String deviceName, double totalEnergy) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.totalEnergy = totalEnergy;
    }

    
    
    public double getTotalEnergy(){
        return totalEnergy;
    }
    public void setTotalEnergy(long totalEnergy){
        this.totalEnergy=totalEnergy;
    }
    public Long getDeviceId(){
        return deviceId;
    }
    public void setDeviceId(Long deviceId){
        this.deviceId=deviceId;
    }
    public String getDeviceName(){
        return deviceName;
    }
    public void setDeviceName(String deviceName){
        this.deviceName=deviceName;
    }

}
