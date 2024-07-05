package com.example.helloworldjfxtemplate.model;

import java.time.LocalDateTime;

public class Customer {
    private int custID;
    private String custName;
    private String custAddr;
    private String custPost;
    private String custPhone;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int custDivID;
    private int custCountryID;
    private String custDivName;
    private String custCountryName;

    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy, int custDivID, int custCountryID, String custDivName, String custCountryName) {
        this.custID = custID;
        this.custName = custName;
        this.custAddr = custAddr;
        this.custPost = custPost;
        this.custPhone = custPhone;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.custDivID = custDivID;
        this.custCountryID = custCountryID;
        this.custDivName = custDivName;
        this.custCountryName = custCountryName;
    }

    public Customer(int custID, String custName) {
        this.custID = custID;
        this.custName = custName;
    }

    public int getCustomerID() {
        return custID;
    }

    public String getCustomerName() {
        return custName;
    }

    public String getCustomerAddress() {
        return custAddr;
    }

    public String getCustomerPostalCode() {
        return custPost;
    }

    public int getCustomerDivisionID() {
        return custDivID;
    }

    public int getCustomerCountryID() {
        return custCountryID;
    }

    public String getCustomerPhone() {
        return custPhone;
    }

    @Override
    public String toString() {
        return "#" + Integer.toString(custID) + " - " + custName;
    }


}
