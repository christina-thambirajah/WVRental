import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
@Entity
//used to show that this class is a seperate table or entity in sql
public class Car extends Vehicle implements Serializable {
    private boolean hasAC;
    private int noOfSeats;

    //default constructor
    public Car() {
        super();
    }

    public Car(String plate_Number, String make, String model, String color, BigDecimal ratePerDay, boolean isRented, boolean hasAC, int noOfSeats) {
        super( plate_Number, make, model, color, ratePerDay, isRented );
        this.hasAC = hasAC;
        this.noOfSeats = noOfSeats;
    }

    public Car(String plate_Number) {
        super( plate_Number );
    }

    @Override
    public String toString() {
        return "Car{" +
                "noOfSeats=" + noOfSeats +
                ", plate_Number='" + plate_Number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ratePerDay=" + ratePerDay +
                '}';
    }

    //relavant getters and setters
    public boolean getHasAC() {
        return hasAC;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }



}



