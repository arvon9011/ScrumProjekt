package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.sql.SQLException;


public class EmployeesController {


    @FXML
    private TextField personNumber;
    @FXML
    private TextField employeenr;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField adress;
    @FXML
    private TextField adressNr;
    @FXML
    private TextField postNr;
    @FXML
    private TextField postadress;
    @FXML
    private TextField mobileNr;



    public void newButton(ActionEvent event) {
        personNumber.setText("");
        employeenr.setText("");
        firstName.setText("");
        lastName.setText("");
        adress.setText("");
        adressNr.setText("");
        postNr.setText("");
        postadress.setText("");
        mobileNr.setText("");
    }


    public void saveEmployee(ActionEvent event) throws SQLException {
        Translator myTranslator = new Translator();
        myTranslator.saveEmployee(Integer.parseInt(personNumber.getText()),
         employeenr.getText(),
         firstName.getText(),
         lastName.getText(),
         adress.getText(),
         Integer.parseInt(adressNr.getText()),
         Integer.parseInt(postNr.getText()),
         postadress.getText(),
         Integer.parseInt(mobileNr.getText()));

    }
}
