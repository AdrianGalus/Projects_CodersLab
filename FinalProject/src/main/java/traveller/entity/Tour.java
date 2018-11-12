package traveller.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tour {

    private Long id;
    private Customer customer;
    private LocalDate orderDate;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private String destination;
    private BigDecimal distance;
    private BigDecimal cost;
    private Boolean paid;

    public Tour() {}

    public Tour(Customer customer, LocalDate orderDate, LocalDateTime departureDate, LocalDateTime arrivalDate,
                String destination, BigDecimal distance, BigDecimal cost, Boolean paid) {

        this.customer = customer;
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
