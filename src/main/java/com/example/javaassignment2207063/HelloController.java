package com.example.javaassignment2207063;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {


    @FXML
    public void calculateGPA(){
        try {
            SceneLoader.switchScene("Scene1.fxml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
