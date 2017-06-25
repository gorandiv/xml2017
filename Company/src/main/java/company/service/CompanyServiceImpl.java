package company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.Firma;
import company.dao.CompanyDao;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	
	@Value("${companyId}")
	private String companyId;

	@Override
	public List<Firma> getCompanies() {
		List<Firma> companies = companyDao.findAll();
		
		for(Firma company : companies) {
			if(company.getId().equals(Integer.parseInt(companyId))) {
				companies.remove(company);
				break;
			}
		}
		
		return companies;
	}

	@Override
	public Firma getThisCompany() {
		return companyDao.findById(Integer.parseInt(companyId));
	}

}
