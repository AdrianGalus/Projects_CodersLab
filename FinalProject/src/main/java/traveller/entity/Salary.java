package traveller.entity;

import java.math.BigDecimal;

public class Salary {

    private Long id;
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
