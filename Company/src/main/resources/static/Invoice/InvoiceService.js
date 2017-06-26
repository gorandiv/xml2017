invoiceModule.service('invoiceService', ['$http', function($http) {
	
	this.getCreatedInvoices = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/invoice/created',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.getSentInvoices = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/invoice/sent',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.getReceivedInvoices = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/invoice/received',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.setInvoiceHeaderValues = function(invoice) {
		
		invoice.zaglavljeFakture.vrednostRobe = 0;
		invoice.zaglavljeFakture.vrednostUsluga = 0;
		invoice.zaglavljeFakture.ukupnoRobaIUsluge = 0;
		invoice.zaglavljeFakture.ukupanRabat = 0;
		invoice.zaglavljeFakture.ukupanPorez = 0;
		invoice.zaglavljeFakture.iznosZaUplatu = 0;
		
		for(var i = 0; i < invoice.stavkaFakture.length; i++) {
			var invoiceItem = invoice.stavkaFakture[i];
			
			if(invoiceItem.jelProizvod) {
				invoice.zaglavljeFakture.vrednostRobe += invoiceItem.vrednost;
			}
			else {
				invoice.zaglavljeFakture.vrednostUsluga += invoiceItem.vrednost;
			}
			
			invoice.zaglavljeFakture.ukupnoRobaIUsluge += invoiceItem.vrednost;
			invoice.zaglavljeFakture.ukupanRabat += invoiceItem.iznosRabata;
			invoice.zaglavljeFakture.ukupanPorez += invoiceItem.umanjenoZaRabat * (invoiceItem.ukupanPorez * 0.01);
			invoice.zaglavljeFakture.iznosZaUplatu += invoiceItem.umanjenoZaRabat * (invoiceItem.ukupanPorez * 0.01) + invoiceItem.umanjenoZaRabat;
		}
	}
	
	this.setInvoiceHeaderBuyer = function(invoice, company) {
		if(company == null) {
			invoice.zaglavljeFakture.nazivKupca = "";
			invoice.zaglavljeFakture.adresaKupca = "";
			invoice.zaglavljeFakture.pibKupca = "";
		} else {
			invoice.zaglavljeFakture.nazivKupca = company.ime;
			invoice.zaglavljeFakture.adresaKupca = company.adresa;
			invoice.zaglavljeFakture.pibKupca = company.pib;
		}
	}
	
	this.setInvoiceItemValues = function(invoiceItem, check) {
		if(invoiceItem == null) {
			invoiceItem.show = false;
			return;
		}
		invoiceItem.show = true;
		if(check) {
			invoiceItem.jelProizvod = invoiceItem.proizvodIliUsluga.jelProizvod;
			invoiceItem.nazivRobeIliUsluge = invoiceItem.proizvodIliUsluga.ime;
			invoiceItem.jedinicaMere = invoiceItem.proizvodIliUsluga.jedinicaMere;
			invoiceItem.jedinicnaCena = invoiceItem.proizvodIliUsluga.cena;
			invoiceItem.ukupanPorez = invoiceItem.proizvodIliUsluga.porez;
			invoiceItem.vrednost = invoiceItem.jedinicnaCena;
			invoiceItem.umanjenoZaRabat = invoiceItem.vrednost;
			invoiceItem.procenatRabata = 0;
			invoiceItem.iznosRabata = 0;
			invoiceItem.kolicina = 1;
		} else {
			invoiceItem.vrednost = invoiceItem.jedinicnaCena * invoiceItem.kolicina;
			invoiceItem.iznosRabata = invoiceItem.vrednost * (invoiceItem.procenatRabata * 0.01);
			invoiceItem.umanjenoZaRabat = invoiceItem.vrednost - invoiceItem.iznosRabata;
		}
	}
	
	this.createInvoice = function(invoice, thisCompany) {

		invoice.zaglavljeFakture.nazivDobavljaca = thisCompany.ime;
		invoice.zaglavljeFakture.adresaDobavljaca = thisCompany.adresa;
		invoice.zaglavljeFakture.pibDobavljaca = thisCompany.pib;
		invoice.zaglavljeFakture.uplataNaRacun = thisCompany.brojRacuna;
		
		if(invoice.zaglavljeFakture.nazivDobavljaca == null || invoice.zaglavljeFakture.nazivKupca == null || invoice.stavkaFakture.length == 0){
			toastr.warning("Nepotpuna faktura.");
		}
		
		for(var i = 0; i < invoice.stavkaFakture.length; i++) {
			delete invoice.stavkaFakture[i].isProizvod;
			delete invoice.stavkaFakture[i].proizvodIliUsluga;
			delete invoice.stavkaFakture[i].show;
			delete invoice.stavkaFakture[i].$$hashKey;
		}
		
		
		return $http({
			  method: 'POST',
			  url: '../Firma/invoice/create',
			  data: angular.toJson(invoice),
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.sendInvoice = function(invoice) {
		return $http({
			  method: 'PUT',
			  url: '../Firma/invoice/send/' + invoice.id,
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.removeInvoice = function(invoice) {
		return $http({
			  method: 'PUT',
			  url: '../Firma/invoice/remove/' + invoice.id,
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
}]);