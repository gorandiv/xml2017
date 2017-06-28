invoiceModule.service('objectFactoryService', function() {
	
	this.Data = function() {
		this.invoiceItem = null;
		this.amount = 1;
		this.rebate = 0;
	}
	
	this.Invoice = function() {
		this.imeDobavljaca = thisCompany.ime;
		this.adresaDobavljaca = thisCompany.adresa;
		this.pibDobavljaca = thisCompany.pib;
		this.imeKupca = ""
		this.adresaKupca = "";
		this.pibKupca = "";
		this.datumRacuna = "";
		this.vrednostRobe = 0;
		this.vrednostUsluga = 0;
		this.ukupnoRobaIUsluge = 0;
		this.ukupanRabat = 0;
		this.ukupanPorez = 0;
		this.oznakaValute = "";
		this.iznosZaUplatu = 0;
		this.uplataNaRacun = "";
		this.datumValute = null;
		this.stavkaFakture = [];
	}
	
	this.InvoiceItem = function() {
		this.redniBroj = -1;
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
