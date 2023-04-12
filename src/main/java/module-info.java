module com.example.assignment2tester {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment2tester to javafx.fxml;
    exports com.example.assignment2tester;
}