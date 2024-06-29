package com.example.helloworldjfxtemplate;

import com.example.helloworldjfxtemplate.helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Scheduling app");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException  {
        JDBC.makeConnection();
        launch();
        JDBC.closeConnection();
    }
}