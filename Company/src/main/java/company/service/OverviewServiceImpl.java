package company.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import company.bean.Firma;
import company.bean.Presek;
import company.bean.ZahtevZaIzvod;
import company.dao.CompanyDao;

@Service
public class OverviewServiceImpl implements OverviewService {
	
	@Autowired
	private CompanyDao companyDAO;

	@Value("${companyId}")
	private String companyId;

	@Override
	public Presek getOverviewSectionRequestToBank(String billNumber, String date, String overviewSectionOrdinal) {
		ZahtevZaIzvod overviewSectionRequest = new ZahtevZaIzvod();
		date = date.substring(0, 2) + "/" + date.substring(2,4)+ "/" + date.substring(4,8);
		overviewSectionRequest.setBrojRacuna(billNumber);
		overviewSectionRequest.setDatum(date);
		overviewSectionRequest.setRedniBrojPreseka(new BigInteger(overviewSectionOrdinal));
		
		Presek presek = sendRequest(overviewSectionRequest);
		
		return presek;
		
	}
	
	private Presek sendRequest(ZahtevZaIzvod request){
		 Firma thisCompany = getCompany();
		 System.out.println("-----------------------------Poslat Nalog----------------------");
	     WebServiceTemplate webServiceTemplate = configWebServiceTemplate("company.bean",
	        		"http://"+ thisCompany.getBanka().getAdresa() + "/ws/zahtev_za_izvod");
	     Presek presek = (Presek) webServiceTemplate.marshalSendAndReceive(request);
	     System.out.println("--------------------------Primljen Nalog--------------------");
	     return presek;
	}
	
	
	private WebServiceTemplate configWebServiceTemplate(String contextPath, String url){
      Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
      jaxb2Marshaller.setContextPath(contextPath);

      WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
      webServiceTemplate.setMarshaller(jaxb2Marshaller);
      webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
      webServiceTemplate.setDefaultUri(url);

      return webServiceTemplate;
  }
	
	private Firma getCompany(){
		return companyDAO.findById(Integer.parseInt(companyId));
	}

}
