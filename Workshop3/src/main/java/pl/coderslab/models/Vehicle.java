package pl.coderslab.models;

import java.time.LocalDate;

public class Vehicle {

    private String model;
    private String mark;
    private int buildYear;
    private String registrationNumber;
    private LocalDate nextInspection;

    public Vehicle() {}

    public Vehicle(String model, String mark, int buildYear, String registrationNumber, LocalDate nextInspection) {

        this.model = model;
        this.mark = mark;
        this.buildYear = buildYear;
        this.registrationNumber = registrationNumber;
        this.nextInspection = nextInspection;
    }
    public String getModel() {

        return model;
    }
    public void setModel(String model) {

        this.model = model;
    }
    public String getMark() {

        return mark;
    }
    public void setMark(String mark) {

        this.mark = mark;
    }
    public int getBuildYear() {

        return buildYear;
    }
    public void setBuildYear(int buildYear) {

        this.buildYear = buildYear;
    }
    public String getRegistrationNumber() {

        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {

        this.registrationNumber = registrationNumber;
    }
    public LocalDate getNextInspection() {

        return nextInspection;
    }
    public void setNextInspection(LocalDate nextInspection) {

        this.nextInspection = nextInspection;
    }
}
