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
    private double repairCost;
    private double replacementsCost;
    private double costPerHour;
    private double numberOfHours;

    public Order() {}

    public Order(LocalDate acceptanceForRepair, LocalDate expectedStartOfRepair, Employee employee,
                 String detailsOfProblem, Status status, Vehicle vehicle) {

        this.acceptanceForRepair = acceptanceForRepair;
        this.expectedStartOfRepair = expectedStartOfRepair;
        this.employee = employee;
        this.detailsOfProblem = detailsOfProblem;
        this.status = status;
        this.vehicle = vehicle;
        this.costPerHour = this.employee.getCostPerHour();
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
    public double getRepairCost() {

        return repairCost;
    }
    public void setRepairCost(double repairCost) {

        this.repairCost = repairCost;
    }
    public double getReplacementsCost() {

        return replacementsCost;
    }
    public void setReplacementsCost(double replacementsCost) {

        this.replacementsCost = replacementsCost;
    }
    public double getCostPerHour() {

        return costPerHour;
    }
    public void setCostPerHour(double costPerHour) {

        this.costPerHour = costPerHour;
    }
    public double getNumberOfHours() {

        return numberOfHours;
    }
    public void setNumberOfHours(double numberOfHours) {

        this.numberOfHours = numberOfHours;
    }
}
