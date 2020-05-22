package com.christina.gui.wvr_gui.model;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="schedule")
public class ModelSchedule {
    @Id
    public String bookingID;
    public String plate_Number;
    public String customerID;
    public Date pickupDate;
    public Date dropoffDate;


    public ModelSchedule() {
    }

    public ModelSchedule(String bookingID, String plate_Number, String customerID, Date pickupDate, Date dropoffDate) {
        this.bookingID = bookingID;
        this.plate_Number = plate_Number;
        this.customerID = customerID;
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
    }

    @Override
    public String toString() {
        return "ModelSchedule{" +
                "bookingID='" + bookingID + '\'' +
                ", plate_Number='" + plate_Number + '\'' +
                ", customerID='" + customerID + '\'' +
                ", pickupDate=" + pickupDate +
                ", dropoffDate=" + dropoffDate +
                '}';
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getPlate_Number() {
        return plate_Number;
    }

    public void setPlate_Number(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}
