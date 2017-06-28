package company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.bean.Presek;
import company.bean.ZahtevZaIzvod;
import company.service.OverviewService;

@RestController
@RequestMapping("/overview")
public class OverviewController {
	
	@Autowired
	private OverviewService overviewService;
	
	@PostMapping(path = "/overview-section", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Presek createInvoice(@RequestBody ZahtevZaIzvod overviewSectionRequest) {
		return overviewService.getOverviewSectionRequestToBank(overviewSectionRequest);
	}

}
