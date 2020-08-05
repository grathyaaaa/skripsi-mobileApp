package com.example.input;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class RiskFactors implements Serializable {

    String name;
    String age;
    boolean gender;
    boolean hypertension;
    boolean heartDisease;
    boolean dm;
    boolean smoking;

    public RiskFactors() {

    }

    public RiskFactors(String Name, String Age, boolean Gender, boolean Hypertension, boolean HeartDisease, boolean Dm, boolean Smoking) {
        name = Name;
        age = Age;
        gender = Gender;
        hypertension = Hypertension;
        heartDisease = HeartDisease;
        dm = Dm;
        smoking = Smoking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isHypertension() {
        return hypertension;
    }

    public void setHypertension(boolean hypertension) {
        this.hypertension = hypertension;
    }

    public boolean isHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    public boolean isDm() {
        return dm;
    }

    public void setDm(boolean dm) {
        this.dm = dm;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    @NonNull
    @Override
    public String toString() {
        return " " + name + "\n" +
                " " + age + "\n" +
                " " + gender + "\n" +
                " " + hypertension + "\n" +
                " " + heartDisease + "\n" +
                " " + dm + "\n" +
                " " + smoking;
    }
}
