package com.contactManagement.repositories.dto;

public class CallRecord {
    private String name;
    private String contactNo;
    private String callInitializationTime;
    private String callEndTime;
    private String callDuration;

    // --- NEW FIELDS ---
    private String date;
    private String time;
    // ------------------

    public CallRecord(){
    }

    // --- NEW GETTERS AND SETTERS ---
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    // -------------------------------

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