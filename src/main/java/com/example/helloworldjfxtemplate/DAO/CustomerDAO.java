package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.controller.ReportsController;
import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomerDAO {

    public static ObservableList<Customer> getCustomerList() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT customers.Customer_ID, customers.Customer_Name, customers.Address, customers.Create_Date, customers.Last_Update, customers.Created_By, customers.Last_Updated_By, customers.Postal_Code, customers.Phone, customers.Division_ID, first_level_divisions.Division, first_level_divisions.Country_ID, countries.Country FROM customers JOIN first_level_divisions ON customers.Division_ID = first_level_divisions.Division_ID JOIN countries ON countries.Country_ID = first_level_divisions.Country_ID ORDER BY customers.Customer_ID";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerID = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String customerAddress = rs.getString("Address");
                String customerPostalCode = rs.getString("Postal_Code");
                String customerPhone = rs.getString("Phone");
                String createdBy = rs.getString("Created_By");
                String lastUpdatedBy = rs.getString("Last_Updated_By");
                int customerDivisionID = rs.getInt("Division_ID");
                String customerDivisionName = rs.getString("Division");
                int customerCountryID = rs.getInt("Country_ID");
                String customerCountryName = rs.getString("Country");
                Customer c = new Customer(customerID, customerName, customerAddress, customerPostalCode, customerPhone, createdBy, lastUpdatedBy, customerDivisionID, customerDivisionName, customerCountryID, customerCountryName);
                customerList.add(c);
                customerList.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void addCustomer(String customerName, String customerAddress, String customerPostalCode, String customerPhone, LocalDateTime createdDate, LocalDateTime lastUpdated, int divisionID) throws SQLException {
        String sql = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Last_Update, Division_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertCust = JDBC.connection.prepareStatement(sql);
        insertCust.setString(1, customerName);
        insertCust.setString(2, customerAddress);
        insertCust.setString(3, customerPostalCode);
        insertCust.setString(4, customerPhone);
        insertCust.setTimestamp(5, Timestamp.valueOf(createdDate));
        insertCust.setTimestamp(6, Timestamp.valueOf(lastUpdated));
        insertCust.setInt(7, divisionID);
        insertCust.executeUpdate();
    }

    public static void updateCustomer(int customerID, String customerName, String customerAddress, String customerPostalCode,
                                      String customerPhone, String lastUpdatedBy, Timestamp lastUpdated, int customerDivisionId, int countryId) {
        try {
            String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Last_Updated_By = ?, Last_Update = ?, Division_ID = ? WHERE Customer_ID = ?";
            PreparedStatement updateCust = JDBC.connection.prepareStatement(sql);
            updateCust.setString(1, customerName);
            updateCust.setString(2, customerAddress);
            updateCust.setString(3, customerPostalCode);
            updateCust.setString(4, customerPhone);
            updateCust.setString(5, lastUpdatedBy);
            updateCust.setTimestamp(6, lastUpdated);
            updateCust.setInt(7, customerDivisionId);
            updateCust.setInt(8, customerID);
            updateCust.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCustomer(int customerId) {
        try {
            String sqldelete = "DELETE FROM customers WHERE Customer_ID = ?";
            PreparedStatement deleteCust = JDBC.connection.prepareStatement(sqldelete);
            deleteCust.setInt(1, customerId);
            deleteCust.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Customer returnCustomerList(int customerID) throws SQLException {
        String sql = "SELECT * FROM customers WHERE Customer_ID = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, customerID);
        ps.execute();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int searchedCustomerId = rs.getInt("Customer_ID");
            String customerName = rs.getString("Customer_Name");
            Customer c = new Customer(searchedCustomerId, customerName);
            return c;
        }
        return null;
    }
}
