package company.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import company.bean.Firma;

public interface CompanyDao extends Repository<Firma, Integer> {
	
	public Firma findById(Integer id);
	
	public List<Firma> findAll();


}
