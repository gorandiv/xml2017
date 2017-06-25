package company.service;

import java.util.List;

import company.bean.Firma;

public interface CompanyService {

	List<Firma> getCompanies();

	Firma getThisCompany();

}
