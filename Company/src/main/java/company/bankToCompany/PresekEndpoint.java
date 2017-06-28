package company.bankToCompany;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import company.bean.Presek;

@Endpoint
public class PresekEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/presek";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "presek")
	@ResponsePayload
	public Presek handleRequest(@RequestPayload Presek request) {		
		//TODO Implementirati logiku kada kompanija primi presjek
		System.out.println("PRESEK");
		return null;
	}
}
