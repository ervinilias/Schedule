package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.CountryDAO;
import com.example.helloworldjfxtemplate.DAO.FirstLvlDivisionDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Error;
import com.example.helloworldjfxtemplate.model.Country;
import com.example.helloworldjfxtemplate.model.FirstLVLDivision;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerAddController implements Initializable {
    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<Country> cb_custCountry;

    @FXML
    private ComboBox<FirstLVLDivision> cb_custDivision;

    @FXML
    private TextField tf_custAddr;

    @FXML
    private TextField tf_custID;

    @FXML
    private TextField tf_custName;

    @FXML
    private TextField tf_custPhone;

    @FXML
    private TextField tf_custPost;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_custCountry.setItems(CountryDAO.getAllCountry());
    }

    public void setCb_custCountry(ActionEvent event) {
        Country c = cb_custCountry.getValue();
        try {
            cb_custDivision.setItems(FirstLvlDivisionDAO.displayDivision(c.getCountryID()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void setBtn_save(ActionEvent event) throws IOException {
        try {
            if (tf_custName.getText().isEmpty() || tf_custName.getText().isBlank()) {
                Error.getError(7);
            } else if (tf_custPhone.getText().isEmpty() || tf_custPhone.getText().isBlank()) {
                Error.getError(8);
            } else if (tf_custAddr.getText().isEmpty() || tf_custAddr.getText().isBlank()) {
                Error.getError(9);
            } else if (tf_custPost.getText().isEmpty() || tf_custPost.getText().isBlank()) {
                Error.getError(10);
            } else if (cb_custDivision.getValue() == null) {
                Country c = cb_custCountry.getValue();
                if (c == null) {
                    Error.getError(11);
                }
            } else {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void setBtn_cancel(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("customers.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
