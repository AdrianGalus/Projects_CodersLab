package traveller.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String nip;
    private String regon;
    private List<Tour> tours = new ArrayList<>();

    public Customer() {}

    public Customer(String firstName, String lastName, String phone, String email, String address, String nip, String regon) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.nip = nip;
        this.regon = regon;
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
    public String getNip() {

        return nip;
    }
    public void setNip(String nip) {

        this.nip = nip;
    }
    public String getRegon() {

        return regon;
    }
    public void setRegon(String regon) {

        this.regon = regon;
    }
    public List<Tour> getTours() {

        return tours;
    }
    public void setTours(Tour order) {

        this.tours.add(order);
    }
}
