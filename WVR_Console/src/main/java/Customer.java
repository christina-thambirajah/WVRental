import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Entity
//used to show that this class is a seperate table or entity in sql
public class Customer implements Serializable {
    //Instance variables
    @Id
    //the primary key
    private String customerID;
    private String fName;
    private String lName;
    private String address;
    private String contactNo;
    private String nicNo;
    //variables used for Login


    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", nicNo='" + nicNo + '\'' +
                '}';
    }

    //relavant getters and setters
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAdress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }



}