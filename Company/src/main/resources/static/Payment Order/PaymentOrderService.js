paymentOrderModule.service('paymentOrderService', ['$http', function($http) {
	
	
	this.getCreatedPaymentOrders = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/payment-order/created',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.getSentPaymentOrders = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/payment-order/sent',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	
	this.setPaymentOrderInvoiceValues = function(paymentOrder, invoice) {
		
		paymentOrder.duznik = invoice.zaglavljeFakture.nazivKupca;
		paymentOrder.poverilac = invoice.zaglavljeFakture.nazivDobavljaca;
		paymentOrder.podaciOUplati.iznos = invoice.zaglavljeFakture.iznosZaUplatu;
		paymentOrder.podaciOUplati.racunPoverioca.brojRacuna = invoice.zaglavljeFakture.uplataNaRacun;
	}
	
	
	this.createPaymentOrder = function(paymentOrder) {
		
		return $http({
			  method: 'POST',
			  url: '../Firma/payment-order/create',
			  data: angular.toJson(paymentOrder),
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.sendPaymentOrder = function(paymentOrder) {
		return $http({
			  method: 'PUT',
			  url: '../Firma/payment-order/send/' + paymentOrder.id,
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.removePaymentOrder = function(paymentOrder) {
		
		if(paymentOrder.paymentOrder.podaciOUplati.racunPoverioca.brojRacuna == null || paymentOrder.podaciOUplati.racunPoverioca.brojRacuna == "") {
			toastr.warning("Potrebno je izabrati račun.");
			return;
		}
		
		return $http({
			  method: 'PUT',
			  url: '../Firma/payment-order/remove/' + paymentOrder.id,
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	
}]);