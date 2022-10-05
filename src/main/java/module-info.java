module com.example.javadevcoursefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javadevcoursefx to javafx.fxml;
    exports com.example.javadevcoursefx;
}