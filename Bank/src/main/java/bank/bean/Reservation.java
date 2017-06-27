package bank.bean;

import java.math.BigDecimal;

public class Reservation {
	
	private BigDecimal amount;
	private RacunFirme racunFirme;
	
	
	
	public Reservation(BigDecimal amount, RacunFirme racunFirme) {
		super();
		this.amount = amount;
		this.racunFirme = racunFirme;
	}
	
	
	public RacunFirme getRacunFirme() {
		return racunFirme;
	}
	public void setRacunFirme(RacunFirme racunFirme) {
		this.racunFirme = racunFirme;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
