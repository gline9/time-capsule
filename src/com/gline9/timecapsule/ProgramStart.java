package com.gline9.timecapsule;

import com.gline9.timecapsule.less.Handler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgramStart extends Application
{

    public static void main(String[] args)
    {
        Handler.registerStyleSheet("src/com/gline9/timecapsule/gui/App.less");
        Handler.registerStyleSheet("src/com/gline9/timecapsule/gui/core/styles/styles.less");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("gui/App.fxml"));
        
        Scene scene = new Scene(root, 300, 300);
        scene.getStylesheets().add("less:src/com/gline9/timecapsule/gui/App.less");
        scene.getStylesheets().add("less:src/com/gline9/timecapsule/gui/core/styles/styles.less");
        
        stage.setTitle("Time Capsule");
        stage.setScene(scene);
        stage.show();
    }
}
