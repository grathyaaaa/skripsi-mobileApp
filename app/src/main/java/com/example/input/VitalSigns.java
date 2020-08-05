package com.example.input;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class VitalSigns implements Serializable {
    String heartRate;
    String respiratoryRate;
    String temperature;

    public VitalSigns() {

    }

    public VitalSigns(String HeartRate, String RespiratoryRate, String Temperature) {
        this.heartRate = HeartRate;
        this.respiratoryRate = RespiratoryRate;
        this.temperature = Temperature;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(String respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @NonNull
    @Override
    public String toString() {
        return " " + heartRate + "\n" +
                " " + respiratoryRate + "\n" +
                " " + temperature;
    }

}
