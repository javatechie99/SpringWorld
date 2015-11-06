package com.springws.client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springws.wsdlgenerated.GetCountryResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(final CountryWSClient countryClient) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... strings) throws Exception {
				
				String countryName = "Poland";
				
				if (strings.length > 0) {
					countryName = strings[0];
				}
				
				GetCountryResponse response = countryClient.getCountryByName(countryName);	
			}			
		};
	}

}