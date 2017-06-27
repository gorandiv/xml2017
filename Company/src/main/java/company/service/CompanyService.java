package company.service;

import java.util.List;

import company.bean.Firma;
import company.bean.RacunFirme;

public interface CompanyService {

	List<Firma> getCompanies();

	Firma getThisCompany();

	List<RacunFirme> getThisCompanyBills();

}
