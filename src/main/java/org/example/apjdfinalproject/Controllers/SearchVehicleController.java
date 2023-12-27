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
import org.example.apjdfinalproject.Model.VehicleModel;
import org.example.apjdfinalproject.TO.Vehicle;

import java.io.IOException;

public class SearchVehicleController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtSearchVehicleNumber;

    @FXML
    private TextField txtVehicleBrandName;

    @FXML
    private TextField txtVehicleColor;

    @FXML
    private TextField txtVehicleFuleType;

    @FXML
    private TextField txtVehicleNumber;

    @FXML
    private TextField txtVehiclePrice;

    @FXML
    private TextField txtVehicleTransmissonType;

    @FXML
    void KeySearch(ActionEvent event) {
        String searchId = txtSearchVehicleNumber.getText();

        Vehicle search = VehicleModel.Search(searchId);

        txtVehicleNumber.setText(search.getVehicleNumber());
        txtVehicleBrandName.setText(search.getVehicleBrandName());
        txtVehicleColor.setText(search.getVehicleColor());
        txtVehicleFuleType.setText(search.getFuleType());
        txtVehicleTransmissonType.setText(search.getTransmissionType());
        txtVehiclePrice.setText(String.valueOf(search.getPrice()));
    }

    @FXML
    void Search(MouseEvent event) {
        System.out.println("HYYY");
        String searchId = txtSearchVehicleNumber.getText();

        Vehicle search = VehicleModel.Search(searchId);

        txtVehicleNumber.setText(search.getVehicleNumber());
        txtVehicleBrandName.setText(search.getVehicleBrandName());
        txtVehicleColor.setText(search.getVehicleColor());
        txtVehicleFuleType.setText(search.getFuleType());
        txtVehicleTransmissonType.setText(search.getTransmissionType());
        txtVehiclePrice.setText(String.valueOf(search.getPrice()));

    }

    @FXML
    void DeleteVehicle(MouseEvent event) {
        String searchId = txtSearchVehicleNumber.getText();

        boolean b = VehicleModel.DeleteVehicle(searchId);

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
    void AddVehicle(MouseEvent event) {

        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Add-Vehicle-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 650, 502);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void LoadAll(MouseEvent event) {

        try {
            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Load-All-Vehicle-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 650, 502);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void UpdateVehicle(MouseEvent event) {
        String Number = txtVehicleNumber.getText();
        String BrandName = txtVehicleBrandName.getText();
        String Color = txtVehicleColor.getText();
        String FuleType = txtVehicleFuleType.getText();
        String TransmissonType = txtVehicleTransmissonType.getText();
        double Price = Double.parseDouble(txtVehiclePrice.getText());

        boolean b = VehicleModel.UpdateVehicle(new Vehicle(Number, BrandName, Color, FuleType, TransmissonType, Price));

        if (b==true) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Vehicle Update Successfully");
            alert.show();
            clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vehicle Update Fail");
            alert.show();
        }

    }

    public void clear() {
        txtSearchVehicleNumber.setText("");
        txtVehicleNumber.setText("");
        txtVehicleBrandName.setText("");
        txtVehicleColor.setText("");
        txtVehicleFuleType.setText("");
        txtVehicleTransmissonType.setText("");
        txtVehiclePrice.setText("");
    }
}
