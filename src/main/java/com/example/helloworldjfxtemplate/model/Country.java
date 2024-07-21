package com.example.helloworldjfxtemplate.model;

/**
 * Model class for Country
 */
public class Country {
    private int countryID;
    private String countryName;
    private int countryMonthTotal;
    private String countryMonth;

    /**
     * Overloaded constructor for Country to get appointment total count for a country
     * @param countryMonth
     * @param countryMonthTotal
     */
    public Country(String countryMonth, int countryMonthTotal) {
        this.countryMonth = countryMonth;
        this.countryMonthTotal = countryMonthTotal;
    }


    /**
     * Overloaded constructor that gets all countries ID and names to an observablelist in CountryDAO
     * @param countryID
     * @param countryName
     */
    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
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
     * getCountryName getter for country name
     * @return countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * setCountryName setter for country name
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * getCountryMonthTotal getter for Month Total
     * @return countryMonthTotal
     */
    public int getCountryMonthTotal() {
        return countryMonthTotal;
    }

    /**
     * setCountryMonthTotal setter for Month Total
     * @param countryMonthTotal
     */
    public void setCountryMonthTotal(int countryMonthTotal) {
        this.countryMonthTotal = countryMonthTotal;
    }

    /**
     * getCountryMonth getter from Country month
     * @return countryMonth
     */
    public String getCountryMonth() {
        return countryMonth;
    }

    /**
     * setCountryMonth setter from Country month
     * @param countryMonth
     */
    public void setCountryMonth(String countryMonth) {
        this.countryMonth = countryMonth;
    }

    /**
     * Override toString to print country name
     * @return countryName
     */
    @Override
    public String toString() {
        return countryName;
    }
}
