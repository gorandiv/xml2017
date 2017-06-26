paymentOrderModule.service('objectFactoryService', function() {
	
	
	this.PaymentOrder = function(paymentInfo) {
		 this.idPoruke = "";
		 this.duznik = "";
		 this.svrhaPlacanja = "";
		 this.poverilac = "";
		 this.podaciOUplati = paymentInfo;
	}
	
	this.PaymentInfo = function(debtorAccount, creditorAccount) {
	        this.oznakaValute = "rsd";
	        this.iznos = 0;
	        this.racunDuznika = debtorAccount;
	        this.racunPoverioca = creditorAccount;
	        this.datumValute = null;
	        this.hitno = false;
	        this.datumNaloga = null;
	}
	
	this.Account = function() {
		this.brojRacuna = "";
		this.brojModela = 0;
		this.pozivNaBroj = "";
	}
	
	
});