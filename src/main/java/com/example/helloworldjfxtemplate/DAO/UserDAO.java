package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserDAO {

    public static boolean userLogin(String username, String password) {
        try (PreparedStatement ps = JDBC.connection.prepareStatement("SELECT * FROM users WHERE User_Name = ? AND Password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean userValid(String username) {
        try (PreparedStatement ps = JDBC.connection.prepareStatement("SELECT * FROM users WHERE BINARY User_Name = ?")) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean passValid(String password) {
        try (PreparedStatement ps = JDBC.connection.prepareStatement("SELECT * FROM users WHERE BINARY Password = ?")) {
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public  static ObservableList<User> getUserList() {
        ObservableList<User> userList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int userID = rs.getInt("User_ID");
                String username = rs.getString("User_Name");

                User u = new User(userID, username);
                userList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


}
