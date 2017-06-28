overviewModule.service('overviewService', ['$http', function($http) {
	
	this.sendOverviewSectionRequest = function(overviewSectionRequest) {
		this.brojRacuna = "";
		this.datum = "";
		this.redniBrojPreseka = 1;
		
		if(overviewSectionRequest.brojRacuna == null || overviewSectionRequest.brojRacuna == "" || overviewSectionRequest.datum == null || overviewSectionRequest.datum == "") {
			toastr.warning("Potrebno je uneti sve podatke o preseku.");
			return;
		}
		var date = overviewSectionRequest.datum;
		request = {brojRacuna : overviewSectionRequest.brojRacuna, datum :  (date.getMonth() + 1) + '/' + date.getDate() + '/' +  date.getFullYear(),
			redniBrojPreseka: overviewSectionRequest.redniBrojPreseka};
		return $http({
			  method: 'POST',
			  url: '../Firma/overview/overview-section',
			  data: angular.toJson(request),
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
}]);