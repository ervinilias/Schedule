package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.model.FirstLVLDivision;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.helloworldjfxtemplate.helper.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FirstLvlDivisionDAO {

    public static ObservableList<FirstLVLDivision> displayDivision(int countryId) throws SQLException {
        ObservableList<FirstLVLDivision> divisionCountryOptions = FXCollections.observableArrayList();

        String sql = "SELECT * FROM first_level_divisions WHERE Country_ID = " + countryId;
        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while (rs.next()) {
            int divisionId = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            countryId = rs.getInt("Country_ID");
            Timestamp Create_Date = rs.getTimestamp("Create_Date");
            LocalDateTime createDate = Create_Date.toLocalDateTime();
            String createBy = rs.getString("Created_By");
            Timestamp Last_Updated = rs.getTimestamp("Last_Update");
            LocalDateTime lastUpdated = Last_Updated.toLocalDateTime();
            String lastUpdatedBy = rs.getString("Last_Updated_By");

            FirstLVLDivision c = new FirstLVLDivision(divisionId, divisionName, countryId, createDate, createBy, lastUpdated, lastUpdatedBy);
            divisionCountryOptions.add(c);
        }
        return divisionCountryOptions;
    }

    public static FirstLVLDivision returnDivLvl(int divisionID) {
        try {
            String sql = "SELECT Division_ID, Division FROM first_level_divisions WHERE Division_ID = ?";
            PreparedStatement ps = JDBC.connection.prepareStatement(sql);
            ps.setInt(1, divisionID);
            ps.execute();

            ResultSet rs = ps.getResultSet();

            rs.next();
            int searchedDivID = rs.getInt("Division_ID");
            String divName = rs.getString("Division");
            FirstLVLDivision s = new FirstLVLDivision(searchedDivID, divName);
            return s;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

