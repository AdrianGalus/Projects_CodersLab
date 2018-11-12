package traveller.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Driver {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String pesel;
    private LocalDate bornDate;
    private LocalDate employmentDate;
    private Set<String> languages = new TreeSet<>();
    private Salary salary;
    private List<Tour> tours = new ArrayList<>();

    public Driver() {}

    public Driver(String firstName, String lastName, String phone, String email, String address, String pesel,
                  LocalDate bornDate, LocalDate employmentDate, Salary salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pesel = pesel;
        this.bornDate = bornDate;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        if(this.id == null) {
            this.id = id;
        }
    }
    public String getFirstName() {

        return firstName;
    }
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }
    public String getLastName() {

        return lastName;
    }
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }
    public String getPhone() {

        return phone;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getAddress() {

        return address;
    }
    public void setAddress(String address) {

        this.address = address;
    }
    public String getPesel() {

        return pesel;
    }
    public void setPesel(String pesel) {

        if(this.pesel == null) {
            this.pesel = pesel;
        }
    }
    public LocalDate getBornDate() {

        return bornDate;
    }
    public void setBornDate(LocalDate bornDate) {

        if(this.bornDate == null) {
            this.bornDate = bornDate;
        }
    }
    public LocalDate getEmploymentDate() {

        return employmentDate;
    }
    public void setEmploymentDate(LocalDate employmentDate) {

        if(this.employmentDate == null) {
            this.employmentDate = employmentDate;
        }
    }
    public Set<String> getLanguages() {

        return languages;
    }
    public void setLanguages(String language) {

        this.languages.add(language);
    }
    public Salary getSalary() {

        return salary;
    }
    public void setSalary(Salary salary) {

        this.salary = salary;
    }
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(Tour tour) {

        this.tours.add(tour);
    }
}
