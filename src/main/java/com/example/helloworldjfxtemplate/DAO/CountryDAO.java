package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.helloworldjfxtemplate.helper.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO {

    public static ObservableList<Country> getAllCountry() {
        ObservableList<Country> countryList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Country_ID, Country FROM countries";
            PreparedStatement country = JDBC.connection.prepareStatement(sql);
            ResultSet rs = country.executeQuery();

            while (rs.next()) {
                int countryId = rs.getInt("Country_ID");
                String countryName = rs.getString("Country");
                Country c = new Country(countryId, countryName);
                countryList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countryList;
    }

    public static Country returnCountry(int countryID) {
        Country c = null;
        try {
            String sql = "SELECT Country_ID, Country FROM countries WHERE Country_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, countryID);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int searchedCountryID = rs.getInt("Country_ID");
                String countryName = rs.getString("Country");
                c = new Country(searchedCountryID, countryName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

//    public static ObservableList<Country> totalCountry() {
//        ObservableList<Country> customerCountry = FXCollections.observableArrayList();
//        try {
//            String sql = "SELECT countries.Country, COUNT(customers.Customer_ID) AS Count FROM countries INNER JOIN first_level_divisions ON  countries.Country_ID = first_level_divisions.Country_ID INNER JOIN customers ON customers.Division_ID = first_level_divisions.Division_ID group by countries.Country";
//            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String countryMonth = rs.getString("Country");
//                int countryMonthTotal = rs.getInt("Count");
//                Country results = new Country(countryMonth, countryMonthTotal);
//                customerCountry.add(results);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customerCountry;
//    }

}

