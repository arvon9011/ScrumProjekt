package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

public class CabinsController {
    private ObservableList<String> cabinOptionsList = FXCollections.observableArrayList(
            "Svit", "Ekonomi", "Spaceside", "Inside", "Sovkapsel"
    );
    private ObservableList<String> amountOfSeats = FXCollections.observableArrayList(
            "1", "2", "4"
    );

    @FXML
    private ComboBox cabinName;
    @FXML
    private ComboBox amount;
    @FXML
    private TextArea cabinInfo;


    public void initialize(){
        cabinName.setItems(cabinOptionsList);
        amount.setItems(amountOfSeats);
    }

    public void newButton(ActionEvent event){
        cabinName.setValue("");
        amount.setValue("");
        cabinInfo.setText("");
    }

    public void saveCabin(ActionEvent event) throws SQLException {
        //TODO: Gör koll att värdena är valida innan dom skickas in.
        Translator myTranslator = new Translator();

        myTranslator.saveCabin(cabinName.getValue().toString(),
                Integer.parseInt(amount.getValue().toString()),
                cabinInfo.getText());
    }


}
