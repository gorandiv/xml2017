package centralbank.centralToBank;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.bankxml.bankxml.mt102.Mt102;
import com.strukturartgsnaloga.Mt900;
import com.strukturartgsnaloga.Mt910;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;


@Controller
public class Function {

	public static void main(String[] args){
		Function m=new Function();
		
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

    public void sendNalog(StrukturaRtgsNaloga nalog,String destinationAddress){
        System.out.println("-----------------------------Poslat Nalog----------------------");
        String url = String.format("http://%s/ws/strukturaRtgsNaloga", destinationAddress);
        System.out.println(url);
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.strukturartgsnaloga",
        		url);
        StrukturaRtgsNaloga nalogResponse = (StrukturaRtgsNaloga) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }

    public void sendNalog1(Mt900 nalog,String destinationAddress){
        System.out.println("-----------------------------Poslat Nalog----------------------");
        String url = String.format("http://%s/ws/mt900", destinationAddress);
        System.out.println(url);
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.strukturartgsnaloga",
        		url);
        Mt900 nalogResponse = (Mt900) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }
    
    public void sendNalog2(Mt910 nalog,String destinationAddress){
    	String url = String.format("http://%s/ws/mt910", destinationAddress);
        System.out.println("-----------------------------Poslat Nalog----------------------");
        System.out.println(url);
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.strukturartgsnaloga",
        		url);
        Mt910 nalogResponse = (Mt910) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }
    
    
    public void sendNalog3(Mt102 nalog,String destinationAddress){
    	String url = String.format("http://%s/ws/mt102", destinationAddress);
        System.out.println("-----------------------------Poslat Nalog----------------------");
        System.out.println(url);
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.example.bankxml.bankxml.mt102",
        		url);
        Mt102 nalogResponse = (Mt102) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }
}
