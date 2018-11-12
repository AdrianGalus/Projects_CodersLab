package traveller.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tanks")
public class Tank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @NotNull
    @NotBlank
    private Coach coach;
    @NotNull
    @NotBlank
    private BigDecimal capacity;
    private BigDecimal currentQuantity;
    @OneToMany
    private List<Refueling> refuelings = new ArrayList<>();

    public Tank() {}

    public Tank(Coach coach, BigDecimal capacity, BigDecimal currentQuantity) {

        this.coach = coach;
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
    public Coach getCoach() {

        return coach;
    }
    public void setCoach(Coach coach) {

        if(this.coach == null) {
            this.coach = coach;
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
