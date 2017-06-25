package bank.bankToCentral;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import bank.proba.Mmain;


@Controller
public class Function {

	public static void main(String[] args){
		Function m=new Function();
		StrukturaRtgsNaloga src=new StrukturaRtgsNaloga();
		src.setSwiftKodBankeDuznika("bankaC");
		src.setSwiftKodBankePoverioca("bankaD");
		m.sendNalog(src);
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

    public void sendNalog(StrukturaRtgsNaloga nalog){
        System.out.println("-----------------------------Poslat Nalog----------------------");
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.strukturartgsnaloga",
        		"http://localhost:8080/ws/strukturaRtgsNaloga");
        StrukturaRtgsNaloga nalogResponse = (StrukturaRtgsNaloga) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }
	
}
