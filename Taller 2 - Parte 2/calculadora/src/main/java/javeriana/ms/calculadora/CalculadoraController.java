package javeriana.ms.calculadora;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/calculadora/suma")
    public String calculadoraSuma(@RequestParam int a,@RequestParam int b,@RequestParam String user){
        //consumir sumador
        String response = restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&user={user}", String.class, a, b,user);
        return response;
    }

    @GetMapping("/calculadora/suma/operaciones")
    public List<Historial> getOperacionesSuma(){
        List<Historial> response = restTemplate.getForObject("http://sumador/operaciones", List.class);
        return response;
    }

    @GetMapping("/calculadora/mult")
    public String calculadoraMult(@RequestParam int a,@RequestParam int b,@RequestParam String user){
        //consumir sumador
        String response = restTemplate.getForObject("http://multiplicador/mult?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculadora/mult/operaciones")
    public List<Historial> getOperacionesMultiplicacion(){
        List<Historial> response = restTemplate.getForObject("http://multiplicador/operaciones", List.class);
        return response;
    }

    @GetMapping("/calculadora/resta")
    public String calculadoraResta(@RequestParam int a,@RequestParam int b,@RequestParam String user){
        //consumir sumador
        String response = restTemplate.getForObject("http://substractor/resta?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculadora/resta/operaciones")
    public List<Historial> getOperacionesResta(){
        List<Historial> response = restTemplate.getForObject("http://substractor/operaciones", List.class);
        return response;
    }

    @GetMapping("/calculadora/div")
    public String calculadoraDiv(@RequestParam int a,@RequestParam int b,@RequestParam String user){
        //consumir sumador
        String response = restTemplate.getForObject("http://divisor/div?a={a}&b={b}&user={user}", String.class, a, b, user);
        return response;
    }

    @GetMapping("/calculadora/div/operaciones")
    public List<Historial> getOperacionesDivision(){
        List<Historial> response = restTemplate.getForObject("http://divisor/operaciones", List.class);
        return response;
    }
}
