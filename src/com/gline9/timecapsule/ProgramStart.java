package com.gline9.timecapsule;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramStart extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("gui/App.fxml"));
        
        Scene scene = new Scene(root, 300, 300);
        scene.getStylesheets().add("com/gline9/timecapsule/gui/App.css");
        
        stage.setTitle("Time Capsule");
        stage.setScene(scene);
        stage.show();
    }
}
