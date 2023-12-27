package org.example.apjdfinalproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.apjdfinalproject.HelloApplication;
import org.example.apjdfinalproject.Model.CustomerModel;
import org.example.apjdfinalproject.TO.Customer;

import java.io.IOException;

public class SearchCustomerController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCuntomerAddress;

    @FXML
    private TextField txtCuntomerAge;

    @FXML
    private TextField txtCuntomerNIC;

    @FXML
    private TextField txtCuntomerName;

    @FXML
    private TextField txtCuntomerPhoneNumber;

    @FXML
    private TextField txtCuntomerPhoneNumber2;


    @FXML
    private TextField txtSearchCustomerNIC;

    @FXML
    void AddCustomer(MouseEvent event) {
        Stage stage = (Stage) this.root.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Add-Customer-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 650, 502);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void DeleteCustomer(MouseEvent event) {
        String NIC = txtSearchCustomerNIC.getText();

        boolean b = CustomerModel.DeleteCustomer(NIC);

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vehicle Delete Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vehicle Delete Fail");
            alert.show();
        }
    }

    @FXML
    void KeySearch(ActionEvent event) {
        String NIC = txtSearchCustomerNIC.getText();

        Customer customer = CustomerModel.SearchCustomer(NIC);

        txtCuntomerNIC.setText(customer.getNicNumber());
        txtCuntomerName.setText(customer.getName());
        txtCuntomerAddress.setText(customer.getAddress());
        txtCuntomerAge.setText(customer.getAge());
        txtCuntomerPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
        txtCuntomerPhoneNumber2.setText(String.valueOf(customer.getPhoneNumber2()));

    }

    @FXML
    void LoadAll(MouseEvent event) {

    }

    @FXML
    void Search(MouseEvent event) {
        String NIC = txtSearchCustomerNIC.getText();

        Customer customer = CustomerModel.SearchCustomer(NIC);

        txtCuntomerNIC.setText(customer.getNicNumber());
        txtCuntomerName.setText(customer.getName());
        txtCuntomerAddress.setText(customer.getAddress());
        txtCuntomerAge.setText(customer.getAge());
        txtCuntomerPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
        txtCuntomerPhoneNumber2.setText(String.valueOf(customer.getPhoneNumber2()));
    }

    @FXML
    void UpdateCustomer(MouseEvent event) {
        String NIC = txtCuntomerNIC.getText();
        String Name = txtCuntomerName.getText();
        String Address = txtCuntomerAddress.getText();
        String Age = txtCuntomerAge.getText();
        int PhoneNumber1 = Integer.parseInt(txtCuntomerPhoneNumber.getText());
        int PhoneNumber2 = Integer.parseInt(txtCuntomerPhoneNumber2.getText());

        boolean b = CustomerModel.UpdateCustomer(new Customer(NIC, Name, Address, Age, PhoneNumber1, PhoneNumber2));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Customer Update Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Customer Update Fail");
            alert.show();
        }
    }
    public void clear() {
        txtSearchCustomerNIC.setText("");
        txtCuntomerNIC.setText("");
        txtCuntomerName.setText("");
        txtCuntomerAddress.setText("");
        txtCuntomerAge.setText("");
        txtCuntomerPhoneNumber.setText("");
        txtCuntomerPhoneNumber2.setText("");
    }
}
