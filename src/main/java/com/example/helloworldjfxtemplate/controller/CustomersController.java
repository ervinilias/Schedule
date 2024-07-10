package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Error;
import com.example.helloworldjfxtemplate.helper.JDBC;
import com.example.helloworldjfxtemplate.model.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.example.helloworldjfxtemplate.DAO.*;
import com.example.helloworldjfxtemplate.helper.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connection connection = JDBC.makeConnection();

        custTableView.setItems(CustomerDAO.getCustomerList());
        col_custID.setCellValueFactory(new PropertyValueFactory<>("CustID"));
        col_custName.setCellValueFactory(new PropertyValueFactory<>("CustName"));
        col_custPhone.setCellValueFactory(new PropertyValueFactory<>("CustPhone"));
        col_custAddr.setCellValueFactory(new PropertyValueFactory<>("CustAddr"));
        col_custPost.setCellValueFactory(new PropertyValueFactory<>("CustPost"));
        col_custState.setCellValueFactory(new PropertyValueFactory<>("CustDivName"));
        col_custCountry.setCellValueFactory(new PropertyValueFactory<>("CustCountryName"));
    }

    @FXML
    void setBtn_addCust(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("customeradd.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void setBtn_delCust(ActionEvent event) {

    }

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
            Error.getError(6);
        }

    }

    @FXML
    void setBtn_menu(ActionEvent event) throws IOException {
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
    }


}
