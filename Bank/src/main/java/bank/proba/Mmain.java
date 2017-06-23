package bank.proba;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import io.spring.guides.gs_producing_web_service.ObjectFactory;

@Controller
public class Mmain extends WebServiceGatewaySupport{
	
		public void refko(){
			sendNalog(new Country());
		}
	
		public static void main(String[] args){
			Mmain m=new Mmain();
			m.refko();
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

	    public void sendNalog(Country nalog){
	        System.out.println("-----------------------------Poslat Nalog----------------------");
	        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("io.spring.guides.gs_producing_web_service",
	        		"http://localhost:9000/ws/countries");
	        Country nalogResponse = (Country) webServiceTemplate.marshalSendAndReceive(nalog);
	        System.out.println("-----------------------------Primeljen Nalog--------------------");
	    }

	

}
