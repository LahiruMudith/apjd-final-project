package org.example.apjdfinalproject.Controllers.Vehicle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.apjdfinalproject.Model.VehicleModel;
import org.example.apjdfinalproject.TM.LoadAllVehicleTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllVehicleController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<LoadAllVehicleTM> tblLoadAll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblLoadAll.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("VehicleNumber"));
        tblLoadAll.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("BrandName"));
        tblLoadAll.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Color"));
        tblLoadAll.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("FuleType"));
        tblLoadAll.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("TransmissonType"));
        tblLoadAll.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("Price"));

        ArrayList<LoadAllVehicleTM> list = VehicleModel.LoadAllVehicle();
        tblLoadAll.setItems(FXCollections.observableArrayList(list));

        
    }
}
