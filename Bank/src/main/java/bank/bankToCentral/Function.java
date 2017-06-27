package bank.bankToCentral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.bankxml.bankxml.mt102.Mt102;
import com.example.bankxml.bankxml.mt102.NalogZaMT102;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import bank.proba.Mmain;


@Controller
public class Function {

	//@Autowired
	private M102Repository mt102Repository;
	
	public static void main(String[] args){
		Function m=new Function();
		m.mt102Repository=new M102Repository();
		/*
		StrukturaRtgsNaloga src=new StrukturaRtgsNaloga();
		src.setSwiftKodBankeDuznika("bankaC");
		src.setSwiftKodBankePoverioca("bankaD");
		m.sendNalog(src);*/
		
		m.helper();
		
		
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
	
    
    public void helper(){
    	
    	
    	NalogZaMT102 x=new NalogZaMT102();
		x.setPrimalacPoverilac("bankaD");
		NalogZaMT102 y=new NalogZaMT102();
		y.setPrimalacPoverilac("bankaD");
		/*
		Mt102 z=mt102Repository.putInMap(x);
		if(z!=null){
			
			sendNalog1(z);
		}
		z=mt102Repository.putInMap(y);
		if(z!=null){
		
			sendNalog1(z);
		}*/
		
    }
    
    public void sendNalog1(Mt102 nalog){
    	
        System.out.println("-----------------------------Poslat Nalog----------------------");
        WebServiceTemplate webServiceTemplate = configWebServiceTemplate("com.example.bankxml.bankxml.mt102",
        		"http://localhost:8080/ws/strukturaRtgsNaloga");
        Mt102 nalogResponse = (Mt102) webServiceTemplate.marshalSendAndReceive(nalog);
        System.out.println("-----------------------------Primeljen Nalog--------------------");
    }
    
}
