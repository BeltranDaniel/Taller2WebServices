package javeriana.ms.sumador;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.stereotype.Repository;

/**
 * RepositorioHistorial
 */
public class RepositorioHistorial {

    public static List<Historial> getHistorial(){
        try {
            Reader reader = new FileReader("historial.json");
            List<Historial> historial = new Gson().fromJson(reader, List.class);
            reader.close();
            return historial;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            return new ArrayList<Historial>();
        }
    }

    public static void addEntry(Historial entry){
        
        try {
            List<Historial> historial = getHistorial();
            historial.add(entry);
            Writer writer = new FileWriter("historial.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(historial, writer);
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}