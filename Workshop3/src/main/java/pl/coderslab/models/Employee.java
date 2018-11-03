package pl.coderslab.models;

public class Employee {

    private String name;
    private String surname;
    private String address;
    private String phone;
    private String note;
    private double costPerHour;

    public Employee() {}

    public Employee(String name, String surname, String address, String phone, String note, double costPerHour) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.costPerHour = costPerHour;
    }
    public String getName() {

        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getSurname() {

        return surname;
    }
    public void setSurname(String surname) {

        this.surname = surname;
    }
    public String getAddress() {

        return address;
    }
    public void setAddress(String address) {

        this.address = address;
    }
    public String getPhone() {

        return phone;
    }
    public void setPhone(String phone) {

        this.phone = phone;
    }
    public String getNote() {

        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public double getCostPerHour() {

        return costPerHour;
    }
    public void setCostPerHour(double costPerHour) {

        this.costPerHour = costPerHour;
    }
}
