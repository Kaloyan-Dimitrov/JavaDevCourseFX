package com.example.javadevcoursefx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private int x = 0;

    @FXML
    protected void onHelloButtonClick() {
        x ++;
        welcomeText.setText("Welcome to JavaFX Application! " + x);
    }
}