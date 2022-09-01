package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class BookingController {

    Translator translator = new Translator();
    private ObservableList<String> departureDateList = FXCollections.observableArrayList(
            "2021-01-01", "2021-02-01", "2021-03-01", "2021-04-01", "2021-05-01", "2021-06-01"
            , "2021-07-01", "2021-08-01", "2021-09-01", "2021-10-01", "2021-11-01", "2021-12-01"
    );
    private ObservableList<String> cabinOptionsList = FXCollections.observableArrayList(
            "Svit", "Ekonomi", "Spaceside", "Inside", "Sovkapsel"
    );
    private ObservableList<String> foodOptionsList = FXCollections.observableArrayList(
            "Lyx1", "Lyx2", "Lyx3", "Mellan1", "Mellan2", "Mellan3", "Budget1", "Budget2", "Budget3"
    );
    private ObservableList<String> activitiesList = FXCollections.observableArrayList(
            "Bio", "Bowling", "Skidskytte"
    );
    private ObservableList<String> activitiesShow = FXCollections.observableArrayList(

    );


    private ArrayList<String> activitiesadded = new ArrayList<String>();
    private ArrayList<LocalDate> activitiesDate = new ArrayList<java.time.LocalDate>();
    @FXML
    private TextArea availability;
    @FXML
    private ComboBox<String> showActivities;
    @FXML
    private DatePicker date;
    @FXML
    private TextArea foodInfo;
    @FXML
    private TextArea cabinInfo;
    @FXML
    private ComboBox<String> departureDate;
    @FXML
    private ComboBox<String> cabinOptions;
    @FXML
    private ComboBox<String> foodOptions;
    @FXML
    private ComboBox<String> activities;
    @FXML
    private Button add;
    @FXML
    private Button delete;

    public BookingController() throws SQLException {


    }



    @FXML
    public void initialize(){
        departureDate.setValue("Avresedatum");
        departureDate.setItems(departureDateList);

        cabinOptions.setValue("Hyttalternativ");
        cabinOptions.setItems(cabinOptionsList);

        foodOptions.setValue("Matpaket");
        foodOptions.setItems(foodOptionsList);

        activities.setValue("Evenemang");
        activities.setItems(activitiesList);



    }


    public void cabinOptionsComboBox(ActionEvent event) throws Exception {
        if (cabinOptions.getValue().equalsIgnoreCase("Sovkapsel")){
            foodOptions.setDisable(true);
            activities.setDisable(true);
            date.setDisable(true);
            showActivities.setDisable(true);
            add.setDisable(true);
            delete.setDisable(true);
            foodInfo.setDisable(true);
        }
        else{
            foodOptions.setDisable(false);
            activities.setDisable(false);
            date.setDisable(false);
            showActivities.setDisable(false);
            add.setDisable(false);
            delete.setDisable(false);
            foodInfo.setDisable(false);
        }

        if (cabinOptions.getValue().equalsIgnoreCase("Sovkapsel")){
            cabinInfo.setText("Sovkapsel innebär att du ligger \n i koma under hela färden \n 1000 000kr");
        }
        else if (cabinOptions.getValue().equalsIgnoreCase("Svit")){
            cabinInfo.setText("Svit är en fin hytt \n 500 000kr");
        }
        else if (cabinOptions.getValue().equalsIgnoreCase("Spaceside")){
            cabinInfo.setText("Spaceside är en vanlig normalstor hytt\n med en utsökt utsikt över rymden\n 250 000kr");
        }
        else if (cabinOptions.getValue().equalsIgnoreCase("Inside")){
            cabinInfo.setText("Inside är en vanlig normalstor hytt\n 120 000kr");
        }
        else if (cabinOptions.getValue().equalsIgnoreCase("Ekonomi")){
            cabinInfo.setText("Ekonomi är en liten hytt utan \nfönster och lite kloustrofobisk\n 75 000kr");
        }
        MainMenuController.getCurrentBooking().setCabin(cabinOptions.getValue());
    }

    public void foodOptionsComboBox(ActionEvent event) throws Exception{
        if (foodOptions.getValue().equalsIgnoreCase("Lyx3")){
            foodInfo.setText("Lyx 3 är den finaste maten \n300 000kr");
        }
        else if (foodOptions.getValue().equalsIgnoreCase("Mellan3")){
            foodInfo.setText("Mellan 3 är god mat \n100 000kr");
        }
        else if (foodOptions.getValue().equalsIgnoreCase("Budget1")){
            foodInfo.setText("Budget 1 är den sämsta maten\n 1000kr");
        }
        MainMenuController.getCurrentBooking().setFood(foodOptions.getValue());
    }

    public void addActivities(ActionEvent event) throws Exception{
        String tempActivities = activities.getValue() + " " + date.getValue();
        activitiesadded.add(activities.getValue());
        activitiesDate.add(date.getValue());
        activitiesShow.add(tempActivities);
        showActivities.setItems(activitiesShow);
    }
    public void deleteActivities(ActionEvent event) throws Exception{
        for (int i = 0; i < activitiesadded.size(); i++) {
            if (activitiesShow.get(i).equalsIgnoreCase(showActivities.getValue())){
                activitiesadded.remove(i);
                activitiesDate.remove(i);
                activitiesShow.remove(i);
                showActivities.setItems(activitiesShow);
            }
        }
    }
    public void chooseDate(ActionEvent event) throws Exception{
        //TODO kör lediga hytter en gång och spara som array.
        MainMenuController.getCurrentBooking().setDate(departureDate.getValue());
        //LedigaHytter metoden ska skicka en arrayList med de hytter som är lediga
        //ledigtPÅFärjan ska skicka med en int med hur många platser som finns kvar av 360
        availability.setText(translator.ledigtPåFärjan(departureDate.getValue(), true) + " Platser finns kvar" + '\n' +
                translator.ledigaHytter(departureDate.getValue(), true) + " Dessa hytter är lediga");
        int hej = 0;
        for (int i = 0; i < translator.ledigaHytter(departureDate.getValue(), true).size(); i++) {
            if (cabinOptions.getValue().equalsIgnoreCase((String) translator.ledigaHytter(departureDate.getValue(), true).get(i))){
                hej++;
            }
        }
        if (hej == 0){
            cabinOptions.setValue("Hyttalternativ");
            cabinInfo.setText(null);
        }

    }
    public void sendToData(ActionEvent event) throws Exception{

    }




}
