package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

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
    private TableColumn<Customer, Integer> col_custID;

    @FXML
    private TableColumn<Customer, String> col_custName;

    @FXML
    private TableColumn<Customer, String> col_custPhone;

    @FXML
    private TableColumn<?, ?> col_custAddr;

    @FXML
    private TableColumn<?, ?> col_custPost;

    @FXML
    private TableColumn<?, ?> col_custState;

    @FXML
    private TableColumn<?, ?> col_custCountry;

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
