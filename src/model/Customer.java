package model;

import java.sql.Date;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private Date registrationDate;
    private int rent;

    public Customer(){}
    public Customer(String id, String name, String phone, Date registrationDate, int rent) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.registrationDate = registrationDate;
        this.rent = rent;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public int getRent() {
        return rent;
    }
}
