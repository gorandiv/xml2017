package centralbank.rtgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import centralbank.bean.Bank;
import centralbank.centralToBank.Function;
import centralbank.dao.BankDAO;



@Endpoint
public class RTGSEndpoint {

	
	private static final String NAMESPACE_URI = "http://strukturaRtgsNaloga.com";

	@Autowired
	private BankDAO bankDao;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "strukturaRtgsNaloga")
	@ResponsePayload
	public StrukturaRtgsNaloga getCountry(@RequestPayload StrukturaRtgsNaloga request) {
		
		Bank b1=bankDao.findBySwiftCode(request.getSwiftKodBankeDuznika());
		Bank b2=bankDao.findBySwiftCode(request.getSwiftKodBankePoverioca());

		Function f=new Function();
		
		f.sendNalog(new StrukturaRtgsNaloga(),b2.getAddress());
		f.sendNalog1(new Mt900(), b1.getAddress());
		f.sendNalog2(new Mt910(),b2.getAddress());
		
		System.out.println("jebes mi mater");
		return request;
	}
	
}
