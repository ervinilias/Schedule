package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
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
import java.util.ResourceBundle;
import com.example.helloworldjfxtemplate.DAO.*;
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

    ObservableList<Customer> CustomerList = CustomerDAO.getCustomerList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        JDBC.makeConnection();
        custTableView.setItems(CustomerList);
        col_custID.setCellValueFactory(new PropertyValueFactory("custID"));
        col_custName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        col_custPhone.setCellValueFactory(new PropertyValueFactory<>("custPhone"));
        col_custAddr.setCellValueFactory(new PropertyValueFactory<>("custAddr"));
        col_custPost.setCellValueFactory(new PropertyValueFactory<>("custPost"));
        col_custState.setCellValueFactory(new PropertyValueFactory<>("custDivName"));
        col_custCountry.setCellValueFactory(new PropertyValueFactory<>("custCountryName"));

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
    void setBtn_updtCust(ActionEvent event) {

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
