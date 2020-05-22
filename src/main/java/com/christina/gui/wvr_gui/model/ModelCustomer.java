package com.christina.gui.wvr_gui.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class ModelCustomer {
    @Id
    private String customerID;
    private String fName;
    private String lName;
    private String address;
    private String contactNo;
    private String nicNo;

    public ModelCustomer(String customerID, String fName, String lName, String address, String contactNo, String nicNo) {
        this.customerID = customerID;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.contactNo = contactNo;
        this.nicNo = nicNo;
    }

    public ModelCustomer() {
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    @Override
    public String toString() {
        return "ModelCustomer{" +
                "customerID='" + customerID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", nicNo='" + nicNo + '\'' +
                '}';
    }
}
