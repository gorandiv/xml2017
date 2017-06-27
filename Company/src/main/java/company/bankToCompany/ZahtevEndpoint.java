package company.bankToCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import company.bean.ZahtevZaIzvod;
import company.dao.BankDAO;
import company.dao.CompanyDao;

@Endpoint
public class ZahtevEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/ZahtevZaIzvod";

	
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private CompanyDao companyDAO;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "zahtev_za_izvod")
	@ResponsePayload
	public ZahtevZaIzvod handleRequest(@RequestPayload ZahtevZaIzvod request) {		
		
		System.out.println("USAO SAM U ZAHTEV ENDPOINT NA KOMPANIJI");
		return null;
	}
	
}
