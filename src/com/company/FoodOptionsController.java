package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.sql.SQLException;

public class FoodOptionsController {
    private ObservableList<String> foodOptionsList = FXCollections.observableArrayList(
            "Lyx1", "Lyx2", "Lyx3", "Mellan1", "Mellan2", "Mellan3", "Budget1", "Budget2", "Budget3"
    );
    @FXML
    private ComboBox foodPackageName;

    @FXML
    private CheckBox marsDonalds;
    @FXML
    private CheckBox marsDonaldsBreakfast;
    @FXML
    private CheckBox marsDonaldsLunch;
    @FXML
    private CheckBox marsDonaldsSnack;
    @FXML
    private CheckBox marsDonaldsDinner;
    @FXML
    private CheckBox marsianBuffe;
    @FXML
    private CheckBox marsianBuffeBreakFast;
    @FXML
    private CheckBox marsianBuffeLunch;
    @FXML
    private CheckBox marsianBuffeSnack;
    @FXML
    private CheckBox marsianBuffeDinner;
    @FXML
    private CheckBox tellusHome;
    @FXML
    private CheckBox tellusHomeBreakFast;
    @FXML
    private CheckBox tellusHomeLunch;
    @FXML
    private CheckBox tellusHomeSnack;
    @FXML
    private CheckBox tellusHomeDinner;
    @FXML
    private CheckBox spaceView;
    @FXML
    private CheckBox spaceViewBreakFast;
    @FXML
    private CheckBox spaceViewLunch;
    @FXML
    private CheckBox spaceViewSnack;
    @FXML
    private CheckBox spaceViewDinner;

    public void initialize(){
        foodPackageName.setItems(foodOptionsList);
    }


    public void nyButton(ActionEvent event) {
        marsDonalds.setSelected(false);
        marsDonaldsBreakfast.setSelected(false);
        marsDonaldsLunch.setSelected(false);
        marsDonaldsSnack.setSelected(false);
        marsDonaldsDinner.setSelected(false);
        marsianBuffe.setSelected(false);
        marsianBuffeBreakFast.setSelected(false);
        marsianBuffeLunch.setSelected(false);
        marsianBuffeSnack.setSelected(false);
        marsianBuffeDinner.setSelected(false);
        tellusHome.setSelected(false);
        tellusHomeBreakFast.setSelected(false);
        tellusHomeLunch.setSelected(false);
        tellusHomeSnack.setSelected(false);
        tellusHomeDinner.setSelected(false);
        spaceView.setSelected(false);
        spaceViewBreakFast.setSelected(false);
        spaceViewLunch.setSelected(false);
        spaceViewSnack.setSelected(false);
        spaceViewDinner.setSelected(false);

    }

    public void saveFood(ActionEvent event) throws SQLException{
        Translator myTranslator = new Translator();
        String save = "";

        //TODO: foodoptionName skall vara små i bokstäver.

        if (marsDonalds.isSelected()){
            save += "MarsDonalds;";
            if (marsDonaldsBreakfast.isSelected()){
                save += "Frukost;";
            }
            else {
                save += "ingen frukost;";
            }

            if (marsDonaldsLunch.isSelected()){
                save += "Lunch;";
            }
            else {
                save += "ingen lunch;";
            }

            if (marsDonaldsSnack.isSelected()){
                save += "MellanMål;";
            }
            else {
                save += "inget mellanmål;";
            }

            if (marsDonaldsDinner.isSelected()){
                save += "Middag;";
            }
            else{
                save += "ingen middag;";
            }
        }
        else if (marsianBuffe.isSelected()){
            save += "Marsian Buffe;";
            if (marsianBuffeBreakFast.isSelected()){
                save += "Frukost;";
            }
            else {
                save += "ingen frukost;";
            }
            if (marsianBuffeLunch.isSelected()){
                save += "Lunch;";
            }
            else{
                save += "Ingen lunch;";
            }
            if (marsianBuffeSnack.isSelected()){
                save += "MellanMål;";
            }
            else {
                save += "inget mellanmål;";
            }
            if (marsianBuffeDinner.isSelected()){
                save += "Middag";
            }
            else {
                save += "Ingen middag;";
            }
        }
        else if (tellusHome.isSelected()){
            save += "Marsian Buffe;";
            if (tellusHomeBreakFast.isSelected()){
                save += "Frukost;";
            }
            else {
                save += "ingen frukost;";
            }
            if (tellusHomeLunch.isSelected()){
                save += "Lunch;";
            }
            else{
                save += "Ingen lunch;";
            }
            if (tellusHomeSnack.isSelected()){
                save += "MellanMål;";
            }
            else {
                save += "inget mellanmål;";
            }
            if (tellusHomeDinner.isSelected()){
                save += "Middag";
            }
            else {
                save += "Ingen middag;";
            }
        }
        else if (spaceView.isSelected()){
            save += "Marsian Buffe;";
            if (spaceViewBreakFast.isSelected()){
                save += "Frukost;";
            }
            else {
                save += "ingen frukost;";
            }
            if (spaceViewLunch.isSelected()){
                save += "Lunch;";
            }
            else{
                save += "Ingen lunch;";
            }
            if (spaceViewSnack.isSelected()){
                save += "MellanMål;";
            }
            else {
                save += "inget mellanmål;";
            }
            if (spaceViewDinner.isSelected()){
                save += "Middag";
            }
            else {
                save += "Ingen middag;";
            }
        }
        myTranslator.saveFoodPackage(foodPackageName.getValue().toString(), save);

    }



}
