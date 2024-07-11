package com.example.helloworldjfxtemplate.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Customer {

    private int custID;
    private String custName;
    private String custAddr;
    private String custPost;
    private String custPhone;
    private LocalDateTime createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    private int custDivID;
    private String custCountryName;
    private String custDivName;
    private  int custCountryID;

    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone, LocalDateTime createDate, String createdBy,
                    Timestamp lastUpdate, String lastUpdatedBy, int custDivID) {
        this.custID = custID;
        this.custName = custName;
        this.custAddr = custAddr;
        this.custPost = custPost;
        this.custPhone = custPhone;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.custDivID = custDivID;
    }



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

    public Timestamp getLastUpdate() {
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
