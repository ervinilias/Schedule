package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.CountryDAO;
import com.example.helloworldjfxtemplate.DAO.CustomerDAO;
import com.example.helloworldjfxtemplate.DAO.FirstLvlDivisionDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Alerts;
import com.example.helloworldjfxtemplate.model.Country;
import com.example.helloworldjfxtemplate.model.FirstLVLDivision;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 *  CustomerAddController class adds customer to the customer table
 *  First it checks customer for empty text fields and gets data from all textfields.
 *  If errors found, sends error popup. In the end it returns user to customer menu.
 */
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

    /**
     * initialize() method populates all countries in country combobox
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_custCountry.setItems(CountryDAO.getAllCountry());
    }

    /**
     * setCb_custCountry() method populates all divisions in related combobox depending on what country was selected
     * @param event
     */
    public void setCb_custCountry(ActionEvent event) {
        Country c = cb_custCountry.getValue();
        try {
            cb_custDivision.setValue(null);
            cb_custDivision.setItems(FirstLvlDivisionDAO.displayDivision(c.getCountryID()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * setBtn_save() method checks customer for empty text fields and gets data from all textfields.
     * If errors found, sends error popup. In the end it adds customer to the list and returns user to customer menu.
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_save(ActionEvent event) throws IOException {
        try {
            if (tf_custName.getText().isEmpty() || tf_custName.getText().isBlank()) {
                Alerts.getError(7);
            } else if (tf_custPhone.getText().isEmpty() || tf_custPhone.getText().isBlank()) {
                Alerts.getError(8);
            } else if (tf_custAddr.getText().isEmpty() || tf_custAddr.getText().isBlank()) {
                Alerts.getError(9);
            } else if (tf_custPost.getText().isEmpty() || tf_custPost.getText().isBlank()) {
                Alerts.getError(10);
            } else if (cb_custDivision.getValue() == null) {
                Country c = cb_custCountry.getValue();
                if (c == null) {
                    Alerts.getError(11);
                } else if (cb_custDivision.getValue() == null) {
                    Alerts.getError(23);
                }
            } else {
                String customerName = tf_custName.getText();
                String customerAddress = tf_custAddr.getText();
                String customerPostalCode = tf_custPost.getText();
                String customerPhone = tf_custPhone.getText();
                FirstLVLDivision divId = cb_custDivision.getValue();
                LocalDateTime createDate = LocalDateTime.now();
                String createdBy = "script";
                LocalDateTime lastUpdate = LocalDateTime.now();
                String lastUpdatedBy = "script";
                int customerDivID = divId.getDivisionID();
                CustomerDAO.addCust(customerName, customerAddress, customerPostalCode, customerPhone, createDate, createdBy, lastUpdate, lastUpdatedBy, customerDivID);
                Alerts.getConfirm(1);
                backToCustomers(event);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * backToCustomers() method  sends user to "Customer" menu.
     * @param event
     * @throws IOException
     */
    public void backToCustomers(ActionEvent event) throws  IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("customers.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    /**
     * setBtn_cancel() method raises alert to confirm leaving and utilizes backToCustomers if OK was pressed
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_cancel(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave Without Saving?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            backToCustomers(event);
        }
    }


}
