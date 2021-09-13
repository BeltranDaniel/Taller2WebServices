package javeriana.ms.multiplicador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Multiplicador {

    @Autowired
    Environment environment;
    
    //http://localhost:8999/mult?a=45&b=90
    @GetMapping("/mult")
    public String sum(@RequestParam int a,@RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        String response = "Resultado de la multiplicacion " + String.valueOf(a * b) + " Respuesta originada desde: " + port;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        RepositorioHistorial.addEntry(new Historial(LocalDateTime.now().format(formatter), user, response));
        return response + " realizado por el usuario " + user;
    }

    @GetMapping("/operaciones")
    public List<Historial> obtenerHistorial(){
        return RepositorioHistorial.getHistorial();
    }
}
