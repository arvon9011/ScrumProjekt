package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import javafx.event.ActionEvent;

public class HotelsController {

    private ObservableList<String> hotelNamesList = FXCollections.observableArrayList(
            "Polar Lansdorp", "Polar Wielders", "Hotel Phobos", "Hotel Deimos", "Royal City"
    );
    //ComboBox
    @FXML
    private ComboBox hotelNames;
    //CheckBoxes
    @FXML
    private CheckBox svit;
    @FXML
    private CheckBox single;
    @FXML
    private CheckBox dubbel;
    @FXML
    private CheckBox fourBed;
    @FXML
    private CheckBox sixBed;
    //Number of rooms
    @FXML
    private TextField svitNr;
    @FXML
    private TextField singleNr;
    @FXML
    private TextField dubbelNr;
    @FXML
    private TextField fourBedNr;
    @FXML
    private TextField sixBedNr;

    public void initialize(){
        hotelNames.setItems(hotelNamesList);

    }

    public void newButton(ActionEvent event) throws Exception{
        svit.setSelected(false);
        single.setSelected(false);
        dubbel.setSelected(false);
        fourBed.setSelected(false);
        sixBed.setSelected(false);

        svitNr.setText("");
        singleNr.setText("");
        dubbelNr.setText("");
        fourBedNr.setText("");
        sixBedNr.setText("");
    }

    public void saveButton(ActionEvent event) throws Exception{
        Translator myTranslator = new Translator();
        String svitS = null;
        String singleS = null;
        String dubbelS = null;
        String fourBedS = null;
        String sixBedS = null;

        if (svit.isSelected()){
            svitS = svitNr.getText();
        }
        else if (single.isSelected()){
            singleS = singleNr.getText();
        }
        else if (dubbel.isSelected()){
            dubbelS = dubbelNr.getText();
        }
        else if (fourBed.isSelected()){
            fourBedS = fourBedNr.getText();
        }
        else if (sixBed.isSelected()){
            sixBedS = sixBedNr.getText();
        }
        //Lägg till den här metoden i Translator.
        //myTranslator.saveHotel(svitS, singleS, dubbelS, fourBedS, sixBedS);
    }
}
