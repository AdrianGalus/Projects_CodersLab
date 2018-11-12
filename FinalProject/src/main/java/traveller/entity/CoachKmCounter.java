package traveller.entity;

import java.math.BigDecimal;

public class CoachKmCounter {

    private Long id;
    private BigDecimal kmCounter;

    public CoachKmCounter() {}

    public CoachKmCounter(BigDecimal kmCounter) {

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
}
