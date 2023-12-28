package org.example.apjdfinalproject.Controllers.Vehicle;

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
import org.example.apjdfinalproject.Model.VehicleModel;
import org.example.apjdfinalproject.TO.Vehicle;

import java.io.IOException;

public class AddVehicleController {
    @FXML
    private TextField txtTransmissionType;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtVehicleBrandName;

    @FXML
    private TextField txtVehicleColor;

    @FXML
    private TextField txtVehicleNumber;

    @FXML
    private TextField txtFuleType;

    @FXML
    private TextField txtVehiclePrice;
    @FXML
    void Back(MouseEvent event) {
        Stage stage = (Stage) this.root.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Main-Menu-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 586);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void Add(ActionEvent event) {
        String Number = txtVehicleNumber.getText().toUpperCase();
        String BrandName= txtVehicleBrandName.getText();
        String Color = txtVehicleColor.getText();
        String FuleType = txtFuleType.getText();
        String TransmissionType = txtTransmissionType.getText();
        double Price = Double.parseDouble(txtVehiclePrice.getText());

        System.out.println(Number + " " + Price);

        boolean b = VehicleModel.AddVehicle(new Vehicle(Number, BrandName, Color, FuleType, TransmissionType, Price));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vehicle Added Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vehicle Added Fail...Try Again");
            alert.show();
        }
    }

    public void clear() {
        txtVehicleNumber.setText("");
        txtVehicleBrandName.setText("");
        txtVehicleColor.setText("");
        txtFuleType.setText("");
        txtTransmissionType.setText("");
        txtVehiclePrice.setText("");
    }
}
