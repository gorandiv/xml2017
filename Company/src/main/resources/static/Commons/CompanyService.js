appModule.service('companyService', ['$http', function($http) {
	
	this.getCompanies = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/company/companies',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.getThisCompany = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/company/this-company',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
	this.getThisCompanyBills = function() {
		return $http({
			  method: 'GET',
			  url: '../Firma/company/this-company-bills',
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
}]);