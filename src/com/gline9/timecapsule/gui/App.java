package com.gline9.timecapsule.gui;

import com.gline9.timecapsule.message.Message;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class App
{
    @FXML
    private TextField textField;
    
    @FXML
    private void createMessage(ActionEvent event)
    {
        String text = textField.getText();
        textField.setText("");
        if ("".equals(text))
        {
            textField.getStyleClass().add("text-field-invalid");
            return;
        }
        Message.insertNewMessage(text);
    }
    
}
