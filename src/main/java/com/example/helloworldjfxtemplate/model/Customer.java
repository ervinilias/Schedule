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

    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone,
                    String createdBy, String lastUpdatedBy, int custDivID, int custCountryID, String custDivName,
                    String custCountryName) {
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

    public Customer(int customerID, String customerName, String customerAddress, String customerPostalCode,
                    String customerPhone, int divisionID, String divisionName) {
        this.custID = customerID;
        this.custName = customerName;
        this.custAddr = customerAddress;
        this.custPost = customerPostalCode;
        this.custPhone = customerPhone;
        this.lastUpdate = lastUpdate;
        this.custDivID = divisionID;
        this.custDivName = divisionName;

    }

    public int getCustID() {
        return custID;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public String getCustPost() {
        return custPost;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public int getCustDivID() {
        return custDivID;
    }

    public int getCustCountryID() {
        return custCountryID;
    }

    public String getCustDivName() {
        return custDivName;
    }

    public String getCustCountryName() {
        return custCountryName;
    }

    @Override
    public String toString() {
        return "#" + Integer.toString(custID) + " - " + custName;
    }


}
