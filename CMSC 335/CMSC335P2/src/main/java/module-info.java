module com.example.cmsc335p2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cmsc335p2 to javafx.fxml;
    exports com.example.cmsc335p2;
}