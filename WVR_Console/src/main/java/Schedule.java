import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Entity
//used to show that this class is a seperate table or entity in sql
public class Schedule implements Serializable {

    //instance variables
    @Id//the primary key
    private String bookingID;
    private String plate_Number;
    private String customerID;
    private Date pickupDate;
    private Date dropoffDate;

    public Schedule() {

    }

    @Override
    public String toString() {
        return "Schedule{" +
                "bookingID='" + bookingID + '\'' +
                ", plate_Number='" + plate_Number + '\'' +
                ", customerID='" + customerID + '\'' +
                ", pickupDate=" + pickupDate +
                ", dropoffDate=" + dropoffDate +
                '}';
    }

    public Schedule(Date pickupDate, Date dropoffDate) {
        this.pickupDate = pickupDate;
        this.dropoffDate = dropoffDate;
    }

    //relevant getters and setters

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }


}