package company.service;

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
	public Presek getOverviewSectionRequestToBank(ZahtevZaIzvod overviewSectionRequest) {
		
		
		Presek presek = sendRequest(overviewSectionRequest);
		
		System.out.println(presek);
		System.out.println(presek.getZaglavlje().getBrojRacuna());
		
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
