package model;

import java.sql.Date;

public class Vehicle {
    private String licensePlate;
    private String ownerId;
    private String type;
    private String parkingSpot;
    private Date parkingDate;
    private Date checkInTime;
    private Date checkOutTime;
    private double fee;
    public Vehicle(){}
    public Vehicle(String licensePlate, String ownerId, String type, String parkingSpot, Date parkingDate, Date checkInTime, Date checkOutTime, double fee) {
        this.licensePlate = licensePlate;
        this.ownerId = ownerId;
        this.type = type;
        this.parkingSpot = parkingSpot;
        this.parkingDate = parkingDate;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.fee = fee;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getType() {
        return type;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public Date getParkingDate() {
        return parkingDate;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public double getFee() {
        return fee;
    }
}
