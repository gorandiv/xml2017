package centralbank.rtgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import centralbank.bean.Banka;
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
		
		Banka b1=bankDao.findBySwiftKod(request.getSwiftKodBankeDuznika());
		Banka b2=bankDao.findBySwiftKod(request.getSwiftKodBankePoverioca());

		Function f=new Function();
		
		f.sendNalog(new StrukturaRtgsNaloga(),b2.getAdresa());
		f.sendNalog1(new Mt900(), b1.getAdresa());
		f.sendNalog2(new Mt910(),b2.getAdresa());
		
		System.out.println("jebes mi mater");
		return request;
	}
	
}
