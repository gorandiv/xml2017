package bank.bankToCentral;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.bankxml.bankxml.mt102.Mt102;
import com.example.bankxml.bankxml.mt102.NalogZaMT102;

@Component
public class M102Repository {

	private HashMap<String, Mt102> mapa=new HashMap<>();
	

	public HashMap<String, Mt102> getMapa() {
		return mapa;
	}

	public void setMapa(HashMap<String, Mt102> mapa) {
		this.mapa = mapa;
	}
	
	public Mt102 putInMap(NalogZaMT102 nalog){
		if(mapa.containsKey(nalog.getPrimalacPoverilac())){
			mapa.get(nalog.getPrimalacPoverilac()).getNalogZaMT102().add(nalog);
			if(mapa.get(nalog.getPrimalacPoverilac()).getNalogZaMT102().size()==2){
				Mt102 x=mapa.get(nalog.getPrimalacPoverilac());
				mapa.remove(nalog.getPrimalacPoverilac());
				return x;
			}
		}else{
			Mt102 y=new Mt102();
			y.setSwiftKodBankeDuznika("bankaC");
			y.setSWIFTKodBankePoverioca(nalog.getPrimalacPoverilac());
			mapa.put(nalog.getPrimalacPoverilac(), y);
			y.getNalogZaMT102().add(nalog);
		}
		
		return null;
	}
	
}
