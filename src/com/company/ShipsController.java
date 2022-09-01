package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import javax.xml.stream.FactoryConfigurationError;
import java.sql.SQLException;


public class ShipsController {

    @FXML
    private TextField shipName;
    @FXML
    private TextField numberOfSeats;
    @FXML
    private TextField amountOfKapsel;
    @FXML
    private TextField amountOfSvit;
    @FXML
    private TextField amountOfSpaceSide;
    @FXML
    private TextField amountOfInside;
    @FXML
    private TextField amountOfEconomy;

    @FXML
    private CheckBox kapsel;
    @FXML
    private CheckBox svit;
    @FXML
    private CheckBox spaceSide;
    @FXML
    private CheckBox inside;
    @FXML
    private CheckBox economy;


    public void newButton(javafx.event.ActionEvent event) {
        shipName.setText("");
        numberOfSeats.setText("");
        kapsel.setSelected(false);
        svit.setSelected(false);
        spaceSide.setSelected(false);
        inside.setSelected(false);
        economy.setSelected(false);
        amountOfKapsel.setText("");
        amountOfSvit.setText("");
        amountOfSpaceSide.setText("");
        amountOfInside.setText("");
        amountOfEconomy.setText("");
    }

    public void confirmShip(javafx.event.ActionEvent event) throws Exception {
        Translator myTranslator = new Translator();
        myTranslator.saveShip(shipName.getText(),
                                  amountOfKapsel.getText(),
                                  amountOfSvit.getText(),
                                  amountOfSpaceSide.getText(),
                                  amountOfInside.getText(),
                                  amountOfEconomy.getText());
    }
}