package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppointmentDAO {
    public static ObservableList<Appointment> getAppointmentList() {
        ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM appointments JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID " +
                    "ORDER BY appointments.Appointment_ID";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentID = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                int appointmentContactID = rs.getInt("Contact_ID");
                String appointmentContactName = rs.getString("Contact_Name");
                String appointmentType = rs.getString("Type");
                LocalDateTime appointmentStart = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime appointmentEnd = rs.getTimestamp("End").toLocalDateTime();
                int appointmentCustomerID = rs.getInt("Customer_ID");
                int appointmentUserID = rs.getInt("User_ID");



                Appointment c = new Appointment(appointmentID, appointmentTitle, appointmentDescription, appointmentLocation,
                        appointmentType, appointmentStart, appointmentEnd, appointmentCustomerID, appointmentUserID,
                        appointmentContactID, appointmentContactName);
                appointmentList.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appointmentList;
    }
}
