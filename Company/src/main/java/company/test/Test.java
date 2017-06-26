package company.test;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ws.client.core.WebServiceTemplate;

import company.bean.NalogZaPrenos;
@Controller
public class Test {

	public static void main(String[] args){
		NalogZaPrenos src = new NalogZaPrenos();
		src.setDuznik("Goran");
		//src.setPoverilac("Milenko");
		sendRequest(src);
	}
	
	public static void sendRequest(NalogZaPrenos request){
		 System.out.println("-----------------------------Poslat Nalog----------------------");
	        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("company.bean",
	        		"http://localhost:8090/ws/nalog_za_prenos");
	        NalogZaPrenos nalogResponse = (NalogZaPrenos) webServiceTemplate.marshalSendAndReceive(request);
	        System.out.println("--------------------------Primljen Nalog--------------------");
	}
	
	public static WebServiceTemplate configWebServiceTemplate(String contextPath, String url){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(contextPath);

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller);
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller);
        webServiceTemplate.setDefaultUri(url);

        return webServiceTemplate;
    }
	
}
