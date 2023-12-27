package org.example.apjdfinalproject.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.CustomerModel;
import org.example.apjdfinalproject.TO.Customer;

import static com.sun.beans.introspect.ClassInfo.clear;

public class AddCustomerController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCustomerAddress;

    @FXML
    private TextField txtCustomerAge;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtCustomerNicNumber;

    @FXML
    private TextField txtCustomerPhoneNumber;

    @FXML
    private TextField txtCustomerPhoneNumber2;

    @FXML
    void Add(MouseEvent event) {
        String NicNumber = txtCustomerNicNumber.getText();
        String Name = txtCustomerName.getText();
        String Address = txtCustomerAddress.getText();
        String Age = txtCustomerAge.getText();
        int PhoneNumber = Integer.parseInt(txtCustomerPhoneNumber.getText());
        int PhoneNumber2 = Integer.parseInt(txtCustomerPhoneNumber2.getText());

        boolean b = CustomerModel.AddCustomer(new Customer(NicNumber, Name, Address, Age, PhoneNumber, PhoneNumber2));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Customer Added Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Customer Added Fail...Try Again");
            alert.show();
        }
    }
    public void clear() {
        txtCustomerNicNumber.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerAge.setText("");
        txtCustomerPhoneNumber.setText("");
        txtCustomerPhoneNumber2.setText("");
    }

}
