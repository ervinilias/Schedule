package com.example.helloworldjfxtemplate.DAO;

import com.example.helloworldjfxtemplate.model.FirstLVLDivision;
import javafx.collections.ObservableList;
import com.example.helloworldjfxtemplate.helper.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstLvlDivisionDAO {
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


}
