module com.example.tddslutprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tddslutprojekt to javafx.fxml;
    exports com.example.tddslutprojekt;
}