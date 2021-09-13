/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientetaller;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author fbhda
 */
public class TripServiceConsumer {

    public static final String RESTCOUNTRIES_SERVER_URL = "http://localhost:8080/myapp/";

    public List<Trip> getAllTrips() {
        //Crear cliente
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(RESTCOUNTRIES_SERVER_URL);
        WebTarget tripWebTarget = webTarget.path("trips");
        //Realizar petición
        Invocation.Builder invocationBuilder = tripWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        //Obtener respuesta
        List<Trip> trips = response.readEntity(new GenericType<List<Trip>>() {});
        return trips;
    }
    
    public Trip getTrip(int id) {
        //Crear cliente
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(RESTCOUNTRIES_SERVER_URL);
        WebTarget tripWebTarget = webTarget.path("trips/{id}").resolveTemplate("id", id);
        //Realizar petición
        Invocation.Builder invocationBuilder = tripWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        //Obtener respuesta
        Trip result = response.readEntity(Trip.class);
        return result;
    }
    
    public String deleteTrip(int id) {
        //Crear cliente
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(RESTCOUNTRIES_SERVER_URL);
        WebTarget tripWebTarget = webTarget.path("trips/{id}").resolveTemplate("id", id);
        //Realizar petición
        Invocation.Builder invocationBuilder = tripWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.delete();
        //Obtener respuesta
        String result = response.readEntity(String.class);
        return result;
    }
    
    public Trip updateTrip(int id, Trip trip) {
        //Crear cliente
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(RESTCOUNTRIES_SERVER_URL);
        WebTarget tripWebTarget = webTarget.path("trips/{id}").resolveTemplate("id", id);
        //Realizar petición
        Invocation.Builder invocationBuilder = tripWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.put(Entity.entity(trip, MediaType.APPLICATION_JSON));
        //Obtener respuesta
        Trip result = response.readEntity(Trip.class);
        return result;
    }
    
     public Trip createTrip( Trip trip) {
        //Crear cliente
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(RESTCOUNTRIES_SERVER_URL);
        WebTarget tripWebTarget = webTarget.path("trips");
        //Realizar petición
        Invocation.Builder invocationBuilder = tripWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(trip, MediaType.APPLICATION_JSON));
        //Obtener respuesta
        Trip result = response.readEntity(Trip.class);
        return result;
    }
     
     
    
    
}
