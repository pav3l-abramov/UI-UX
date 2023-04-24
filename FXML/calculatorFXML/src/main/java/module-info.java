module com.example.calculatorfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.calculatorfxml to javafx.fxml;
    exports com.example.calculatorfxml;
}