module com.example.helloworldjfxtemplate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.helloworldjfxtemplate to javafx.fxml, javafx.base;
    exports com.example.helloworldjfxtemplate;
    exports com.example.helloworldjfxtemplate.controller;
    exports com.example.helloworldjfxtemplate.model;
    exports com.example.helloworldjfxtemplate.DAO;
    exports com.example.helloworldjfxtemplate.helper;
    opens com.example.helloworldjfxtemplate.controller to javafx.fxml, javafx.base;
    opens com.example.helloworldjfxtemplate.model to javafx.fxml, javafx.base, javafx.graphics;

}