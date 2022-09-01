package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Translator {
    public Translator() throws SQLException {
        //KOM IHÅG LÖSEN!!!!!!!!!!!!!!!!!!!!!
        // Infon varierar beroende på er dator, men user och password borde ni kunna. URL:n borde va den samma.
        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mars_travels?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "apkalsong9999");
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    private Connection myCon;

    //public void saveBooking(String cabinOption, String foodOption, String monthOption, String nameOption, String emailOption, boolean marsOption, String hotelOption, String roomOption, int durationOption) throws SQLException {
    public void saveBooking(Booking inBooking) throws SQLException {

        //TODO: Remove this when Booking can handle both directions.
        boolean toMars = true;

        try {

            Statement myStatement = myCon.createStatement();


            //System.out.println(inBooking.getFood());
            String insertCustomer = "insert into customers" + "(name, email)" + "values ('" + inBooking.getName() + "'," + "'" + inBooking.getEmail() + "');";
            String insertBooking = "insert into bookings" + "(customer_id)" + "values  (LAST_INSERT_ID());";
            String insertMarsBooking = "INSERT INTO mars_bookings" + "(booking_id, hotel, room, duration)" + "values" + "(LAST_INSERT_ID(), " +
                    "'" + inBooking.getHotell() + "'," + "'" + inBooking.getHotellRum() + "'," + "'" + inBooking.getDurationOfStay() + "');";
            String insertTrips = "insert into trips" + "(booking_id, shipping_id, food, sleep)" + "values" + "((SELECT id from bookings\n" +
                    "ORDER BY id DESC LIMIT 1), " + "( SELECT id FROM shipping\n" +
                    "WHERE departure =" + "'" + inBooking.getDate() + "'" + "AND to_mars =" + toMars + ")" + ", '" + inBooking.getFood() + "', '" + inBooking.getCabin() + "');";


            myStatement.executeUpdate(insertCustomer); // "SQL" stringen körs in i SQL
            myStatement.executeUpdate(insertBooking); // "SQL" stringen körs in i SQL
            myStatement.executeUpdate(insertMarsBooking);
            myStatement.executeUpdate(insertTrips);


            ResultSet myRes = myStatement.executeQuery("SELECT name, email, food, sleep, shipping_id, hotel, room, duration FROM customers\n" +
                    "JOIN bookings on customers.id = bookings.customer_id\n" +
                    "JOIN trips on bookings.id = trips.booking_id\n" +
                    "JOIN mars_bookings on mars_bookings.booking_id = bookings.id\n" +
                    "WHERE customers.id = (SELECT id from customers\n" +
                    "ORDER BY id DESC LIMIT 1);");
            // process the result set
            while (myRes.next()) {
                System.out.println(myRes.getString("name") + ", " + myRes.getString("email") + ", " + myRes.getString("food") +
                        ", " + myRes.getString("sleep") + ", " + myRes.getString("shipping_id") + ", " + myRes.getString("hotel") +
                        ", " + myRes.getString("room") + ", " + myRes.getString("duration"));
            }
            // man kunde ta bort "adress" ur sista raden, alltså blir det superlätt att leta upp info. FUCK VA SKÖNT
            /* myStatement.executeUpdate(sql); // "SQL" stringen körs in i SQL
             myStatement.executeUpdate(sql); // "SQL" stringen körs in i SQL */


          /*
            ResultSet myRes = myStatement.executeQuery("select * from customers;");
            // process the result set
            while (myRes.next()) {
                System.out.println(myRes.getString("name") + ", " + myRes.getString("email"));
                // man kunde ta bort "adress" ur sista raden, alltså blir det superlätt att leta upp info. FUCK VA SKÖNT
            } */
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public void saveShip(String inName, String inKapsel, String inSvit, String inSpaceSide, String inInside, String inEconomy) {

        try {
            Statement myStatement = myCon.createStatement();
            String insertShip = "INSERT INTO ships" + "(name, kapsel, svit, spaceSide, inside, economy )" + "values ('" + inName
                    + "'," + "'" + Integer.parseInt(inKapsel)
                    + "'," + "'" + Integer.parseInt(inSvit)
                    + "'," + "'" + Integer.parseInt(inSpaceSide)
                    + "'," + "'" + Integer.parseInt(inInside)
                    + "'," + "'" + Integer.parseInt(inEconomy)
                    + "');";

            myStatement.executeUpdate(insertShip); // "SQL" stringen körs in i SQL
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    /*myTranslator.saveCabin(cabinName.getValue(),
                amount.getValue(),
                cabinInfo.getText());*/

    public void saveCabin(String inName, int inAmount, String inInfo) {

        try {
            Statement myStatement = myCon.createStatement();
            String updateCapacity = "update cabinTypes " + "set "  + "capacity "  + "= "  + inAmount +  " WHERE name = " + "'" + inName + "'" + ";";

            String updateInfo = "update cabinTypes WHERE name = " + inName + " set " + "info " + "= " + "'" + inInfo + "';";
            System.out.println(updateCapacity);
             myStatement.executeUpdate(updateCapacity);
             myStatement.executeUpdate(updateInfo); // "SQL" stringen körs in i SQL
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void saveFoodPackage(String inName, String inOptions) {

        try {
            Statement myStatement = myCon.createStatement();
            String updateInfo = "update livingOptions WHERE name = " + inName + " set " + "capacity " + "=" + "'" + inOptions + "';";

            myStatement.executeUpdate(updateInfo);
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }


    public void saveFood(String foodOption, String newMenu) {
        // foodOption är det packet som förändras, newMenu är de nya resturangerna.
        try {
            Statement myStatement = myCon.createStatement();
            String insertFood = "update foodOptions" + "set " + foodOption + "=" + "'" + newMenu + "'";

            //TODO DE HÄR VARIABLERNA BEHÖVER KOPPLAS HJÄLPA OSS JAVA BOYS, ALLA FOODOPTION ÄR MED SMÅ BOKSTÄVTER

            myStatement.executeUpdate(insertFood); // "SQL" stringen körs in i SQL
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

     public void saveEmployee(Integer inPersonnummer, String employeenr, String firstName,
                              String lastName, String adress, Integer adressNr, Integer postNr,
                              String postadress, Integer mobileNr) {

         try { adress = adress + "("+postNr+")";
             Statement myStatement = myCon.createStatement();
             String insertEmployee = "INSERT INTO employees (f_name, l_name, person_number, employee_number, phone, city_or_state, zip_code, adress)"+
                "VALUES(" +
                     "'" + firstName +"',"+
                     "'" + lastName +"',"+
                      + inPersonnummer +
                     ", '" + employeenr +"',"+
                      + mobileNr +
                     ", '" + postadress +"',"+
                      ""+ adressNr +""+
                     ", '"+ adress +"'"+
                     ");";

             myStatement.executeUpdate(insertEmployee);
             System.out.println(insertEmployee);
         } catch (Exception exc) {
             exc.printStackTrace();
         }
     }
    public ArrayList<String> ledigaHytter(String departureDate, boolean inToMars) {
        //TODO: Test with "real" data

        //sleep, Svit, Spaceside, Inside, Economy.
        int[] capacities = {20, 20, 40, 80, 200};

        ResultSet resultFromDB;


        ArrayList<String> hytter = new ArrayList<String>();
        //"Spaceside", "Ekonomi", "Sovkapsel", "Inside", "Svit"
        hytter.add("Spaceside");
        hytter.add("Ekonomi");
        hytter.add("Sovkapsel");
        hytter.add("Inside");
        hytter.add("Svit");

        try (Statement myStatement = myCon.createStatement()) {

            String myREALQuery = "SELECT trips.sleep, count(trips.sleep) AS hyttValue FROM shipping JOIN trips ON trips.shipping_id = shipping.id GROUP BY trips.sleep ORDER BY trips.sleep;";

            String myQuery = "SELECT sleep, count(trips.sleep) AS hyttValue FROM shipping " +
                    "JOIN trips WHERE trips.shipping_id = shipping.id " +
                    "GROUP BY trips.sleep " +
                    "ORDER BY trips.sleep;";
            resultFromDB = myStatement.executeQuery(myREALQuery);

            //Check availability of each type of cabin and add it's name the array if it is available

            int ticker = 0;
            while (resultFromDB.next()) {
                // System.out.println(resultFromDB.getString("sleep")+" "+ resultFromDB.getString("hyttValue"));
                //Capacitet - Bokade platser = lediga platser.
                if (capacities[ticker] - Integer.parseInt(resultFromDB.getString("hyttValue")) < 1) {
                    hytter.remove(resultFromDB.getString("sleep"));
                }
                ticker++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return hytter;
        }
        return hytter;
    }

    public int ledigtPåFärjan(String departureDate, boolean to_mars) {
        int antalLedigaPlatser = 360;
        return antalLedigaPlatser;
    }


}








