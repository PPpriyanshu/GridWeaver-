package com.gridweaver.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "telemetry")
public class Telemetry {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private double voltage;
    private double current;
    private double power;
    private double energy;
    private double temperature;
    private LocalDateTime timestamp;
    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    public Telemetry() {
    }

    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public Device getDevice(){
        return device;
    }
    public void setDevice(Device device){
        this.device=device;
    }
    public double getVoltage() {
        return voltage;
    }
    public void setVoltage(double voltage){
        this.voltage=voltage;

    }
    public double getPower(){
        return power;
    }
    public void setPower(double power){
        this.power=power;
    }
    public double getEnergy(){
        return energy;
    }
    public void setEnergy(double energy){
        this.energy=energy;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
    }
    public double getTemperature(){
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp=timestamp;
    }
    
}