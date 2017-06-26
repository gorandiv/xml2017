package company.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

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

	@Modifying
	@Transactional
	@Query("update Faktura f set f.poslata = true where f.id = :invoiceId")
	void setPoslataById(@Param("invoiceId") Integer invoiceId);

}
