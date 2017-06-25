package company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.ProizvodIliUsluga;
import company.dao.ProductOrServiceDao;

@Service
public class ProductOrServiceServiceImpl implements ProductOrServiceService {
	
	@Autowired
	private ProductOrServiceDao productOrServiceDao;
	
	@Value("${companyId}")
	private String companyId;

	@Override
	public List<ProizvodIliUsluga> getCompanyProductsOrServices() {
		return productOrServiceDao.findByFirmaId(Integer.parseInt(companyId));
	}

}
