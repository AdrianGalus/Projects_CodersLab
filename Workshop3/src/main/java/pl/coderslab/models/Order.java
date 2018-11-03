package pl.coderslab.models;

import java.time.LocalDate;

public class Order {

    private int id;
    private LocalDate acceptanceForRepair;
    private LocalDate expectedStartOfRepair;
    private LocalDate startOfRepair;
    private int employeeId;
    private String detailsOfProblem;
    private String detailsOfRepair;
    private String status;
    private int vehicleId;
    private double repairCost;
    private double replacementsCost;
    private double costPerHour;
    private double numberOfHours;

    public Order() {}

    public Order(LocalDate acceptanceForRepair, LocalDate expectedStartOfRepair, Employee employee,
                 String detailsOfProblem, String status, Vehicle vehicle) {

        this.acceptanceForRepair = acceptanceForRepair;
        this.expectedStartOfRepair = expectedStartOfRepair;
        this.employeeId = employee.getId();
        this.detailsOfProblem = detailsOfProblem;
        this.status = status;
        this.vehicleId = vehicle.getId();
        this.costPerHour = employee.getCostPerHour();
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
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
    public int getEmployeeId() {

        return employeeId;
    }
    public void setEmployeeId(int employeeId) {

        this.employeeId = employeeId;
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
    public String getStatus() {

        return status;
    }
    public void setStatus(String status) {

        this.status = status;
    }
    public int getVehicleId() {

        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {

        this.vehicleId = vehicleId;
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
