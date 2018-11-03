package pl.coderslab.models;

import java.time.LocalDate;

public class Order {

    private LocalDate acceptanceForRepair;
    private LocalDate expectedStartOfRepair;
    private LocalDate startOfRepair;
    private Employee employee;
    private String detailsOfProblem;
    private String detailsOfRepair;
    private Status status;
    private Vehicle vehicle;

    public Order() {}

    public Order(LocalDate acceptanceForRepair, LocalDate expectedStartOfRepair, LocalDate startOfRepair,
                 Employee employee, String detailsOfProblem, String detailsOfRepair, Status status, Vehicle vehicle) {

        this.acceptanceForRepair = acceptanceForRepair;
        this.expectedStartOfRepair = expectedStartOfRepair;
        this.startOfRepair = startOfRepair;
        this.employee = employee;
        this.detailsOfProblem = detailsOfProblem;
        this.detailsOfRepair = detailsOfRepair;
        this.status = status;
        this.vehicle = vehicle;
    }
    public LocalDate getAcceptanceForRepair() {

        return acceptanceForRepair;
    }
    public void setAcceptanceForRepair(LocalDate acceptanceForRepair) {

        this.acceptanceForRepair = acceptanceForRepair;
    }
    public LocalDate getExpectedStartOfRepair() {
        return expectedStartOfRepair;
    }
    public void setExpectedStartOfRepair(LocalDate expectedStartOfRepair) {

        this.expectedStartOfRepair = expectedStartOfRepair;
    }
    public LocalDate getStartOfRepair() {
        return startOfRepair;
    }
    public void setStartOfRepair(LocalDate startOfRepair) {

        this.startOfRepair = startOfRepair;
    }
    public Employee getEmployee() {

        return employee;
    }
    public void setEmployee(Employee employee) {

        this.employee = employee;
    }
    public String getDetailsOfProblem() {

        return detailsOfProblem;
    }
    public void setDetailsOfProblem(String detailsOfProblem) {

        this.detailsOfProblem = detailsOfProblem;
    }
    public String getDetailsOfRepair() {

        return detailsOfRepair;
    }
    public void setDetailsOfRepair(String detailsOfRepair) {

        this.detailsOfRepair = detailsOfRepair;
    }
    public Status getStatus() {

        return status;
    }
    public void setStatus(Status status) {

        this.status = status;
    }
    public Vehicle getVehicle() {

        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {

        this.vehicle = vehicle;
    }
}
