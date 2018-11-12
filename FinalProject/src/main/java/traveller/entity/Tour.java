package traveller.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tour {

    private Long id;
    private Customer customer;
    private Coach coach;
    private Driver driver1;
    private Driver driver2;
    private LocalDate orderDate;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String destination;
    private BigDecimal distance;
    private BigDecimal cost;
    private Boolean paid;

    public Tour() {}

    public Tour(Customer customer, Coach coach, Driver driver1, Driver driver2, LocalDate orderDate,
                LocalDateTime departureDate, LocalDateTime arrivalDate, String destination, BigDecimal distance,
                BigDecimal cost, Boolean paid) {

        this.customer = customer;
        this.coach = coach;
        this.driver1 = driver1;
        this.setDriver2(driver2);
        this.orderDate = orderDate;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.destination = destination;
        this.distance = distance;
        this.cost = cost;
        this.paid = paid;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        if(this.id == null) {
            this.id = id;
        }
    }
    public Customer getCustomer() {

        return customer;
    }
    public void setCustomer() {

        this.customer = customer;
    }
    public Coach getCoach() {

        return coach;
    }
    public void setCoach(Coach coach) {

        this.coach = coach;
    }
    public Driver getDriver1() {

        return driver1;
    }
    public void setDriver1(Driver driver1) {

        this.driver1 = driver1;
    }
    public Driver getDriver2() {

        return driver2;
    }
    public void setDriver2(Driver driver2) {

        if(this.driver1 != null) {
            this.driver2 = driver2;
        }
        else {
            this.driver1 = driver2;
        }
    }
    public LocalDate getOrderDate() {

        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {

        if(this.orderDate == null) {
            this.orderDate = orderDate;
        }
    }
    public LocalDateTime getDepartureDate() {

        return departureDate;
    }
    public void setDepartureDate(LocalDateTime departureDate) {

        this.departureDate = departureDate;
    }
    public LocalDateTime getArrivalDate() {

        return arrivalDate;
    }
    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public String getDestination() {

        return destination;
    }
    public void setDestination(String destination) {

        this.destination = destination;
    }
    public BigDecimal getDistance() {

        return distance;
    }
    public void setDistance(String distance) {

        this.distance = new BigDecimal(distance);
    }
    public BigDecimal getCost() {

        return cost;
    }
    public void setCost(String cost) {

        this.cost = new BigDecimal(cost);
    }
    public Boolean getPaid() {

        return paid;
    }
    public void setPaid(Boolean paid) {

        this.paid = paid;
    }
}
