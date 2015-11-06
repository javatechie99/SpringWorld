package com.springws.client;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.springws.wsdlgenerated.Country;
import com.springws.wsdlgenerated.GetCountryRequest;
import com.springws.wsdlgenerated.GetCountryResponse;

public class CountryWSClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryWSClient.class);

	public GetCountryResponse getCountryByName(String countryName) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(countryName);

		log.info("Requesting Country for " + countryName);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive(
						"http://localhost:9080/SpringWSDemo-0.0.1-SNAPSHOT/ws",
						request,
						new SoapActionCallback("http://localhost:9080/SpringWSDemo-0.0.1-SNAPSHOT/ws/GetCountryByName"));

		if(response != null){
			log.info("Country > "+ response.getCountry());
			log.info("Capital > "+ response.getCountry().getCapital());
			log.info("Currency > "+ response.getCountry().getCurrency());
		}
		printResponse(response);
		return response;
	}

	public void printResponse(GetCountryResponse response) {

		Country country = response.getCountry();

		if (country != null) {
			log.info("Capital :" + country.getCapital() + ", Currency : " + country.getCurrency());			
		} else {
			log.info("No Country Found!!");
		}
	}

}