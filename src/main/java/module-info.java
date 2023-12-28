module org.example.apjdfinalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires kotlin.stdlib;


    opens org.example.apjdfinalproject to javafx.fxml;
    exports org.example.apjdfinalproject;
    exports org.example.apjdfinalproject.Controllers;
    opens org.example.apjdfinalproject.Controllers to javafx.fxml;
    opens org.example.apjdfinalproject.TM to javafx.base;
    exports org.example.apjdfinalproject.Controllers.Customer;
    opens org.example.apjdfinalproject.Controllers.Customer to javafx.fxml;
    exports org.example.apjdfinalproject.Controllers.Vehicle;
    opens org.example.apjdfinalproject.Controllers.Vehicle to javafx.fxml;
    exports org.example.apjdfinalproject.Controllers.LogInMenu;
    opens org.example.apjdfinalproject.Controllers.LogInMenu to javafx.fxml;

}