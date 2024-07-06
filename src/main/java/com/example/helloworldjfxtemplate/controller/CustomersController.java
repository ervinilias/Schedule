package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.model.Country;
import com.example.helloworldjfxtemplate.model.Customer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;
import com.example.helloworldjfxtemplate.DAO.*;

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
    private TableView<Customer> custTable;

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
    private TableColumn<Customer, Integer> col_custState;

    @FXML
    private TableColumn<Country, Integer> col_custCountry;

    ObservableList<Customer> CustomerList = CustomerDAO.getCustomerList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void setBtn_addCust(ActionEvent event) {

    }

    @FXML
    void setBtn_delCust(ActionEvent event) {

    }

    @FXML
    void setBtn_menu(ActionEvent event) {

    }

    @FXML
    void setBtn_updtCust(ActionEvent event) {

    }


}
