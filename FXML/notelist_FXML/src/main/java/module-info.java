module com.example.notelist_fxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.notelist_fxml to javafx.fxml;
    exports com.example.notelist_fxml;
}