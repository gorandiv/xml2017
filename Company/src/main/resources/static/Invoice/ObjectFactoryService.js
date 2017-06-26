invoiceModule.service('objectFactoryService', function() {
	
	this.Data = function() {
		this.invoiceItem = null;
		this.amount = 1;
		this.rebate = 0;
	}
	
	this.InvoiceHeader = function() {
		this.idPoruke = "";
		this.brojRacuna = "";
		this.nazivDobavljaca = null;
		this.adresaDobavljaca = null;
		this.pibDobavljaca = null;
		this.nazivKupca = null;
		this.adresaKupca = null;
		this.pibKupca = null;
		this.datumRacuna = "";
		this.vrednostRobe = 0;
		this.vrednostUsluga = 0;
		this.ukupnoRobaIUsluge = 0;
		this.ukupanRabat = 0;
		this.ukupanPorez = 0;
		this.oznakaValute = "din";
		this.iznosZaUplatu = 0;
		this.uplataNaRacun = null;
		this.datumValute = "";
	}
	
	this.Invoice = function(invoiceHeader) {
		this.zaglavljeFakture = invoiceHeader;
		this.stavkaFakture = [];
		this.poslata = false;
	}
	
	this.InvoiceItem = function(ordinal) {
		this.jelProizvod = false;  // first 3 - strip
		this.proizvodIliUsluga = null    
		this.show = false;				
		this.redniBroj = ordinal;
		this.nazivRobeIliUsluge = "";
		this.kolicina = 1;
		this.jedinicaMere = "";
		this.jedinicnaCena = 0;
		this.vrednost = 0;
		this.procenatRabata = 0;
		this.iznosRabata = 0;
		this.umanjenoZaRabat = 0;
		this.ukupanPorez = 0;
	}
});
