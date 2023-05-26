package br.es.ufpi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {
    @GetMapping("/")
    public String ola(){
        return "Bem vindo de volta ao Spring Boot!";
    }
}
