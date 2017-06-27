package centralbank.settlement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.bankxml.bankxml.mt102.Mt102;
import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;

import centralbank.bean.Banka;
import centralbank.centralToBank.Function;
import centralbank.dao.BankDAO;

@Endpoint
public class SettlementEndpoint {

	private static final String NAMESPACE_URI = "http://mt102.BankXml.bankXml.example.com";

	@Autowired
	private BankDAO bankDao;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "mt102")
	@ResponsePayload
	public Mt102 getCountry(@RequestPayload Mt102 request) {
		
		Banka b1=bankDao.findBySwiftKod(request.getSwiftKodBankeDuznika());
		Banka b2=bankDao.findBySwiftKod(request.getSWIFTKodBankePoverioca());

		Function f=new Function();
		
		Mt900 mt900=new Mt900();
		mt900.setSwiftBankeDuznika(request.getSwiftKodBankeDuznika());
		mt900.setIdPorukeNaloga(request.getIdPoruke());
		mt900.setIznos(request.getUkupanIznos());
		
		Mt910 mt910=new Mt910();
		mt910.setSwiftKodBankePoverioca(request.getSWIFTKodBankePoverioca());
		mt910.setIdPorukeNaloga(request.getIdPoruke());
		mt910.setIznos(request.getUkupanIznos());
		
		f.sendNalog3(request,b2.getAdresa());
		f.sendNalog1(mt900, b1.getAdresa());
		f.sendNalog2(mt910,b2.getAdresa());
		
		
		return request;
	}
	
}
