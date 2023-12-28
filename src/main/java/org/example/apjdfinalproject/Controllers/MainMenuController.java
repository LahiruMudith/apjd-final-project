package org.example.apjdfinalproject.Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.apjdfinalproject.HelloApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Pane CenterPane;

    @FXML
    private ImageView Menu;

    @FXML
    private ImageView MenuClose;

    @FXML
    private AnchorPane root;

    @FXML
    private VBox slideMenu;

    private EventHandler<? super ScrollEvent> ActionEvent;

    @FXML
    void BackToLogIn(MouseEvent event) {
        Stage stage = (Stage) this.root.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Login-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void CloseRent(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Close-Rent-view.fxml"));
            CenterPane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void IssueVehicle(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Issue-Vehicle-view.fxml"));
            CenterPane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void LoadAllIssueVehicle(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Load-Issue-Vehicle-view.fxml"));
            CenterPane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void SearchMember(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Search-Customer-view.fxml"));
            CenterPane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void SearchVehicle(MouseEvent event) {
        try {
            Pane load = FXMLLoader.load(HelloApplication.class.getResource("view/Search-Vehicle-view.fxml"));
            CenterPane.getChildren().setAll(load);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        slideMenu.setTranslateX(-250);

        Menu.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slids = new TranslateTransition();
            slids.setDuration(Duration.seconds(0.4));
            slids.setNode(slideMenu);

            slids.setToX(0);
            slids.play();

            slideMenu.setTranslateX(250);
            slideMenu.setOnScrollFinished((ActionEvent ) -> {
                Menu.setVisible(false);
                MenuClose.setVisible(true);
            } );
        });

        MenuClose.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slids = new TranslateTransition();
            slids.setDuration(Duration.seconds(1));
            slids.setNode(slideMenu);

            slids.setToX(-250);
            slids.play();

            slideMenu.setTranslateX(0);
            slideMenu.setOnScrollFinished((ActionEvent ) -> {
                Menu.setVisible(true);
                MenuClose.setVisible(false);
            } );
        });
    }


}
