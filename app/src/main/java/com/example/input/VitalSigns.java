package com.example.input;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class VitalSigns implements Serializable {
    Integer heartRate;
    Integer respiratoryRate;
    Integer temperature;

    public Integer getHeartRate() {
        return heartRate;
    }

    public Integer getRespiratoryRate() {
        return respiratoryRate;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setHeartRate(Integer heartRate) {
        this.heartRate = heartRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }



    public VitalSigns() {

    }

    @NonNull
    @Override
    public String toString() {
        return " " + heartRate + "\n" +
                " " + respiratoryRate + "\n" +
                " " + temperature;
    }

    public VitalSigns(int HeartRate, int RespiratoryRate, int Temperature) {
        this.heartRate = HeartRate;
        this.respiratoryRate = RespiratoryRate;
        this.temperature = Temperature;
    }

//    @NonNull
//    @Override
//    public String toString() {
//        return "VitalSigns{" + heartRate + '\''
//                + respiratoryRate + '\''
//                + temperature + '\'' +
//                '}';
//    }

//    @Exclude
//    public Map<String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("heartRate", heartRate);
//        result.put("respiratoryRate", respiratoryRate);
//        result.put("temperature", temperature);
//
//        return result;
//    }

}
