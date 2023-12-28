package org.example.apjdfinalproject.Controllers.LogInMenu;

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
import org.example.apjdfinalproject.Model.LoginModel;
import org.example.apjdfinalproject.TO.User;

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
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Create-Account-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 380);
            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ForgotPassword(ActionEvent event) {
        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Forgot-Password-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 380);
            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Login(ActionEvent event) {

        String email = txtEmail.getText();
        String password = txtPassword.getText();

        boolean login = LoginModel.Login(new User(email, password));

        if (login==true) {
            try {
                Stage stage = (Stage) this.root.getScene().getWindow();

                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Main-Menu-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 586);
                stage.setScene(scene);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Incorrect Email Or Password");
            alert.show();
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
