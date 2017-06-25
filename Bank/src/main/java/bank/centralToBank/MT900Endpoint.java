package bank.centralToBank;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;
@Endpoint
public class MT900Endpoint {
	
	
	private static final String NAMESPACE_URI = "http://strukturaRtgsNaloga.com";


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt900")
	@ResponsePayload
	public Mt900 getCountry(@RequestPayload Mt900 request) {
		Mt900 c=new Mt900();
		System.out.println("mt900");
		return c;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt910")
	@ResponsePayload
	public Mt910 getCountry(@RequestPayload Mt910 request) {
		Mt910 c=new Mt910();
		System.out.println("mt910");
		return c;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "strukturaRtgsNaloga")
	@ResponsePayload
	public StrukturaRtgsNaloga getCountry(@RequestPayload StrukturaRtgsNaloga request) {
		StrukturaRtgsNaloga c=new StrukturaRtgsNaloga();
		System.out.println("jebes mi mater");
		return c;
	}

}
