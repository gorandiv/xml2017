package company;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import company.bean.Banka;
import company.bean.Firma;
import company.bean.RacunFirme;
import company.dao.BankDAO;
import company.dao.BillDao;
import company.dao.CompanyDao;



@Component
public class Inicialization {

	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private CompanyDao companyDAO;
	@Autowired
	private BillDao racuniDAO;
	
	
	//@PostConstruct
	public void er(){
		System.out.println("ehej");
		
	    List<Banka> banks=bankDAO.findAll();
	    
	    Banka b=banks.get(0);
	    if(!b.getRacuniFirme().isEmpty())
	    	return;
	    
	    Firma f1=companyDAO.findById(1);    
	    RacunFirme r1=new RacunFirme();
	    r1.setBrojRacuna("123111117711331122");
	    r1.setFirma(f1);
	    r1.setStanjeRacuna(new BigDecimal(1000.0));
	    b.getRacuniFirme().add(r1);
	    
	   // Firma f1=companyDAO.findById(1);    
	    RacunFirme r2=new RacunFirme();
	    r2.setBrojRacuna("123112115511111122");
	    r2.setFirma(f1);
	    r2.setStanjeRacuna(new BigDecimal(50000.0));
	    b.getRacuniFirme().add(r2);
	    
	    //Firma f1=companyDAO.findById(1);    
	    RacunFirme r3=new RacunFirme();
	    r3.setBrojRacuna("123111112211151122");
	    r3.setFirma(f1);
	    r3.setStanjeRacuna(new BigDecimal(101000.0));
	    b.getRacuniFirme().add(r3);
	    
	    bankDAO.save(b);
	    
	    Banka b1=banks.get(1);
	    Firma f2=companyDAO.findById(2);    
	    RacunFirme r4=new RacunFirme();
	    r4.setBrojRacuna("321222333225522233");
	    r4.setFirma(f2);
	    r4.setStanjeRacuna(new BigDecimal(299000.0));
	    b1.getRacuniFirme().add(r4);
	    bankDAO.save(b1);
	    
	}
	
	
	
}
