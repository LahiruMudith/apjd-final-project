package org.example.apjdfinalproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.apjdfinalproject.HelloApplication;

import java.io.IOException;

public class LoginController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void CreateAccount(ActionEvent event) {

    }

    @FXML
    void ForgotPassword(ActionEvent event) {

    }

    @FXML
    void Login(ActionEvent event) {

        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Main-Menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 550);
            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        if ((txtEmail.equals("lahimudith@gmail.com")) && (txtPassword.equals(1234))){
//
//            try {
//                Stage stage = (Stage) this.root.getScene().getWindow();
//
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Main-Menu-view.fxml"));
//                Scene scene = new Scene(fxmlLoader.load(), 900, 550);
//                stage.setScene(scene);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Login Fail...Email or Password Wrong !");
//        }

    }

}
