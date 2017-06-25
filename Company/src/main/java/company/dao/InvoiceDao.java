package company.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import company.bean.Faktura;

public interface InvoiceDao extends Repository<Faktura, Integer> {
	
		public Faktura findById(Integer id);
		
		public List<Faktura> findByZaglavljeFakturePibDobavljaca(String pib);
		
		public List<Faktura> findByZaglavljeFakturePibKupca(String pib);

}
