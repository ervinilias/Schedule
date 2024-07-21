package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.model.Country;
import com.example.helloworldjfxtemplate.model.FirstLVLDivision;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.helloworldjfxtemplate.helper.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * FirstLvlDivisionDAO has queries to display all divisions for related country ID from database.
 * Also, returns division name for division ID.
 */
public class FirstLvlDivisionDAO {

    /**
     * displayDivision() method has sql query that returns ObservableList of all divisions for a specific country ID
     * from database.
     * @param countryID
     * @return divisionCountryOptions
     * @throws SQLException
     */
    public static ObservableList<FirstLVLDivision> displayDivision(int countryID) throws SQLException {
        ObservableList<FirstLVLDivision> divisionCountryOptions = FXCollections.observableArrayList();
        String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = " + countryID;
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            int divisionId = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            countryID = rs.getInt("Country_ID");
            Timestamp Create_Date = rs.getTimestamp("Create_Date");
            LocalDateTime createDate = Create_Date.toLocalDateTime();
            String createBy = rs.getString("Created_By");
            Timestamp Last_Updated = rs.getTimestamp("Last_Update");
            LocalDateTime lastUpdated = Last_Updated.toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");

            FirstLVLDivision c = new FirstLVLDivision(divisionId, divisionName, countryID, createDate, createBy, lastUpdated, lastUpdatedBy);
            divisionCountryOptions.add(c);
        }
        return divisionCountryOptions;
    }

    /**
     * returnDivLvl() method has sql query that return division name from specific division ID from database.
     * @param divisionID
     * @return s
     */
    public static FirstLVLDivision returnDivLvl(int divisionID) {
        FirstLVLDivision s = null;
        try {
            String sql = "SELECT Division_ID, Division, Country_ID FROM first_level_divisions WHERE Division_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, divisionID);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                int searchedDivID = rs.getInt("Division_ID");
                String divName = rs.getString("Division");
                int countryID = rs.getInt("Country_ID");
                s = new FirstLVLDivision(searchedDivID, divName, countryID);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
}

