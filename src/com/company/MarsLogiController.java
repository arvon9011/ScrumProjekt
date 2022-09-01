package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarsLogiController {

    private final ObservableList<String> durationOfStayList = FXCollections.observableArrayList(
            "1 mån", "2 mån", "3 mån", "4 mån", "5 mån", "6 mån", "7 mån", "8 mån", "9 mån", "10 mån", "11 mån", "12 mån"
    );
    private final Map<String, ObservableList<String>> hotelOptionsMap = new HashMap<>();
    private final Map<String, String> hotelInfoTexts = new HashMap<String, String>();

    @FXML
    private ComboBox durationOfStay;
    @FXML
    private ComboBox hotelOptions;
    @FXML
    private ComboBox hotelRoomOptions;
    @FXML
    private TextArea commonInfo;
    @FXML
    private TextArea hotelInfo;
    @FXML
    private TextArea activityInfo;
    @FXML
    private TextField sumCost;

    public void initialize(){
        durationOfStay.setItems(durationOfStayList);
        durationOfStay.setValue(durationOfStayList.get(0));
        //hotelOptions.setItems(hotelOptionsList);
        hotelOptionsMap.put("Polar Lansdorp", FXCollections.observableArrayList("3500 kr/bädd"));
        hotelOptionsMap.put("Polar Wielders", FXCollections.observableArrayList("5000 kr/bädd"));
        hotelOptionsMap.put("Hotel Phobos", FXCollections.observableArrayList("Enkelrum: 7500 kr", "Dubbelrum: 12 000 kr"));
        hotelOptionsMap.put("Hotel Deimos", FXCollections.observableArrayList("Enkelrum: 7500 kr", "Dubbelrum: 12 000 kr"));
        hotelOptionsMap.put("Royal City", FXCollections.observableArrayList("Enkel Lyx: 20 000 kr", "Dubbel Lyx: 35 000 kr", "Svit: 50 000 kr"));
        hotelOptions.setItems(FXCollections.observableArrayList(hotelOptionsMap.keySet()));
        hotelInfoTexts.put("common", "Information om vistelsen på Mars\n" +
                "På Mars så kan man välja att antingen bo vid polerna, vid ekvatorn eller på Valles" +
                "Marineris. Alla måltider ingår i alla boenden.");
        hotelInfoTexts.put("Polar Lansdorp", "Polar Lansdorp och Polar Wielders är båda enkla hotell där man delar rum med andra" +
                "människor (6-bäddsrum på Lansdorp och 4-bäddsrum på Wielders). Varje rum har" +
                "egen dusch och toalett. Det finns en matsal där måltiderna serveras vid bestämda tider." +
                "Hotellet har flera olika lounger där man kan umgås, njuta vid den konstgjorda brasan i" +
                "öppna spisen, läsa böcker, lyssna på musik eller spela spel. Det finns också en" +
                "träningslokal för både kondition och styrketräning, samt gruppövningar.");
        hotelInfoTexts.put("Polar Wielders", hotelInfoTexts.get("Polar Lansdorp"));
        hotelInfoTexts.put("Hotel Phobos", "Hotel Phobos och Hotel Deimos ligger vid ekvatorn på Mars och båda hotellen har" +
                "både enkelrum och dubbelrum med egen dusch och toalett. Varje rum är också inredd" +
                "med en liten soffa och tv (filmer, serier och spel finns tillgängliga). I restaurangen" +
                "serveras måltiderna, men man kan också få maten serverad på rummen. Flera olika" +
                "lounger med olika teman finns så som bibliotek, biljardrum (där även andra spel finns)," +
                "musikrum och bio. Träningslokal med redskap för styrke- och konditionsträning finns" +
                "samt tränare för gruppövningar.");
        hotelInfoTexts.put("Hotel Deimos",  hotelInfoTexts.get("Hotel Phobos"));
        hotelInfoTexts.put("Royal City", "Royal City är ett charmigt lyxhotell insprängt i berget i dalgången i Valles Marineris. Här" +
                "finns sviter med dubbelsäng och vardagsrum där man kan få samtliga måltider" +
                "serverade. Lyxrum med enkel eller dubbelbäddar och mini-loungedel finns också att" +
                "tillgå. Restaurangen har de bästa kockarna och maten som serveras är inte bara en" +
                "njutning smakmässigt utan även hälsosam. Lyxigt inredda bibliotek, teatersalong, lounge" +
                "för att umgås och träningslokaler där flertalet personliga tränare är redo att skapa" +
                "passande träningsprogram. I närheten finns en galleria.");
        hotelInfoTexts.put("activities", "Programmet för vistelsen är träning på morgonen efter frukost. Detta då gravitation och" +
                "syre på Mars gör att man måste hålla sig i form. Det sker dagsutflykter 2-3 gånger i" +
                "veckan och en längre utflykt (med övernattning) 1-2 gånger i månaden. Man bokar in sig" +
                "på de utflykter man vill vara med på när man anländer till hotellet.\n\n" +
                "Dagsutflykter kan handla om utfärd till någon närliggande vulkan, iskalott eller den" +
                "vidsträckta slätten. Längre utflykter handlar om att besöka Olympusberget med" +
                "övernattning på bergets topp, resa runt månen Phobos, besöka farmen där all mat" +
                "tillverkas eller för de som inte bor på Royal City kan man göra en övernattning på" +
                "vandrarhemmet i Valles Marineris för att kunna spendera tid i gallerian.");
        commonInfo.setText(hotelInfoTexts.get("common"));
        activityInfo.setText(hotelInfoTexts.get("activities"));
    }

    public void hotelOptionsComboBox(ActionEvent event) throws Exception{
        //TODO: add check availability for the rooms
        hotelInfo.setText(hotelInfoTexts.get(hotelOptions.getValue()));
        hotelRoomOptions.setItems(hotelOptionsMap.get(hotelOptions.getValue()));
        MainMenuController.getCurrentBooking().setHotell((String) hotelOptions.getValue());

    }

    public void calcCost(ActionEvent event) throws Exception{
        //int monthCost = Integer.parseInt();
        MainMenuController.getCurrentBooking().setHotellRum((String) hotelRoomOptions.getValue());
        int months = Integer.parseInt(durationOfStay.getValue().toString().split(" ",2)[0]);
        MainMenuController.getCurrentBooking().setDurationOfStay(months);

    }

}
