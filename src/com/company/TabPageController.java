package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TabPageController {

    public TabPageController(){

    }
    public void logOut(ActionEvent event) throws IOException {
        Parent loggain = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene inlogg = new Scene(loggain);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(inlogg);
        window.show();
    }
}
