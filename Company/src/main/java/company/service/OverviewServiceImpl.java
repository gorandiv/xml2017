package company.service;

import org.springframework.stereotype.Service;

import company.bean.Presek;
import company.bean.ZahtevZaIzvod;

@Service
public class OverviewServiceImpl implements OverviewService {

	@Override
	public Presek getOverviewSectionRequestToBank(ZahtevZaIzvod overviewSectionRequest) {
		
		
		System.out.println("JA SAM MILENKO I PISEM KOD OVDE");
		
		return null;
	}

}
