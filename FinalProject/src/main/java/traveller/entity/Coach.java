package traveller.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Coach {

    private Long id;
    private String registerNumber;
    private String mark;
    private String model;
    private Driver driver1;
    private Driver driver2;
    private List<Tour> tours = new ArrayList<>();
    private LocalDate productionDate;
    private LocalDate purchaseDate;
    private BigDecimal price;
    private CoachKmCounter kmCounter;
    private Tank tank;
    private Integer seats;

    public Coach() {}

    public Coach(String registerNumber, String mark, String model, Driver driver1, Driver driver2, LocalDate productionDate,
                 LocalDate purchaseDate, BigDecimal price, CoachKmCounter kmCounter, Tank tank, Integer seats) {

        this.registerNumber = registerNumber;
        this.mark = mark;
        this.model = model;
        this.driver1 = driver1;
        this.driver2 = driver2;
        this.productionDate = productionDate;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.kmCounter = kmCounter;
        this.tank = tank;
        this.seats = seats;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getRegisterNumber() {

        return registerNumber;
    }
    public void setRegisterNumber(String registerNumber) {

        this.registerNumber = registerNumber;
    }
    public String getMark() {

        return mark;
    }
    public void setMark(String mark) {

        if(this.mark == null) {
            this.mark = mark;
        }
    }
    public String getModel() {

        return model;
    }
    public void setModel(String model) {

        if(this.model == null) {
            this.model = model;
        }
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
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(List<Tour> tours) {

        if(this.tours == null) {
            this.tours = tours;
        }
    }
    public LocalDate getProductionDate() {

        return productionDate;
    }
    public void setProductionDate(LocalDate productionDate) {

        if(this.productionDate == null) {
            this.productionDate = productionDate;
        }
    }
    public LocalDate getPurchaseDate() {

        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {

        if(this.purchaseDate == null) {
            this.purchaseDate = purchaseDate;
        }
    }
    public BigDecimal getPrice() {

        return price;
    }
    public void setPrice(String price) {

        if(this.price == null) {
            this.price = new BigDecimal(price);
        }
    }
    public CoachKmCounter getKmCounter() {

        return kmCounter;
    }
    public void setKmCounter(String kmCounter) {

        if(this.kmCounter == null) {
            this.kmCounter = new CoachKmCounter(new BigDecimal(kmCounter));
        }
        else {
            this.kmCounter.setKmCounter(kmCounter);
        }
    }
    public Tank getTank() {

        return tank;
    }
    public void setTank(Tank tank) {

        if(this.tank == null) {
            this.tank = tank;
        }
    }
    public Integer getSeats() {

        return seats;
    }
    public void setSeats(Integer seats) {

        this.seats = seats;
    }
}
