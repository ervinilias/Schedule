package com.example.helloworldjfxtemplate.model;

public class Country {
    private int countryID;
    private String countryName;
    private int countryMonthTotal;
    private String countryMonth;

    public Country(String countryMonth, int countryMonthTotal) {
        this.countryMonth = countryMonth;
        this.countryMonthTotal = countryMonthTotal;
    }

    public Country(int countryId, String countryName) {
        this.countryID = countryId;
        this.countryName = countryName;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryMonthTotal() {
        return countryMonthTotal;
    }

    public void setCountryMonthTotal(int countryMonthTotal) {
        this.countryMonthTotal = countryMonthTotal;
    }

    public String getCountryMonth() {
        return countryMonth;
    }

    public void setCountryMonth(String countryMonth) {
        this.countryMonth = countryMonth;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
