package org.example.apjdfinalproject.Controllers.LogInMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.LoginModel;
import org.example.apjdfinalproject.TO.User;

public class CreateAccountController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void Back(MouseEvent event) {

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
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Create Account Fail");
            alert.show();
        }

    }

}
