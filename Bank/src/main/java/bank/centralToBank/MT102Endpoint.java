package bank.centralToBank;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.bankxml.bankxml.mt102.Mt102;
@Endpoint
public class MT102Endpoint {

	private static final String NAMESPACE_URI = "http://mt102.BankXml.bankXml.example.com";

	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt102")
	@ResponsePayload
	public Mt102 getCountry(@RequestPayload Mt102 request) {
		System.out.println("doso");
		return request;
	}
	
}
