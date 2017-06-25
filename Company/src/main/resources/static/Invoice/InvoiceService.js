invoiceModule.service('invoiceService', ['$http', function($http) {
	
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
	
	this.setInvoiceItemValues = function(invoiceItem, check) {
		invoice.show = true;
		if(check) {
			invoiceItem.nazivRobeIliUsluge = invoiceItem.proizvodIliUsluga.ime;
			invoiceItem.jedinicaMere = invoiceItem.proizvodIliUsluga.jedinicaMere;
			invoiceItem.jedinicnaCena = invoiceItem.proizvodIliUsluga.jedinicnaCena;
			invoiceItem.ukupanPorez = invoiceItem.proizvodIliUsluga.porez;
			invoiceItem.vrednost = invoiceItem.jedinicnaCena;
			invoiceItem.umanjenoZaRabat = invoiceItem.vrednost;
			invoiceItem.procenatRabata = 0;
			invoiceItem.iznosRabata = 0;
			invoiceItem.kolicina = 1;
		} else {
			invoiceItem.vrednost = invoiceItem.jedinicnaCena * invoiceItem.kolicina;
			invoiceItem.iznosRabata = invoiceItem.vrednost * (invoiceItem.procenatRabata * 0.01);
			invoiceItem.umanjenoZaRabat = invoiceItem.vrednost - invoiceItem.vrednost * (invoiceItem.procenatRabata * 0.01);
		}
	}
	
	this.sendInvoice = function() {
		
	}
	
}]);