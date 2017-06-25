package company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.bean.ProizvodIliUsluga;
import company.service.ProductOrServiceService;

@RestController
@RequestMapping("/product-or-service")
public class ProductOrServiceController {
	
	@Autowired
	private ProductOrServiceService productOrServiceService;
	
	
	@GetMapping(path = "/company-products-or-services", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProizvodIliUsluga> getCompanyProductsOrServices() {
		return productOrServiceService.getCompanyProductsOrServices();

	}
	
	
}
