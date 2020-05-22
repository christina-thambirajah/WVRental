import javax.persistence.Entity;
import java.io.Serializable;

@Entity
//used to show that this class is a seperate table or entity in sql
public class Motor_Bike extends Vehicle implements Serializable {
    //unique instance variables
    private boolean isScooterType;
    private boolean hasStorage;

    //default constructor
    public Motor_Bike() {
        super();
    }

    //relavant getters and setters
    public boolean getisScooterType() {
        return isScooterType;
    }

    public boolean getHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    public void setScooterType(boolean scooterType) {

        isScooterType = scooterType;
    }

    @Override
    public String toString() {
        return "Motor_Bike{" +
                "hasStorage=" + hasStorage +
                ", plate_Number='" + plate_Number + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ratePerDay=" + ratePerDay +
                '}';
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }
}