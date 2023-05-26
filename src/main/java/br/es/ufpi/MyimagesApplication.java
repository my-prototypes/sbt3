package br.es.ufpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.es.ufpi.entity")
public class MyimagesApplication {

	public static void main(String[] args) {
		System.out.println("Aplicação Web de Teste.");
		SpringApplication.run(MyimagesApplication.class, args);
	}

}
