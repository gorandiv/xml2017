package company;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import company.bean.NalogZaPrenos;

public class Function {

	
	public static void main(String[] args){
		Function f=new Function();
		NalogZaPrenos zahtev = new NalogZaPrenos();
		f.sendZahtev(zahtev);
	}
	
	private void sendZahtev(NalogZaPrenos zahtev){
	    System.out.println("-----------------------------Poslat Nalog----------------------");
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("company.bean",
        		"http://localhost:8090/ws/nalog_za_prenos");
       webServiceTemplate.marshalSendAndReceive(zahtev);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
  
	}
	
	public WebServiceTemplate configWebServiceTemplate(String contextPath, String url){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(contextPath);

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
        webServiceTemplate.setDefaultUri(url);

        return webServiceTemplate;
    }
	
}

