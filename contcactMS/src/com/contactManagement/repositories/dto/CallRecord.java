package com.contactManagement.repositories.dto;

public class CallRecord {
    private String name;
    private String contactNo;
    private String callInitializationTime;
    private String callEndTime;
    private String callDuration;

    CallRecord(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public String getCallEndTime() {
        return callEndTime;
    }

    public void setCallInitializationTime(String callInitializationTime) {
        this.callInitializationTime = callInitializationTime;
    }

    public String getName() {
        return name;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCallInitializationTime() {
        return callInitializationTime;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }

    public void setCallEndTime(String callEndTime) {
        this.callEndTime = callEndTime;
    }

}
