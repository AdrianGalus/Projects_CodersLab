package traveller.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoachKmCounter {

    private Long id;
    private Coach coach;
    private BigDecimal kmCounter;
    private List<Refueling> refuelings = new ArrayList<>();

    public CoachKmCounter() {}

    public CoachKmCounter(Coach coach, BigDecimal kmCounter) {

        this.coach = coach;
        this.kmCounter = kmCounter;
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
    public BigDecimal getKmCounter() {

        return kmCounter;
    }
    public void setKmCounter(String kmCounter) {

        if(this.kmCounter == null) {
            this.kmCounter = new BigDecimal(kmCounter);
        }
        else {
            this.kmCounter.add(new BigDecimal(kmCounter));
        }
    }
    public List<Refueling> getRefuelings() {

        return refuelings;
    }
    public void setRefuelings(Refueling refuelings) {

        this.refuelings.add(refuelings);
    }
}
