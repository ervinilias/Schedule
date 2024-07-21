package com.example.helloworldjfxtemplate.model;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Model class for customer
 */
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

    /**
     * Overloaded constructor for Customer
     * @param custID
     * @param custName
     * @param custAddr
     * @param custPost
     * @param custPhone
     * @param custCreateDate
     * @param custCreatedBy
     * @param custLastUpdate
     * @param custLastUpdatedBy
     * @param custDivID
     */
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

    /**
     * Overloaded contructor for Customer
     * @param custID
     * @param custName
     * @param custAddr
     * @param custPost
     * @param custPhone
     * @param custCreatedBy
     * @param custLastUpdatedBy
     * @param custDivID
     * @param custCountryID
     * @param custDivName
     * @param custCountryName
     */
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

    /**
     * Overloaded contructor for Customer that used in CustomerDAO to get Customer from Customer ID
     * @param searchCustomerID
     * @param customerName
     */
    public Customer(int searchCustomerID, String customerName) {
        this.custID = searchCustomerID;
        this.custName = customerName;
    }

    /**
     * getCustID getter for Customer ID
     * @return custID
     */
    public int getCustID() {
        return custID;
    }

    /**
     * getCustName getter for customer name
     * @return custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * getCustAddr getter for customer address
     * @return custAddr
     */
    public String getCustAddr() {
        return custAddr;
    }

    /**
     * getCustPost getter for customer postal code
     * @return custPost
     */
    public String getCustPost() {
        return custPost;
    }

    /**
     * getCustPhone getter for customer phone
     * @return custPhone
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * getCustCreatedBy getter for Created By
     * @return custCreatedBy
     */
    public String getCustCreatedBy() {
        return custCreatedBy;
    }

    /**
     * getCustLastUpdate getter for Last Update
     * @return custLastUpdate
     */
    public Timestamp getCustLastUpdate() {
        return custLastUpdate;
    }

    /**
     * getCustLastUpdatedBy getter for last updated by
     * @return custLastUpdatedBy
     */
    public String getCustLastUpdatedBy() {
        return custLastUpdatedBy;
    }

    /**
     * getCustDivID getter for Division ID
     * @return custDivID
     */
    public int getCustDivID() {
        return custDivID;
    }

    /**
     * getCustCountryID getter for Country ID
     * @return custCountryID
     */
    public int getCustCountryID() {
        return custCountryID;
    }

    /**
     * getCustDivName getter for Division name
     * @return custDivName
     */
    public String getCustDivName() {
        return custDivName;
    }

    /**
     * getCustCountryName getter for country name
     * @return custCountryName
     */
    public String getCustCountryName() {
        return custCountryName;
    }

    /**
     * Override toString to print custID - custName
     * @return custName
     */
    @Override
    public String toString() {
        return "#" + Integer.toString(custID) + " - " + custName;
    }


}
