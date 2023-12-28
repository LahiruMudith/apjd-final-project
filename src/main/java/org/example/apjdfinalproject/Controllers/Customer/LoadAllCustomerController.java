package org.example.apjdfinalproject.Controllers.Customer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.apjdfinalproject.HelloApplication;
import org.example.apjdfinalproject.Model.CustomerModel;
import org.example.apjdfinalproject.TM.LoadAllCustomerTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadAllCustomerController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private TableView<LoadAllCustomerTM> tblLoadAllCustomer;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblLoadAllCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("NIC"));
        tblLoadAllCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblLoadAllCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblLoadAllCustomer.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Age"));
        tblLoadAllCustomer.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        tblLoadAllCustomer.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("PhoneNumber2"));

        ArrayList<LoadAllCustomerTM> list = CustomerModel.ViewAllCustomer();
        tblLoadAllCustomer.setItems(FXCollections.observableArrayList(list));
    }
}
