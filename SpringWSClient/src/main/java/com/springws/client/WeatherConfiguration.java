package com.springws.client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.springws.wsdlgenerated");
		return marshaller;
	}

	@Bean
	public CountryWSClient countryClient(Jaxb2Marshaller marshaller) {
		CountryWSClient client = new CountryWSClient();
		client.setDefaultUri("http://localhost:9080/SpringWSDemo-0.0.1-SNAPSHOT/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}