package company.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import company.bean.RacunFirme;




public interface BillDao extends Repository<RacunFirme, Integer> {

	RacunFirme findById(Integer racunId);
	List<RacunFirme> findByFirma_Id(Integer firmaId);
	RacunFirme save(RacunFirme racun);
	
	
}
