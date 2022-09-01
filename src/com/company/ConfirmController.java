package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ConfirmController {


    private String allInfo;
    private String addInfo = "";
    public void setAllInfo(String allInfo) {

        addInfo = addInfo + allInfo;
        this.allInfo = addInfo;
        information.setText(this.allInfo);
    }
    @FXML
    private TextArea information;

    public void initialize(){
        information.setText(allInfo);
    }

    public void showBooking(ActionEvent event) throws Exception{
        this.allInfo = "";
        information.setText(allInfo);
        setAllInfo("Hytt: " + MainMenuController.getCurrentBooking().getCabin() + '\n');
        setAllInfo("Matpaket: " + MainMenuController.getCurrentBooking().getFood() + '\n');
        setAllInfo("Avresedatum: " + MainMenuController.getCurrentBooking().getDate() + '\n');
        setAllInfo("Namn: " + MainMenuController.getCurrentBooking().getName() + '\n');
        setAllInfo("Email: " + MainMenuController.getCurrentBooking().getEmail() + '\n');
        setAllInfo("Hotell: " + MainMenuController.getCurrentBooking().getHotell() + '\n');
        setAllInfo("Hotellrum: " + MainMenuController.getCurrentBooking().getHotellRum() + '\n');
        setAllInfo("Vistelsens längd: " + MainMenuController.getCurrentBooking().getDurationOfStay() + " månader");
    }
    public void sendToDataBase(ActionEvent event) throws Exception{
        Translator myTranslator = new Translator();
        myTranslator.saveBooking(MainMenuController.getCurrentBooking());
    }
}
