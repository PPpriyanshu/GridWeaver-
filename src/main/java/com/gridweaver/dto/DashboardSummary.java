package com.gridweaver.dto;

public class DashboardSummary {
    private long totalDevice;
    private long onlineDevice;
    private long oflineDevice;
    private long maintainceDevice;
    private double totalPower;
    private double totalEnergy;

    public DashboardSummary(){
    }
        public DashboardSummary( Long totalDevice,
                                 long onlineDevice,
                                 long oflineDevice,
                                 long maintainceDevice,
                                 double totalPower,
                                 double totalEnergy){
                                    this.totalDevice=totalDevice;
                                    this.onlineDevice=onlineDevice;
                                    this.oflineDevice=oflineDevice;
                                    this.maintainceDevice=maintainceDevice;
                                    this.totalPower=totalPower;
                                    this.totalEnergy=totalEnergy;
                                 }


     public long getTotalDevice(){
        return totalDevice;
     }                     
     public void setTotalDevice(long totalDevice){
        this.totalDevice=totalDevice;
     }    
     public long getOnlineDevice(){
        return onlineDevice;
     }  
     public void SetOnlineDevice(long onlineDevice){
        this.onlineDevice=onlineDevice;
     }
    public long getOflineDevice(){
        return oflineDevice;
    }
    public void setOflineDevice(long oflineDevice){
        this.oflineDevice=oflineDevice;
    }  
    public long getMaintainceDevice(){
        return maintainceDevice;
    }
    public void setMaintainceDevice(long maintainceDevice){
        this.maintainceDevice=maintainceDevice;
    }
    public double getTotalPower(){
        return totalPower;
    }
    public void setTotalPower(long totalPower){
        this.totalPower=totalPower;
    }
    public double getTotalEnergy(){
        return totalEnergy;
    }
    public void setTotalEnergy(long totalEnergy){
        this.totalEnergy=totalEnergy;
    }
    

}
