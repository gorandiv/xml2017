package bank.dao;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import bank.bean.Presek;


public interface OverviewSectionDao extends Repository<Presek, Integer> {

	Presek save(Presek overview);
	
	@Transactional
	@Query("from Presek p where p.zaglavlje.datumNaloga = :orderDate and p.zaglavlje.brojRacuna = :billNumber and p.zaglavlje.brojPreseka = (select max(a.zaglavlje.brojPreseka) from Presek a)")
	Presek findByZaglavljeDatumNalogaAndBrojRacuna(@Param("orderDate") String orderDate, @Param("billNumber") String billNumber);
	
	@Transactional
	@Query("from Presek p where p.zaglavlje.datumNaloga = :orderDate and p.zaglavlje.brojPreseka = :sectionOrdinal and p.zaglavlje.brojRacuna = :billNumber")
	Presek findByZaglavljeBrojPresekaAndDatumNalogaAndBrojRacuna(@Param("sectionOrdinal") BigInteger sectionOrdinal,
			@Param("orderDate") String orderDate, @Param("billNumber") String billNumber);

}
