import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.math.BigDecimal;

// Generalization used - this is the parent class of Car and Motor_Bike
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle implements Comparable<Vehicle>, Serializable {
    @Id
    public String plate_Number;
    public String make;
    public String model;
    public String color;
    public BigDecimal ratePerDay;

    //default constructor
    public Vehicle() {
        super();
    }

    public Vehicle(String plate_Number, String make, String model, String color, BigDecimal ratePerDay, boolean isRented) {
        this.plate_Number = plate_Number;
        this.make = make;
        this.model = model;
        this.color = color;
        this.ratePerDay = ratePerDay;

    }

    public Vehicle(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    //relevant getters and setters
    public void setPlate_Number(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate_Number() {
        return plate_Number;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getColor() {
        return color;
    }

    public void setratePerDay(BigDecimal ratePerDay) {
        this.ratePerDay = ratePerDay;
    }


}