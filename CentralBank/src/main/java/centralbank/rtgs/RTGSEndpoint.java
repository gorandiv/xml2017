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
import centralbank.bean.Firma;
import centralbank.bean.RacunFirme;
import centralbank.centralToBank.Function;
import centralbank.dao.BankDAO;
import centralbank.dao.CompanyDao;
import centralbank.dao.RacuniDAO;




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
		
		Mt900 mt900=new Mt900();
		mt900.setSwiftBankeDuznika(request.getSwiftKodBankeDuznika());
		mt900.setIdPorukeNaloga(request.getIdPoruke());
		mt900.setIznos(request.getIznos());
		
		Mt910 mt910=new Mt910();
		mt910.setSwiftKodBankePoverioca(request.getSwiftKodBankePoverioca());
		mt910.setIdPorukeNaloga(request.getIdPoruke());
		mt910.setIznos(request.getIznos());
		
		f.sendNalog(request,b2.getAdresa());
		f.sendNalog1(mt900, b1.getAdresa());
		f.sendNalog2(mt910,b2.getAdresa());
		
		
		return request;
	}
	
}
