package bank.companyToBank;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.bankxml.bankxml.mt102.Mt102;
import com.example.bankxml.bankxml.mt102.NalogZaMT102;
import com.strukturartgsnaloga.StrukturaRtgsNaloga;

import bank.bankToCentral.Function;
import bank.bankToCentral.M102Repository;
import bank.bankToCentral.ReservedRepository;
import bank.bean.Banka;
import bank.bean.Firma;
import bank.bean.NalogZaPrenos;
import bank.bean.RacunFirme;
import bank.bean.Reservation;
import bank.dao.BankDAO;
import bank.dao.CompanyDao;
import bank.dao.RacuniDAO;

@Endpoint
public class NalogEndpoint {

	private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/nalogZaPrenos";

	@Value("${bankId}")
	private String bankId;
	
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private CompanyDao companyDAO;
	@Autowired
	private RacuniDAO racuniDAO;
	
	@Autowired
	private M102Repository mt102Repository;
	
	
	@Autowired
	private ReservedRepository reservedRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nalog_za_prenos")
	@ResponsePayload
	public NalogZaPrenos handleRequest(@RequestPayload NalogZaPrenos request) {		
		Banka thisBank = bankDAO.findById(Integer.parseInt(bankId));
		try{
			
			String racunDuznika = request.getPodaciOUplati().getRacunDuznika().getBrojRacuna();
			String racunPoverioca = request.getPodaciOUplati().getRacunPoverioca().getBrojRacuna();
			RacunFirme racunPoverioc = null;
			RacunFirme racunDuznik = null;
			for(RacunFirme racun : thisBank.getRacuniFirme()){
				if(racun.getBrojRacuna().equals(racunPoverioca)){
					racunPoverioc = racun;
				}else if(racun.getBrojRacuna().equals(racunDuznika)){
					racunDuznik = racun;
				}
			}
			
			
			if (racunPoverioc != null){
				System.out.println("----------------------Firme se nalaze u istoj banci.-----------------------------");
				
				System.out.println("----------------------Skidam sa racuna.------------------------------------------");
				racunDuznik.setStanjeRacuna(racunDuznik.getStanjeRacuna().subtract(request.getPodaciOUplati().getIznos()));
				racuniDAO.save(racunDuznik);
				System.out.println("----------------------Dodajem na racun.------------------------------------------");
				racunPoverioc.setStanjeRacuna(racunPoverioc.getStanjeRacuna().add(request.getPodaciOUplati().getIznos()));
				racuniDAO.save(racunPoverioc);
			}else sendRequestToCentralBank(thisBank, racunPoverioc.getFirma().getBanka(),request,racunDuznik,racunPoverioc);
		}catch(Exception e){
			System.out.println("Nepostojeca firma!");
		}	
		return null;
	}

	private NalogZaPrenos sendRequestToCentralBank(Banka mojaBanka, Banka bankaPoverioca,NalogZaPrenos nalogZaPrenos,RacunFirme racunDuznika,RacunFirme racunPoverioca){
		//LUKA TODO
		if(nalogZaPrenos.getPodaciOUplati().getIznos().longValue()>250000 || nalogZaPrenos.getPodaciOUplati().isHitno()){
			Function f=new Function();
			StrukturaRtgsNaloga src=new StrukturaRtgsNaloga();
			Random r=new Random();
			
			src.setIdPoruke(Integer.toString(r.nextInt(32141)));
			src.setSwiftKodBankeDuznika(mojaBanka.getSwiftKod());
			src.setSwiftKodBankePoverioca(bankaPoverioca.getSwiftKod());
			src.setDuznikNalogodavac(nalogZaPrenos.getDuznik());
			src.setPrimalacPoverilac(nalogZaPrenos.getPoverilac());
			src.setIznos(nalogZaPrenos.getPodaciOUplati().getIznos());
			src.setSvrhaPlacanja(nalogZaPrenos.getSvrhaPlacanja());
			
			src.setRacunDuznika(racunDuznika.getId().toString());
			src.setRacunPoverioca(racunPoverioca.getId().toString());
			
			Reservation reser=new Reservation(src.getIznos(),racunDuznika);
			reservedRepository.putIn(src.getIdPoruke(), reser);
			
			f.sendNalog(src);
		}else{
			Function f1=new Function();
			
			if(mt102Repository.getMapa().containsKey(nalogZaPrenos.getPoverilac())){
				
			}else{
				Mt102 x=new Mt102();
				x.setSwiftKodBankeDuznika(mojaBanka.getSwiftKod());
				x.setSWIFTKodBankePoverioca(bankaPoverioca.getSwiftKod());
				
				Random r=new Random();
				x.setIdPoruke(Integer.toString(r.nextInt(32141)));
				
				
				
				mt102Repository.getMapa().put(nalogZaPrenos.getPoverilac(), x);
			}
			
			NalogZaMT102 nn=new NalogZaMT102();
			nn.setPrimalacPoverilac(nalogZaPrenos.getPoverilac());
			nn.setDuznikNalogodavac(nalogZaPrenos.getDuznik());
			nn.setSvrhaPlacanja(nalogZaPrenos.getSvrhaPlacanja());		
			nn.setRacunDuznika(racunDuznika.getId().toString());
			nn.setRacunPoverioca(racunPoverioca.getId().toString());
			
			Reservation reser=new Reservation(mt102Repository.getMapa().get(
					nalogZaPrenos.getPoverilac()).getUkupanIznos(),racunDuznika);
			reservedRepository.putIn(mt102Repository.getMapa().get(
					nalogZaPrenos.getPoverilac()).getIdPoruke(), reser);
			
			Mt102 z=mt102Repository.putInMap(nn);
			if(z!=null){
				f1.sendNalog1(z);
			}
			
			
		}
		return null;
	}
	
	
}
