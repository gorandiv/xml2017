package bank.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import bank.bean.Firma;

public interface CompanyDao extends Repository<Firma, Integer> {
	
	Firma findById(Integer id);
	
	List<Firma> findAll();
	
	Firma findByIme(String ime);


}
