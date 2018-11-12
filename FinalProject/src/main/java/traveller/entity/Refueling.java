package traveller.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "refuelings")
public class Refueling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private LocalDateTime refuelingDate;
    @NotNull
    @NotBlank
    private BigDecimal fuelQuantity;
    @NotNull
    @NotBlank
    private BigDecimal cost;
    @NotNull
    @NotBlank
    @ManyToOne
    private Tank tank;
    @NotNull
    @NotBlank
    @ManyToOne
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
    public void setCoachKmCounter(CoachKmCounter coachKmCounter) {

        if(this.coachKmCounter == null) {
            this.coachKmCounter = coachKmCounter;
        }
    }
}
