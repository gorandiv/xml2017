package company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.bean.Firma;
import company.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@GetMapping(path = "/companies", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Firma> getCompanies() {
		return companyService.getCompanies();

	}
	
	@GetMapping(path = "/this-company", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Firma getThisCompany() {
		return companyService.getThisCompany();
	}
	
}
