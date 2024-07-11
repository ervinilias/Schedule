package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.CountryDAO;
import com.example.helloworldjfxtemplate.DAO.CustomerDAO;
import com.example.helloworldjfxtemplate.DAO.FirstLvlDivisionDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Error;
import com.example.helloworldjfxtemplate.model.Country;
import com.example.helloworldjfxtemplate.model.Customer;
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
import java.sql.Timestamp;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.time.LocalDateTime.now;

public class CustomerModifyController implements Initializable {
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
    void setBtn_save(ActionEvent event) {
        try {
            if (tf_custName.getText().isEmpty() || tf_custName.getText().isBlank()) {
                Error.getError(7);
            } else if (tf_custPhone.getText().isEmpty() || tf_custPhone.getText().isBlank()) {
                Error.getError(8);
            } else if (tf_custAddr.getText().isEmpty() || tf_custAddr.getText().isBlank()) {
                Error.getError(9);
            } else if (tf_custPost.getText().isEmpty() || tf_custPost.getText().isBlank()) {
                Error.getError(10);
            } else {
                int customerID = Integer.parseInt(tf_custID.getText());
                String customerName = tf_custName.getText();
                String customerAddress = tf_custAddr.getText();
                String customerPostalCode = tf_custPost.getText();
                String customerPhone = tf_custPhone.getText();
                int customerDivID = cb_custDivision.getValue().getDivisionID();
                String lastUpdatedBy = "script";
                Timestamp lastUpdate = Timestamp.valueOf(now());
                CustomerDAO.updateCustomer(customerID, customerName, customerAddress,customerPostalCode, customerPhone,
                        lastUpdatedBy, lastUpdate, customerDivID);

                Parent parent = FXMLLoader.load(MainApplication.class.getResource("customers.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void setBtn_cancel(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave Without Saving?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("customers.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void getCustInfo(Customer selectedCust) throws SQLException {
        tf_custID.setText(Integer.toString(selectedCust.getCustID()));
        tf_custName.setText(selectedCust.getCustName());
        tf_custPhone.setText(selectedCust.getCustPhone());
        tf_custAddr.setText(selectedCust.getCustAddr());
        tf_custPost.setText(selectedCust.getCustPost());
        FirstLVLDivision s = FirstLvlDivisionDAO.returnDivLvl(selectedCust.getCustDivID());
        cb_custDivision.setValue(s);
        Country c1 = CountryDAO.returnCountry(selectedCust.getCustCountryID());
        cb_custCountry.setValue(c1);
        Country c = cb_custCountry.getValue();
        cb_custDivision.setItems(FirstLvlDivisionDAO.displayDivision(c.getCountryID()));
    }
}
