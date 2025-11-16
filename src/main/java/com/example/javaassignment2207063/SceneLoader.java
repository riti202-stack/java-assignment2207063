package com.example.javaassignment2207063;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SceneLoader {
    private static Stage stage;
    public  static void SetStage(Stage st)
    {
        stage=st;

    }

    public static void switchScene(String fxmlfile) throws Exception
    {
        Parent root= FXMLLoader.load(Objects.requireNonNull(SceneLoader.class.getResource(fxmlfile)));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
