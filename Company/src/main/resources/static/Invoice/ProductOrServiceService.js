invoiceModule.service('productOrServiceService', ['$http', function($http) {
	
	this.getCompanyProductsOrServices = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/product-or-service/company-products-or-services',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
}]);