package company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import company.bean.Presek;
import company.service.OverviewService;

@RestController
@RequestMapping("/overview")
public class OverviewController {
	
	@Autowired
	private OverviewService overviewService;
	
	@PostMapping(path = "/overview-section/{billNumber}/{date}/{overviewSectionOrdinal}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Presek createInvoice(@PathVariable("billNumber")String billNumber, @PathVariable("date")String date, @PathVariable("overviewSectionOrdinal")String overviewSectionOrdinal) {
		return overviewService.getOverviewSectionRequestToBank(billNumber, date, overviewSectionOrdinal);
	}

}
