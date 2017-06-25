invoiceModule.service('invoiceService', ['$http', function($http) {
	
	this.getSentInvoices = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/invoice/sent',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				console.log(response.data)
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
				console.log(response.data)
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.sendInvoice = function() {
		
	}
	
}]);