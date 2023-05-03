module com.example.keepingnotes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.keepingnotes to javafx.fxml;
    exports com.example.keepingnotes;
}