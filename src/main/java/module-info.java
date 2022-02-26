module com.example.javafx16_6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx16_6 to javafx.fxml;
    exports com.example.javafx16_6;
}