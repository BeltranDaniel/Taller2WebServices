package javeriana.edu.rest;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip {
    private int ID;
    private String name;
    private String departure;
    private String destination;
    private LocalDate date;

    
    public Trip(){

    }
    
    public Trip(int iD, String name, String departure, String destination, LocalDate date) {
        ID = iD;
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

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
}
