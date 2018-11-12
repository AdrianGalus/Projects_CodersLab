package traveller.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Refueling {

    private Long id;
    private LocalDateTime refuelingDate;
    private BigDecimal fuelQuantity;
    private BigDecimal cost;
    private CoachKmCounter coachKmCounter;

    public Refueling() {}

    public Refueling(LocalDateTime refuelingDate, BigDecimal fuelQuantity, BigDecimal cost, CoachKmCounter coachKmCounter) {

        this.refuelingDate = refuelingDate;
        this.fuelQuantity = fuelQuantity;
        this.cost = cost;
        this.coachKmCounter = coachKmCounter;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        if(this.id == null) {
            this.id = id;
        }
    }
    public LocalDateTime getRefuelingDate() {

        return refuelingDate;
    }
    public void setRefuelingDate(LocalDateTime refuelingDate) {

        if(this.refuelingDate == null) {
            this.refuelingDate = refuelingDate;
        }
    }
    public BigDecimal getFuelQuantity() {

        return fuelQuantity;
    }
    public void setFuelQuantity(String fuelQuantity) {

        if(this.fuelQuantity == null) {
            this.fuelQuantity = new BigDecimal(fuelQuantity);
        }
    }
    public BigDecimal getCost() {

        return cost;
    }
    public void setCost(String cost) {

        if(this.cost == null) {
            this.cost = new BigDecimal(cost);
        }
    }
    public CoachKmCounter getCoachKmCounter() {

        return coachKmCounter;
    }
    public void setKmCounter(String kmCounter) {

        if(this.coachKmCounter == null) {
            this.coachKmCounter = new CoachKmCounter(new BigDecimal(kmCounter));
        }
        else {
            this.coachKmCounter.setKmCounter(kmCounter);
        }
    }
}
