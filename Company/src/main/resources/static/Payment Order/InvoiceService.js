paymentOrderModule.service('invoiceService', [ '$http', function($http) {

	this.getReceivedInvoices = function() {
		return $http({
			method : 'GET',
			url : '../Firma/invoice/received',
			headers : {
				'Accept' : 'application/json'
			}
		}).then(function successCallback(response) {
			return response;
		}, function errorCallback(response) {
			return response;
		});
	}

} ]);