package org.example.apjdfinalproject.Controllers.LogInMenu;

import javafx.event.ActionEvent;
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

public class ForgotPasswordController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtSearchEmail;

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
    void ChangePassword(MouseEvent event) {
        String email = txtSearchEmail.getText();
        String password = txtPassword.getText();

        boolean b = LoginModel.ForgotPassword(new User(email, password));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Password Forgot Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Password Forgot Fail");
            alert.show();
        }

    }

    @FXML
    void KeySearch(ActionEvent event) {
        String email = txtSearchEmail.getText();

        User user = LoginModel.SearchUser(email);

        txtEmail.setText(user.getEmail());

    }

    @FXML
    void Search(MouseEvent event) {
        String email = txtSearchEmail.getText();

        User user = LoginModel.SearchUser(email);

        txtEmail.setText(user.getEmail());
    }

    public void clear() {
        txtSearchEmail.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
    }
}
