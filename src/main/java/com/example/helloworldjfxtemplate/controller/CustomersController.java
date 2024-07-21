package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Alerts;
import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.Appointment;
import com.example.helloworldjfxtemplate.model.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import com.example.helloworldjfxtemplate.DAO.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * CustomersController class initializes TableView for customers
 * Provides a way to visually manupulate an appointment add/modify/delete
 * @author Ervin Iliasov C195
 */
public class CustomersController implements Initializable {
    @FXML
    private Button btn_addCust;
    @FXML
    private Button btn_delCust;
    @FXML
    private Button btn_updtCust;
    @FXML
    private Button btn_menu;
    @FXML
    private TableView<Customer> custTableView;
    @FXML
    private TableColumn<Customer, Integer> col_custID;
    @FXML
    private TableColumn<Customer, String> col_custName;
    @FXML
    private TableColumn<Customer, String> col_custPhone;
    @FXML
    private TableColumn<Customer, String> col_custAddr;
    @FXML
    private TableColumn<Customer, String> col_custPost;
    @FXML
    private TableColumn<Customer, String> col_custState;
    @FXML
    private TableColumn<Customer, String> col_custCountry;
    ObservableList<Customer> custList = CustomerDAO.getCustomerList();

    /**
     * initialize() method populates customerTableView with data
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = JDBC.makeConnection();

        custTableView.setItems(CustomerDAO.getCustomerList());
        col_custID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        col_custName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        col_custPhone.setCellValueFactory(new PropertyValueFactory<>("custPhone"));
        col_custAddr.setCellValueFactory(new PropertyValueFactory<>("custAddr"));
        col_custPost.setCellValueFactory(new PropertyValueFactory<>("custPost"));
        col_custState.setCellValueFactory(new PropertyValueFactory<>("custDivName"));
        col_custCountry.setCellValueFactory(new PropertyValueFactory<>("custCountryName"));
    }

    /**
     * setBtn_addCust() method sends user to "Customer Add" screen
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_addCust(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("customeradd.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * setBtn_updtCust takes a selection from tableview and sends user to "Modify" screen with help of getCustInfo
     * If nothing was selected, popup will appear.
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    void setBtn_updtCust(ActionEvent event) throws IOException, SQLException {
        if (custTableView.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApplication.class.getResource("customermodify.fxml"));
            loader.load();
            CustomerModifyController MCController = loader.getController();
            MCController.getCustInfo(custTableView.getSelectionModel().getSelectedItem());
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.centerOnScreen();
            stage.show();
        } else {
            Alerts.getError(6);
        }

    }

    /**
     * setBtn_delCust() method removes selected customer from customer list.
     * If selected customer has appointments, we remove all associated appointments first, and after - the customer.
     * If selected customer has no appointments, we remove the customer.
     * @param event
     */
    @FXML
    void setBtn_delCust(ActionEvent event) {
        int delCount = 0;
        ObservableList<Appointment> appointList = AppointmentDAO.getAppointmentList();
        Customer c = custTableView.getSelectionModel().getSelectedItem();
        //If no customer selected -> get an error
        if (c == null) {
            Alerts.getError(6);
        }
        int selectCust = custTableView.getSelectionModel().getSelectedItem().getCustID();
        for (Appointment a : appointList) {
            int appointCustID = a.getAppointCustID();
            if (appointCustID == selectCust) {
                delCount++;
            }
        }
        //if selected customer has appointments, we remove all associated appointments first, and after the customer
        if (delCount > 0) {
            Alert assocAppoint = new Alert(Alert.AlertType.WARNING);
            assocAppoint.setTitle("Alert");
            assocAppoint.setContentText("Specific customer has " + delCount + " associated appointments." +
                    "Pressing OK will delete BOTH customer and associated appointments.");
            assocAppoint.getButtonTypes().clear();
            assocAppoint.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
            assocAppoint.showAndWait();
            if(assocAppoint.getResult() == ButtonType.OK) {
                for (Appointment a : appointList) {
                    if (a.getAppointCustID() == selectCust) {
                        AppointmentDAO.delAppoint(a.getAppointID());
                    }
                }
                CustomerDAO.delCust(custTableView.getSelectionModel().getSelectedItem().getCustID());
                Alerts.getConfirm(5);
                custList = CustomerDAO.getCustomerList();
                custTableView.setItems(custList);
                custTableView.refresh();
            } else if (assocAppoint.getResult() == ButtonType.CANCEL) {
                assocAppoint.close();
            }
        }

        //if selected customer has no appointments, we remove the customer
        if (delCount == 0) {
            Alert confDelete = new Alert(Alert.AlertType.WARNING);
            confDelete.setTitle("Alert");
            confDelete.setContentText("Are you sure you want to remove customer?");
            confDelete.getButtonTypes().clear();
            confDelete.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
            confDelete.showAndWait();
            if (confDelete.getResult() == ButtonType.OK) {
                CustomerDAO.delCust(custTableView.getSelectionModel().getSelectedItem().getCustID());
                Alerts.getConfirm(5);
                custList = CustomerDAO.getCustomerList();
                custTableView.setItems(custList);
                custTableView.refresh();
            } else if (confDelete.getResult() == ButtonType.CANCEL) {
                confDelete.close();
            }
        }
    }

    /**
     * setBtn_menu() method sends user to "Menu" screen.
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_menu(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave To The Previous Menu?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        }
    }
}
