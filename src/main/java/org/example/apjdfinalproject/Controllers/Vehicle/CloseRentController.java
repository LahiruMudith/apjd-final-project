package org.example.apjdfinalproject.Controllers.Vehicle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.CustomerModel;
import org.example.apjdfinalproject.Model.RentModel;
import org.example.apjdfinalproject.TO.Customer;
import org.example.apjdfinalproject.TO.RentClose;

public class CloseRentController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtCustomerNIC;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtSearchIssueID;

    @FXML
    private TextField txtVehicleBrand;

    @FXML
    private TextField txtVehicleNumber;

    @FXML
    void KeySearch(ActionEvent event) {
        int ID = Integer.parseInt(txtSearchIssueID.getText());

        RentClose rentClose = RentModel.RentSearch(ID);

        txtCustomerNIC.setText(rentClose.getNIC());
        txtCustomerName.setText(rentClose.getName());
        txtVehicleNumber.setText(rentClose.getVehicleNumber());
        txtVehicleBrand.setText(rentClose.getVehicleBrandName());
    }

    @FXML
    void RentCloseDone(MouseEvent event) {
        String IssueID = txtSearchIssueID.getText();

        boolean b = RentModel.RentClose(IssueID);

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Rent Close Done");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Rent Close Fail");
            alert.show();
        }
    }

    @FXML
    void Search(MouseEvent event) {
        int ID = Integer.parseInt(txtSearchIssueID.getText());

        RentClose rentClose = RentModel.RentSearch(ID);

        txtCustomerNIC.setText(rentClose.getNIC());
        txtCustomerName.setText(rentClose.getName());
        txtVehicleNumber.setText(rentClose.getVehicleNumber());
        txtVehicleBrand.setText(rentClose.getVehicleBrandName());

    }

    public void clear() {
        txtSearchIssueID.setText("");
        txtCustomerNIC.setText("");
        txtCustomerName.setText("");
        txtVehicleNumber.setText("");
        txtVehicleBrand.setText("");
    }
}
