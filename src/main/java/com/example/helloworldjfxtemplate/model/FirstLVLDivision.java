package com.example.helloworldjfxtemplate.model;
import java.time.LocalDateTime;

/**
 * Model for FirstLVLDivision
 */
public class FirstLVLDivision {
    private int divisionID;
    private String divisionName;
    private int countryID;

    /**
     * Overloaded FirstLVLDivision contructor
     * @param divisionID
     * @param divisionName
     */
    public FirstLVLDivision(int divisionID, String divisionName) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
    }

    /**
     * Overloaded FirstLVLDivision contructor
     * @param divisionID
     * @param divisionName
     * @param countryID
     */
    public FirstLVLDivision(int divisionID, String divisionName, int countryID) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }

    /**
     * Overloaded FirstLVLDivision contructor
     * @param divisionID
     * @param divisionName
     * @param countryID
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     */
    public FirstLVLDivision(int divisionID, String divisionName, int countryID, LocalDateTime createDate,
                            String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy) {
        this.divisionID = divisionID;
        this.divisionName = divisionName;
        this.countryID = countryID;
    }

    /**
     * getDivisionID getter for division ID
     * @return divisionID
     */
    public int getDivisionID() {
        return divisionID;
    }

    /**
     * setDivisionID setter for division ID
     * @param divisionID
     */
    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    /**
     * getDivisionName getter for division name
     * @return divisionName
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * setDivisionName setter for division name
     * @param divisionName
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * getCountryID getter for country ID
     * @return countryID
     */
    public int getCountryID() {
        return countryID;
    }

    /**
     * setCountryID setter for country ID
     * @param countryID
     */
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    /**
     * Override toString to print division name
     * @return
     */
    @Override
    public String toString() {
        return divisionName;
    }
}
