package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

    public static Booking currentBooking;

    public void bokaResaButton(ActionEvent event) throws Exception {
        Parent bokaResa = FXMLLoader.load(getClass().getResource("booking.fxml"));
        Scene bokaResaScene = new Scene(bokaResa);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(bokaResaScene);
        window.show();

    }

    public MainMenuController() {
        currentBooking = new Booking();
    }



    public static Booking getCurrentBooking() {
        return currentBooking;
    }

}