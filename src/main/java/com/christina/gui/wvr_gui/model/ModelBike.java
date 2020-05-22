package com.christina.gui.wvr_gui.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name="motor_bike")
public class ModelBike {
    @Id
    public String plate_Number;
    public String make;
    public String model;
    public String color;
    public BigDecimal ratePerDay;
    private boolean hasStorage;
    private boolean isScooterType;

    public ModelBike() {
    }

    public ModelBike(String plate_Number, String make, String model, String color, BigDecimal ratePerDay, boolean hasStorage, boolean isScooterType) {
        this.plate_Number = plate_Number;
        this.make = make;
        this.model = model;
        this.color = color;
        this.ratePerDay = ratePerDay;
        this.hasStorage = hasStorage;
        this.isScooterType = isScooterType;
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

    public boolean isScooterType() {
        return isScooterType;
    }

    public void setScooterType(boolean scooterType) {
        isScooterType = scooterType;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    @Override
    public String toString() {
        return "ModelBike{" +
                "plate_Number='" + plate_Number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ratePerDay=" + ratePerDay +
                ", hasStorage=" + hasStorage +
                ", isScooterType=" + isScooterType +
                '}';
    }
}
