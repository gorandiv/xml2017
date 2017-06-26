package company.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import company.bean.ProizvodIliUsluga;

public interface ProductOrServiceDao extends Repository<ProizvodIliUsluga, Integer> {
	
	List<ProizvodIliUsluga> findByFirmaId(Integer id);
	
}
