package com.gridweaver.dto;

public class Alert {
    private Long deviceId;
    private String deviceName;
    private String type;
    private String message;
    private String severity;

    public Alert(){

    }
    public Alert (Long deviceId,
                  String deciceName,
                  String type,
                  String message,
                  String severity){
                    this.deviceId=deviceId;
                    this.deviceName=deciceName;
                    this.type=type;
                    this.message = message;
                    this.severity=severity;
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
        public String getType(){
            return type;
        }
        public void setType(String type){
            this.type=type;
        }
        public String getMessage() {
    return message;
}
        public void setMessage(String message){
            this.message=message;
        }
        public String getSeverity(){
            return severity;
        }
        public void setSeverity(String severity){
            this.severity=severity;
        }
    


}
