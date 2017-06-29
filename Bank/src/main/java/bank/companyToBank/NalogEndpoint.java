package bank.companyToBank;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
import bank.bean.NalogZaPrenos;
import bank.bean.Presek;
import bank.bean.Presek.Stavka;
import bank.bean.RacunFirme;
import bank.bean.Reservation;
import bank.dao.BankDAO;
import bank.dao.CompanyDao;
import bank.dao.OverviewSectionDao;
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
	private OverviewSectionDao overviewSectionDao;
	
	@Autowired
	private M102Repository mt102Repository;
	
	
	@Autowired
	private ReservedRepository reservedRepository;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "nalog_za_prenos")
	@ResponsePayload
	public NalogZaPrenos handleRequest(@RequestPayload NalogZaPrenos request) {		
			//List<RacunFirme> rr = racuniDAO.findAll();
			//String racunDuznika = request.getPodaciOUplati().getRacunDuznika().getBrojRacuna();
			//String racunPoverioca = request.getPodaciOUplati().getRacunPoverioca().getBrojRacuna();
			
			RacunFirme racunDuznik = racuniDAO.findByBrojRacuna(request.getPodaciOUplati().getRacunDuznika().getBrojRacuna());
			RacunFirme racunPoverioc = racuniDAO.findByBrojRacuna(request.getPodaciOUplati().getRacunPoverioca().getBrojRacuna());
			
			if(racunDuznik.getFirma().getBanka().getId().equals(racunPoverioc.getFirma().getBanka().getId())){
				System.out.println("----------------------Firme se nalaze u istoj banci.-----------------------------");
				System.out.println("----------------------Skidam sa racuna.------------------------------------------");
				BigDecimal prethodnoStanjeDuznik = racunDuznik.getStanjeRacuna();
				racunDuznik.setStanjeRacuna(racunDuznik.getStanjeRacuna().subtract(request.getPodaciOUplati().getIznos()));
				updateOverviewSections(prethodnoStanjeDuznik, racunDuznik, request);
				racuniDAO.save(racunDuznik);
				
				System.out.println("----------------------Dodajem na racun.------------------------------------------");
				BigDecimal prethodnoStanjePoverioc = racunPoverioc.getStanjeRacuna();
				racunPoverioc.setStanjeRacuna(racunPoverioc.getStanjeRacuna().add(request.getPodaciOUplati().getIznos()));
				updateOverviewSections(prethodnoStanjePoverioc, racunPoverioc, request);
				
				racuniDAO.save(racunPoverioc);
				
				
				
			}else {
				BigDecimal prethodnoStanjeDuznik = racunDuznik.getStanjeRacuna();
				updateOverviewSections(prethodnoStanjeDuznik, racunDuznik, request);
				sendRequestToCentralBank(racunDuznik.getFirma().getBanka(), racunPoverioc.getFirma().getBanka(),request,racunDuznik,racunPoverioc);
			}
			/*
			for(RacunFirme racun : rr){
				if(racun.getBrojRacuna().equals(racunDuznika))
					racunDuznik=racun;
				else if(racun.getBrojRacuna().equals(racunPoverioca))
					racunPoverioc=racun;
			for(RacunFirme racun1 : thisBank.getRacuniFirme()){
				if(racun1.getBrojRacuna().equals(racunPoverioca)){
					racunPoverioc = racun1;
				}else if(racun1.getBrojRacuna().equals(racunDuznika)){
					racunDuznik = racun;
				}
			}
			}*/
			
			return null;
	}

	private void updateOverviewSections(BigDecimal prethodnoStanje, RacunFirme racun, NalogZaPrenos request) {
		
	    Presek overview = overviewSectionDao.findByZaglavljeDatumNalogaAndBrojRacuna(request.getPodaciOUplati().getDatumNaloga(), racun.getBrojRacuna());
		
	    if(overview == null || overview.getStavka().size() == 3) {
	    	Presek o = new Presek();
	    	Presek.Zaglavlje header = new Presek.Zaglavlje();
	    	Presek.Stavka stavka = new Presek.Stavka();
	    	
	    	header.setBrojRacuna(racun.getBrojRacuna());
	    	header.setDatumNaloga(request.getPodaciOUplati().getDatumNaloga());
	    	
	    	if(overview == null)
	    		header.setBrojPreseka(new BigInteger("1"));
	    	else {
	    		header.setBrojPreseka(overview.getZaglavlje().getBrojPreseka().add(new BigInteger("1")));
	    	}
	    	header.setPrethodnoStanje(prethodnoStanje);
	    	header.setNovoStanje(racun.getStanjeRacuna());
	    	
	    	if(racun.getStanjeRacuna().compareTo(prethodnoStanje) > 0){
	    		header.setUkupnoUKorist(racun.getStanjeRacuna().subtract(prethodnoStanje));
	    		header.setUkupnoNaTeret(new BigDecimal("0.0"));
	    		header.setBrojPromenaUKorist(new BigInteger("1"));
	    		header.setBrojPromenaNaTeret(new BigInteger("0"));
	    		stavka.setSmer("+");
	    	}else{
	    		header.setUkupnoNaTeret(racun.getStanjeRacuna().subtract(prethodnoStanje));
	    		header.setUkupnoUKorist(new BigDecimal("0.0"));
	    		header.setBrojPromenaUKorist(new BigInteger("0"));
	    		header.setBrojPromenaNaTeret(new BigInteger("1"));
	    		stavka.setSmer("-");
	    	}		
	    	
	    	o.setZaglavlje(header);
	    	stavka.setDuznik(request.getDuznik());
	    	stavka.setSvrhaPlacanja(request.getSvrhaPlacanja());
	    	stavka.setPoverilac(request.getPoverilac());
	    	stavka.setDatumNaloga(request.getPodaciOUplati().getDatumNaloga());
	    	stavka.setDatumValute(request.getPodaciOUplati().getDatumValute());
	    	stavka.setRacunDuznika(request.getPodaciOUplati().getRacunDuznika());
	    	stavka.setRacunPoverioca(request.getPodaciOUplati().getRacunPoverioca());
	    	stavka.setIznos(request.getPodaciOUplati().getIznos());
	    	
	    	List<Stavka> stavke = new ArrayList<Stavka>();
	    	stavke.add(stavka);
	    	o.setStavka(stavke);
	    	
	    	overviewSectionDao.save(o);
	    	
	    }
	    else {
	    	
	    	Presek.Stavka stavka = new Presek.Stavka();
	    	
	    	if(racun.getStanjeRacuna().compareTo(prethodnoStanje) > 0){
	    		overview.getZaglavlje().setUkupnoUKorist(overview.getZaglavlje().getUkupnoUKorist().add(racun.getStanjeRacuna().subtract(prethodnoStanje)));
	    		overview.getZaglavlje().setBrojPromenaUKorist(overview.getZaglavlje().getBrojPromenaUKorist().add(new BigInteger("1")));
	    		stavka.setSmer("+");
	    	}else{
	    		overview.getZaglavlje().setUkupnoNaTeret(overview.getZaglavlje().getUkupnoNaTeret().add(racun.getStanjeRacuna().subtract(prethodnoStanje)));
	    		overview.getZaglavlje().setBrojPromenaNaTeret(overview.getZaglavlje().getBrojPromenaNaTeret().add(new BigInteger("1")));
	    		stavka.setSmer("-");
	    	}		
	    	
	    	stavka.setDuznik(request.getDuznik());
	    	stavka.setSvrhaPlacanja(request.getSvrhaPlacanja());
	    	stavka.setPoverilac(request.getPoverilac());
	    	stavka.setDatumNaloga(request.getPodaciOUplati().getDatumNaloga());
	    	stavka.setDatumValute(request.getPodaciOUplati().getDatumValute());
	    	stavka.setRacunDuznika(request.getPodaciOUplati().getRacunDuznika());
	    	stavka.setRacunPoverioca(request.getPodaciOUplati().getRacunPoverioca());
	    	stavka.setIznos(request.getPodaciOUplati().getIznos());
	    	
	    	overview.getStavka().add(stavka);
	    	overview.getZaglavlje().setNovoStanje(racun.getStanjeRacuna());
	    	
	    	overviewSectionDao.save(overview);
		}
		
	}

	private NalogZaPrenos sendRequestToCentralBank(Banka mojaBanka, Banka bankaPoverioca,NalogZaPrenos nalogZaPrenos,RacunFirme racunDuznika,RacunFirme racunPoverioca){
		//LUKA TODO
		
		if(nalogZaPrenos.getPodaciOUplati().getIznos().longValue()>250000 || nalogZaPrenos.getPodaciOUplati().isHitno()){
			Function f=new Function();
			StrukturaRtgsNaloga src=new StrukturaRtgsNaloga();
			Random r=new Random();
			
			System.out.println(nalogZaPrenos.getDuznik());
			System.out.println(nalogZaPrenos.getPoverilac());
			
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
			System.out.println("udje ovde");
			if(mt102Repository.getMapa().containsKey(nalogZaPrenos.getPoverilac())){
				
			}else{
				Mt102 x=new Mt102();
				x.setSwiftKodBankeDuznika(mojaBanka.getSwiftKod());
				x.setSWIFTKodBankePoverioca(bankaPoverioca.getSwiftKod());
				x.setUkupanIznos(new BigDecimal(0));
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
			nn.setIznos(nalogZaPrenos.getPodaciOUplati().getIznos());
			Reservation reser=new Reservation(mt102Repository.getMapa().get(
					nalogZaPrenos.getPoverilac()).getUkupanIznos(),racunDuznika);
			reservedRepository.putIn(mt102Repository.getMapa().get(
					nalogZaPrenos.getPoverilac()).getIdPoruke(), reser);
			
			Mt102 z=mt102Repository.putInMap(nn);
			if(z!=null){
				System.out.println("saljem");
				f1.sendNalog1(z);
			}
			
			
		}
		System.out.println("izadje ovde");
		return null;
	}
	
	
}
