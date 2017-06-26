paymentOrderModule.service('paymentOrderCompanyService', ['$http', function($http) {

	this.getThisCompany = function() {
		return $http({
			method : 'GET',
			url : '../Firma/company/this-company',
			headers : {
				'Accept' : 'application/json'
			}
		}).then(function successCallback(response) {
			return response;
		}, function errorCallback(response) {
			return response;
		});
	}

}]);