package javeriana.edu.rest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("trips")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent to the
     * client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("check")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Trip> getAllTrips() {
        List<Trip> trips = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("trips.json"));
            trips = new Gson().fromJson(reader, new TypeToken<ArrayList<Trip>>() {
            }.getType());
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return trips;
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Trip getTripById(@PathParam("id") String id) {
        for (Trip trip : getAllTrips()) {
            if (trip.getID() == Integer.valueOf(id)) {
                return trip;
            }
        }
        return null;
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Trip updateTrip(@PathParam("id") String id, Trip trip) {
        List<Trip> trips = getAllTrips();
        Trip updatedTrip = null;
        for (Trip t : trips) {
            if (t.getID() == Integer.valueOf(id)) {
                t.setDeparture(trip.getDeparture());
                t.setDestination(trip.getDestination());
                updatedTrip = t;
            }
        }
        try {
            Writer writer = new FileWriter("trips.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(trips, writer);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return updatedTrip;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Trip createTrip(Trip trip) throws Exception {

        List<Trip> trips = getAllTrips();
        trip.setID(getNewId());
        trips.add(trip);

        try {
            Gson gson;
            Writer writer = new FileWriter("trips.json");
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(trips, writer);
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return trip;
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String deleteTrip(@PathParam("id") String id) {
        List<Trip> trips = getAllTrips();
        Trip tripToDelete = null;
        for (Trip trip : trips) {
            if (trip.getID() == Integer.valueOf(id)) {
                tripToDelete = trip;
            }
        }

        if (trips.remove(tripToDelete)) {
            try {
                Writer writer = new FileWriter("trips.json");
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(trips, writer);
                writer.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return "El paseo " + tripToDelete.getName() + " fue eliminado con éxito";
        } else {
            return "No existe el paseo con ID " + id;
        }
    }

    private int getNewId() throws Exception {
        File jsonFile = new File("constants.json").getAbsoluteFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject root;
        try {
            Reader reader = Files.newBufferedReader(Paths.get("constants.json"));
            root = gson.fromJson(reader, JsonObject.class);
            int id = root.get("next_id").getAsInt();
            root.addProperty("next_id", id + 1);
            reader.close();

            Writer writer = new FileWriter("constants.json");
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(root, writer);
            writer.close();

            return id;
        } catch (JsonSyntaxException | JsonIOException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        throw new Exception("No se pudo generar un ID");
    }
}
