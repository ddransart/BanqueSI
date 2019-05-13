package be.biziway;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import be.biziway.rmi.BanqueRmiRemote;

@Configuration // classe de configuration. iici on centralise toute la configuration des injections de dépendances
public class MyConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8089/maBanque");
		return exporter;
	}

	// creer une méthode qui permet de retourner le service RMIServiceExporter
	@Bean
	public RmiServiceExporter getRmiService(ApplicationContext ctx) {
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setService(ctx.getBean("myRmiService")); // notre bean est le nom de notre composant rmi
		exporter.setRegistryPort(1099); // l'annuaire rmi va nous demarrer sur ce port
		exporter.setServiceName("BK"); // Le service va le publier dans l'annuaire avec ce nom
		exporter.setServiceInterface(BanqueRmiRemote.class);
		return exporter;
	}

}
