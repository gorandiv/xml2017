package company.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.Repository;

import company.bean.Faktura;

public interface InvoiceDao extends Repository<Faktura, Integer> {

	Faktura findById(Integer id);

	Faktura save(Faktura invoice);

	List<Faktura> findByZaglavljeFakturePibDobavljacaAndPoslataFalse(String companyPib);

	List<Faktura> findByZaglavljeFakturePibDobavljacaAndPoslataTrue(String companyPib);

	List<Faktura> findByZaglavljeFakturePibKupcaAndPoslataTrue(String companyPib);

	@Modifying
	@Transactional
	List<Faktura> removeById(Integer invoiceId);

	Faktura findByZaglavljeFaktureBrojRacuna(String brojRacuna);

}
