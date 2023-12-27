package org.example.apjdfinalproject.Controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
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
    void btnCustomers(ActionEvent event) {

    }

    @FXML
    void btnIssueVehicle(ActionEvent event) {

    }

    @FXML
    void btnVehicles(ActionEvent event) {

    }

    @FXML
    void btnViewssueVehicles(ActionEvent event) {

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
