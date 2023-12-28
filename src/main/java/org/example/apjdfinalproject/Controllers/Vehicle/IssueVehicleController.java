package org.example.apjdfinalproject.Controllers.Vehicle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.CustomerModel;
import org.example.apjdfinalproject.Model.IssueModel;
import org.example.apjdfinalproject.Model.VehicleModel;
import org.example.apjdfinalproject.TO.Customer;
import org.example.apjdfinalproject.TO.Vehicle;

import java.sql.SQLException;

public class IssueVehicleController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCustomerNIC;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSearchCustomerNIC;

    @FXML
    private TextField txtSearchVehicleNumber;

    @FXML
    private TextField txtVehicleBrandName;

    @FXML
    private TextField txtVehicleNumber;

    @FXML
    void IssueVehicle(MouseEvent event) throws SQLException {
        String NIC = txtCustomerNIC.getText();
        String CustomerName = txtCustomerName.getText();
        String VehicleNumber = txtVehicleNumber.getText().toUpperCase();
        String VehicleBrandName = txtVehicleBrandName.getText();

        boolean b = IssueModel.IssueVehicle(NIC, CustomerName, VehicleNumber, VehicleBrandName);

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vehicle Issue Completed");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vehicle Issue Fail");
            alert.show();
        }
    }

    @FXML
    void SearchCustomer(ActionEvent event) {
        String NIC = txtSearchCustomerNIC.getText();

        Customer customer = CustomerModel.SearchCustomer(NIC);

        txtCustomerNIC.setText(customer.getNicNumber());
        txtCustomerName.setText(customer.getName());
    }

    @FXML
    void SearchVehicle(ActionEvent event) {
        String searchId = txtSearchVehicleNumber.getText();

        Vehicle search = VehicleModel.Search(searchId);

        txtVehicleNumber.setText(search.getVehicleNumber());
        txtVehicleBrandName.setText(search.getVehicleBrandName());
    }


}
