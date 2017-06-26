package bank.companyToBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import bank.bean.NalogZaPrenos;
import bank.dao.BankDAO;

@Endpoint
public class NalogEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/nalogZaPrenos";

	@Value("${bankId}")
	private String bankId;
	
	@Autowired
	private BankDAO bankDAO;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nalog_za_prenos")
	@ResponsePayload
	public NalogZaPrenos handleRequest(@RequestPayload NalogZaPrenos request) {
		
		System.out.println("Primljen nalog u banku");
		System.out.println(request.getDuznik());
		System.out.println(request.getPoverilac());
		//Potrebno
		
		return null;
	}

	
}
