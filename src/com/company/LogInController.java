package com.company;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private TextField userName;
    @FXML
    private PasswordField passWord;



    public void logIn(ActionEvent event) throws IOException{
        if (passWord.getText().equals("grupp8") && userName.getText().equals("grupp8") ){
            Parent loggain = FXMLLoader.load(getClass().getResource("TabPage.fxml"));
            Scene inlogg = new Scene(loggain);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(inlogg);
            window.show();
        }
        else{
            userName.clear();
            passWord.clear();
        }
    }
}
