package company.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import company.bean.Faktura;

public interface InvoiceDao extends Repository<Faktura, Integer> {

	public Faktura findById(Integer id);

	public Faktura save(Faktura invoice);

	public List<Faktura> findByZaglavljeFakturePibDobavljacaAndPoslataFalse(String companyPib);

	public List<Faktura> findByZaglavljeFakturePibDobavljacaAndPoslataTrue(String companyPib);

	public List<Faktura> findByZaglavljeFakturePibKupcaAndPoslataTrue(String companyPib);

	@Modifying
	@Transactional
	public List<Faktura> removeById(Integer invoiceId);

	@Modifying
	@Transactional
	@Query("update Faktura f set f.poslata = true where f.id = :invoiceId")
	public void setPoslataById(@Param("invoiceId") Integer invoiceId);

}
