package com.example.helloworldjfxtemplate;

import com.example.helloworldjfxtemplate.helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
/**
 *  Scheduling Appication
 *  @author Ervin Iliasov C195
 *  Javadoc location: Schedule\src\main\java\com\example\helloworldjfxtemplate\javadoc
 *
 *  MainAppclication class links model and view of application.
 *  This application defines the login user interface container by means of a stage
 *  and a scene. Also, the main method opens and close JDBC connection.
 */
public class MainApplication extends Application {
    /**
     * start() method sets stage and scene, defines initial dimension of a window to show on the screen.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Login Please");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main() method launches the JavaFX application and first place to load all objects and methods.
     * Also opens and closes JDBC connection.
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException  {
        JDBC.makeConnection();
        launch();
        JDBC.closeConnection();
    }
}