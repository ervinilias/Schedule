package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * UserDAO class has sql queries with multiple functionalities:
 * getUserList,
 * userLogin validation for both username and its password
 * userValid for entered username that checks it in database
 * passValid for entered password that checks it in database
 * get user ID from username
 */
public class UserDAO {

    /**
     * getUserList() method has sql query that get ObservableList of all users from database
     * @return userList
     */
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

    /**
     * userLogin() method has sql query that checks username and related password from database
     * @param username
     * @param password
     * @return true
     */
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

    /**
     * userValid() method has sql query that checks username from database
     * @param username
     * @return true
     */
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
    /**
     * passValid() method has sql query that checks password from database
     * @param password
     * @return true
     */
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

    /**
     * getUserId() method has sql query that returns user data from username from database
     * @param userName
     * @return userID
     * @throws SQLException
     */
    public static int getUserId(String userName) throws SQLException {
        int userID = 0;
        String sqlStatement = "SELECT User_ID, User_Name from users where User_Name = '" + userName + "'";
        PreparedStatement ps = JDBC.connection.prepareStatement(sqlStatement);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            userID = rs.getInt("User_ID");
            userName = rs.getString("User_Name");
        }
        return userID;
    }

    /**
     * returnUserID() method that has sql query that returns userdata from user ID
     * @param userID
     * @return u
     */
    public static User returnUserID(int userID) {
        try {
            String sql = "SELECT User_ID, User_Name FROM users WHERE User_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            rs.next();
            int searchUserID = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            User u = new User(searchUserID, userName);
            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
