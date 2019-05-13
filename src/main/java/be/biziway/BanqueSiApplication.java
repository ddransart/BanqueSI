package be.biziway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @ImportResource("spring-beans.xml") // pour importer notre fichier xml dans l'appli, configuration du déploiment de notre webservice soap
public class BanqueSiApplication {
	public static void main(String[] args) {
		SpringApplication.run(BanqueSiApplication.class, args);
	}
}
