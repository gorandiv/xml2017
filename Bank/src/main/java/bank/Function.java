package bank;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import bank.bean.ZahtevZaIzvod;

public class Function {

	
	public static void main(String[] args){
		Function f=new Function();
		ZahtevZaIzvod zahtev = new ZahtevZaIzvod();
		f.sendZahtev(zahtev);
	}
	
	private void sendZahtev(ZahtevZaIzvod zahtev){
	    System.out.println("-----------------------------Poslat Nalog----------------------");
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("bank.bean",
        		"http://localhost:8100/Firma/ws/zahtev_za_izvod");
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

