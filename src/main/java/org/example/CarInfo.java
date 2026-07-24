package org.example;

import java.util.Date;

public class CarInfo {

    //we need to store the data that the radar will read it and capture it
    private String plateNumber;
    private Date snapShoted;
    private CarType carType;//and it is will be enum
    private int speed;
    private boolean seatBeltStatus;



    //now lets define the constructor
    public CarInfo(String plateNumber, Date snapShoted, CarType carType, int speed, boolean seatBeltStatus) {
        this.plateNumber = plateNumber;
        this.snapShoted = snapShoted;
        this.carType = carType;
        this.speed = speed;
        this.seatBeltStatus = seatBeltStatus;
    }


    //and now lets getters and setters cause the attributes are private cause encapsulation
    public String getPlateNumber() {
        return plateNumber;
    }

    public Date getSnapShoted() {
        return snapShoted;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isSeatBeltStatus() {
        return seatBeltStatus;
    }









}
