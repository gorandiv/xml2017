package company.service;

import company.bean.Presek;
import company.bean.ZahtevZaIzvod;

public interface OverviewService {

	Presek getOverviewSectionRequestToBank(String billNumber, String date, String overviewSectionOrdinal);

}
