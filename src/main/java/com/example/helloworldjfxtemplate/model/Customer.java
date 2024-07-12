package com.example.helloworldjfxtemplate.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Customer {

    private int custID;
    private String custName;
    private String custAddr;
    private String custPost;
    private String custPhone;
    private LocalDateTime custCreateDate;
    private String custCreatedBy;
    private Timestamp custLastUpdate;
    private String custLastUpdatedBy;
    private int custDivID;
    private String custCountryName;
    private String custDivName;
    private  int custCountryID;

    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone, LocalDateTime custCreateDate, String custCreatedBy,
                    Timestamp custLastUpdate, String custLastUpdatedBy, int custDivID) {
        this.custID = custID;
        this.custName = custName;
        this.custAddr = custAddr;
        this.custPost = custPost;
        this.custPhone = custPhone;
        this.custCreateDate = custCreateDate;
        this.custCreatedBy = custCreatedBy;
        this.custLastUpdate = custLastUpdate;
        this.custLastUpdatedBy = custLastUpdatedBy;
        this.custDivID = custDivID;
    }



    public Customer(int custID, String custName, String custAddr, String custPost, String custPhone,
                    String custCreatedBy, String custLastUpdatedBy, int custDivID, int custCountryID, String custDivName,
                    String custCountryName) {
        this.custID = custID;
        this.custName = custName;
        this.custAddr = custAddr;
        this.custPost = custPost;
        this.custPhone = custPhone;
        this.custCreatedBy = custCreatedBy;
        this.custLastUpdate = custLastUpdate;
        this.custLastUpdatedBy = custLastUpdatedBy;
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

    public String getCustCreatedBy() {
        return custCreatedBy;
    }

    public Timestamp getCustLastUpdate() {
        return custLastUpdate;
    }

    public String getCustLastUpdatedBy() {
        return custLastUpdatedBy;
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
