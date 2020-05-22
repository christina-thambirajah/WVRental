package com.christina.gui.wvr_gui.model;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="car")
public class ModelCar {
@Id
private String plate_Number;
    private String make;
    private String model;
    private String color;
    public BigDecimal ratePerDay;
    private boolean hasAC;
    private int noOfSeats;

    public ModelCar() {
    }
    @PersistenceConstructor
    public ModelCar(String plate_Number, String make, String model, String color, BigDecimal ratePerDay, boolean isRented, boolean hasAC, int noOfSeats) {
        this.plate_Number = plate_Number;
        this.make = make;
        this.model = model;
        this.color = color;
        this.ratePerDay = ratePerDay;
        this.hasAC = hasAC;
        this.noOfSeats = noOfSeats;
    }

    public String getPlate_Number() {
        return plate_Number;
    }

    public void setPlate_Number(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(BigDecimal ratePerDay) {
        this.ratePerDay = ratePerDay;
    }


    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public String toString() {
        return "ModelCar{" +
                "plate_Number='" + plate_Number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ratePerDay=" + ratePerDay +
                ", hasAC=" + hasAC +
                ", noOfSeats=" + noOfSeats +
                '}';
    }
}
