package org.example.apjdfinalproject.Controllers.LogInMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.apjdfinalproject.HelloApplication;
import org.example.apjdfinalproject.Model.LoginModel;
import org.example.apjdfinalproject.TO.User;

import java.io.IOException;

public class CreateAccountController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void Back(MouseEvent event) {
        Stage stage = (Stage) this.root.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void CreateAccount(MouseEvent event) {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        boolean b = LoginModel.CreateAccount(new User(email, password));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Create Account Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Create Account Fail");
            alert.show();
        }

    }

    public void clear() {
        txtEmail.setText("");
        txtPassword.setText("");
    }
}
