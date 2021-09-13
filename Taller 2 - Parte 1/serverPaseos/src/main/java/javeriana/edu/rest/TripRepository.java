package javeriana.edu.rest;

import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    
    private static int NEXT_ID = 0;
    private static List<Trip> trips = new ArrayList<>();

    public List<Trip> getAllTrips(){
        return trips;
    }
}
