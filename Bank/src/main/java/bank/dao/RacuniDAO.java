package bank.dao;

import org.springframework.data.repository.Repository;

import bank.bean.RacunFirme;

public interface RacuniDAO extends Repository<RacunFirme, Integer> {

	RacunFirme findById(Integer racunId);
	RacunFirme findByFirma_Id(Integer firmaId);
	RacunFirme save(RacunFirme racun);
	
	
}
