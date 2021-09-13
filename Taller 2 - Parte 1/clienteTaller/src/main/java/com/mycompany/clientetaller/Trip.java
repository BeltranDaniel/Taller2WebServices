/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientetaller;

import java.time.LocalDate;

/**
 *
 * @author fbhda
 */
public class Trip {

    private int ID;
    private String name;
    private String departure;
    private String destination;
    private LocalDate date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID= " + ID +
                "\nname= " + name + 
                "\ndeparture= " + departure + 
                "\ndestination= " + destination + 
                "\ndate= " + date;
    }

}
