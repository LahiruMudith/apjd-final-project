package org.example.apjdfinalproject.Controllers.Vehicle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.IssueModel;
import org.example.apjdfinalproject.TM.LoadAllVehicleTM;
import org.example.apjdfinalproject.TM.LoadIssueVehicleTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadIssueVehicleController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<LoadIssueVehicleTM> tblLoadIssueVehicle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblLoadIssueVehicle.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("IssueID"));
        tblLoadIssueVehicle.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("CustomerNIC"));
        tblLoadIssueVehicle.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        tblLoadIssueVehicle.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("VehicleNumber"));
        tblLoadIssueVehicle.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("VehicleBrandName"));
        tblLoadIssueVehicle.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Date"));

        ArrayList<LoadIssueVehicleTM> loadIssueVehicleTMS = IssueModel.LoadIssueVehicle();
        tblLoadIssueVehicle.setItems(FXCollections.observableArrayList(loadIssueVehicleTMS));
    }
}
