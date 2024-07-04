package com.example.helloworldjfxtemplate.controller;

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
    private Button btn_menu;

    @FXML
    private Button btn_updtCust;

    @FXML
    private TableColumn<?, ?> col_custAddr;

    @FXML
    private TableColumn<?, ?> col_custCountry;

    @FXML
    private TableColumn<?, ?> col_custID;

    @FXML
    private TableColumn<?, ?> col_custName;

    @FXML
    private TableColumn<?, ?> col_custPhone;

    @FXML
    private TableColumn<?, ?> col_custPost;

    @FXML
    private TableColumn<?, ?> col_custState;

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
