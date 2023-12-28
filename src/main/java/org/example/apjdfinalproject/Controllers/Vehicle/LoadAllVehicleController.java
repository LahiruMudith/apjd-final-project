package org.example.apjdfinalproject.Controllers.Vehicle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.apjdfinalproject.HelloApplication;
import org.example.apjdfinalproject.Model.VehicleModel;
import org.example.apjdfinalproject.TM.LoadAllVehicleTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllVehicleController implements Initializable {
    @FXML
    private AnchorPane root;
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
