package traveller.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private BigDecimal salary;
    private BigDecimal hourlyWage;

    public Salary() {}

    public Salary(BigDecimal salary, BigDecimal hourlyWage) {

        this.salary = salary;
        this.hourlyWage = hourlyWage;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public User getUser() {

        return user;
    }
    public void setUser(User user) {

        if(this.user == null) {
            this.user = user;
        }
    }
    public BigDecimal getSalary() {

        return salary;
    }
    public void setSalary(String salary) {

        this.salary = new BigDecimal(salary);
    }
    public BigDecimal getHourlyWage() {

        return hourlyWage;
    }
    public void setHourlyWage(String hourlyWage) {

        this.hourlyWage = new BigDecimal(hourlyWage);
    }
}
