module org.example.apjdfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.apjdfinalproject to javafx.fxml;
    exports org.example.apjdfinalproject;
    exports org.example.apjdfinalproject.Controllers;
    opens org.example.apjdfinalproject.Controllers to javafx.fxml;
}