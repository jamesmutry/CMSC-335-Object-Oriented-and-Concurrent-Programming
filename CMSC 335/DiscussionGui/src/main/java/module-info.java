module com.example.discussiongui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.discussiongui to javafx.fxml;
    exports com.example.discussiongui;
}