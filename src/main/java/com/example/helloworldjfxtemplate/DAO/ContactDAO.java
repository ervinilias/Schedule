package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.Contact;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ContactDAO class has SQL queries that:
 * getAllContacts list
 * returnContactList from contact ID
 * returnContactID from contact name
 */
public class ContactDAO {
    /**
     * getAllContacts() method has sql query that get all data from contacts database.
     * @return contactList
     */
    public static ObservableList<Contact> getAllContacts() {
        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Contact_ID, Contact_Name, Email FROM contacts";
            PreparedStatement contacts = JDBC.connection.prepareStatement(sql);
            ResultSet rs = contacts.executeQuery();

            while (rs.next()) {
                int contactID = rs.getInt("Contact_ID");
                String contactName = rs.getString("Contact_Name");
                String contactEmail = rs.getString("Email");
                Contact c = new Contact(contactID, contactName, contactEmail);
                contactList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contactList;
    }

    /**
     * returnContactList() method has sql query that returns contact list from contact ID
     * @param contactId
     * @return c
     */
    public static Contact returnContactList(int contactId) {
        Contact c = null;
        try {
            String sql = "SELECT * FROM contacts WHERE Contact_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, contactId);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int searchedContactId = rs.getInt("Contact_ID");
                String contactName = rs.getString("Contact_Name");
                String contactEmail = rs.getString("Email");
                c = new Contact(searchedContactId, contactName, contactEmail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    /**
     * returnContactID() method has sql query that returns contact ID using contact name
     * @param contactName
     * @return contactID
     * @throws SQLException
     */
    public static int returnContactID(String contactName) throws SQLException {
        int contactID = 0;
        String sql = "SELECT * FROM contacts WHERE Contact_Name = ?";
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, contactName);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            contactID = rs.getInt("Contact_ID");
        }
        return contactID;
    }
}
