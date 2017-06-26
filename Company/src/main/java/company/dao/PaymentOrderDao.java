package company.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import company.bean.NalogZaPrenos;

public interface PaymentOrderDao extends Repository<NalogZaPrenos, Integer> {

	NalogZaPrenos findById(Integer paymentOrderId);
	
	NalogZaPrenos save(NalogZaPrenos paymentOrder);
	
	@Modifying
	@Transactional
	List<NalogZaPrenos> removeById(Integer paymentOrderId);
	
	List<NalogZaPrenos> findByDuznikAndPoslatTrue(String companyName);
	
	List<NalogZaPrenos> findByDuznikAndPoslatFalse(String companyName);
	
	@Modifying
	@Transactional
	@Query("update NalogZaPrenos nzp set nzp.poslat = true where nzp.id = :paymentOrderId")
	void setPoslatById(@Param("paymentOrderId")  Integer paymentOrderId);


	
	

}
