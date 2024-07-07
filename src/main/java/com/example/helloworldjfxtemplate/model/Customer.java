package com.example.helloworldjfxtemplate.model;

import java.time.LocalDateTime;

public class Customer {
    private int CustID;
    private String CustName;
    private String CustAddr;
    private String CustPost;
    private String CustPhone;
    private LocalDateTime CreateDate;
    private String CreatedBy;
    private LocalDateTime LastUpdate;
    private String LastUpdatedBy;
    private int CustDivID;
    private int CustCountryID;
    private String CustDivName;
    private String CustCountryName;

    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone,
                    String createdBy, String lastUpdatedBy, int custDivID, int custCountryID, String custDivName,
                    String custCountryName) {
        this.CustID = custID;
        this.CustName = custName;
        this.CustAddr = custAddr;
        this.CustPost = custPost;
        this.CustPhone = custPhone;
        this.CreatedBy = createdBy;
        this.LastUpdate = LastUpdate;
        this.LastUpdatedBy = lastUpdatedBy;
        this.CustDivID = custDivID;
        this.CustCountryID = custCountryID;
        this.CustDivName = custDivName;
        this.CustCountryName = custCountryName;
    }

    public Customer(int custID, String custName) {
        this.CustID = custID;
        this.CustName = custName;
    }

    public Customer(int customerID, String customerName, String customerAddress, String customerPostalCode,
                    String customerPhone, int divisionID, String divisionName) {
        this.CustID = customerID;
        this.CustName = customerName;
        this.CustAddr = customerAddress;
        this.CustPost = customerPostalCode;
        this.CustPhone = customerPhone;
        this.LastUpdate = LastUpdate;
        this.CustDivID = divisionID;
        this.CustDivName = divisionName;

    }

    public int getCustID() {
        return CustID;
    }

    public String getCustName() {
        return CustName;
    }

    public String getCustAddr() {
        return CustAddr;
    }

    public String getCustPost() {
        return CustPost;
    }

    public String getCustPhone() {
        return CustPhone;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public LocalDateTime getLastUpdate() {
        return LastUpdate;
    }

    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    public int getCustDivID() {
        return CustDivID;
    }

    public int getCustCountryID() {
        return CustCountryID;
    }

    public String getCustDivName() {
        return CustDivName;
    }

    public String getCustCountryName() {
        return CustCountryName;
    }

    @Override
    public String toString() {
        return "#" + Integer.toString(CustID) + " - " + CustName;
    }


}
