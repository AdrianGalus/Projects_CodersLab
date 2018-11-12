package traveller.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tank {

    private Long id;
    private BigDecimal capacity;
    private BigDecimal currentQuantity;
    private List<Refueling> refuelings = new ArrayList<>();

    public Tank() {}

    public Tank(BigDecimal capacity, BigDecimal currentQuantity) {

        this.capacity = capacity;
        this.currentQuantity = currentQuantity;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        if(this.id == null) {
            this.id = id;
        }
    }
    public BigDecimal getCapacity() {

        return capacity;
    }
    public void setCapacity(String capacity) {

        if(this.capacity == null) {
            this.capacity = new BigDecimal(capacity);
        }
    }
    public BigDecimal getCurrentQuantity() {

        return currentQuantity;
    }
    public void setCurrentQuantity(String currentQuantity) {

        this.currentQuantity = new BigDecimal(currentQuantity);
    }
    public List<Refueling> getRefuelings() {

        return refuelings;
    }
    public void setRefuelings(Refueling refueling) {

        this.refuelings.add(refueling);
    }
}
