package com.company;

public class Booking {

    //TODO: Add all variables needed to do all inserts.
    //OBS: Generate getters and setters kan göras automatiskt när variablerna skapats.
    public Booking() {

    }
    private String cabin;
    private String food;
    private String date;
    private String name;
    private String email;
    private String hotell;
    private String hotellRum;
    private int durationOfStay;

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public String getHotell() {
        return hotell;
    }

    public void setHotell(String hotell) {
        this.hotell = hotell;
    }

    public String getHotellRum() {
        return hotellRum;
    }

    public void setHotellRum(String hotellRum) {
        this.hotellRum = hotellRum;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public Booking(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
