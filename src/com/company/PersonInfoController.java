package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class PersonInfoController {

    public PersonInfoController() {

    }

    @FXML
    private Label missingInfo;
    @FXML
    private TextField name;
    @FXML
    private TextField email;

    public void initialize(){

    }

    public void saveButton(javafx.event.ActionEvent event) throws Exception {

        if (email.getText().equalsIgnoreCase("") || name.getText().equalsIgnoreCase("")){
            missingInfo.setText("Något värde saknas! :(");
        }
        else {
            MainMenuController.getCurrentBooking().setEmail(email.getText());
            MainMenuController.getCurrentBooking().setName(name.getText());
            missingInfo.setText("");
        }
    }


}
