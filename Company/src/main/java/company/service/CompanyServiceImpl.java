package company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import company.bean.Firma;
import company.bean.RacunFirme;
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

		for (Firma company : companies) {
			if (company.getId().equals(Integer.parseInt(companyId))) {
				companies.remove(company);
				break;
			}
		}

		for (Firma company : companies) {
			if (company.getId().equals(Integer.parseInt(companyId))) {
				company.getBanka().setRacuniFirme(null);
			}
		}

		return companies;
	}

	@Override
	public Firma getThisCompany() {

		Firma company = companyDao.findById(Integer.parseInt(companyId));

		List<RacunFirme> thisCompanyBills = new ArrayList<RacunFirme>();
		for (RacunFirme bill : thisCompanyBills) {
			if (bill.getFirma().getId().equals(Integer.parseInt(companyId))) {
				thisCompanyBills.add(bill);
			}
		}

		company.getBanka().setRacuniFirme(thisCompanyBills);

		return company;
	}

}
