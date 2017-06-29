overviewModule.service('overviewService', ['$http', function($http) {
	
	this.sendOverviewSectionRequest = function(overviewSections, overviewSectionRequest) {
		this.brojRacuna = "";
		this.datum = "";
		this.redniBrojPreseka = 1;
		
		
		for(var i = 0; i < overviewSections.length; i++) {
			
			if(overviewSections[i].zaglavlje.brojPreseka == overviewSectionRequest.redniBrojPreseka && overviewSections[i].zaglavlje.brojRacuna == overviewSectionRequest.brojRacuna) {
				toastr.warning("Presek sa tim rednim brojem je već prikazan.");
				return;
			}
			
		}
		
		
		if(overviewSectionRequest.brojRacuna == null || overviewSectionRequest.brojRacuna == "" || overviewSectionRequest.datum == null || overviewSectionRequest.datum == "") {
			toastr.warning("Potrebno je uneti sve podatke o preseku.");
			return;
		}
		var date = overviewSectionRequest.datum;
		
		var d = (date.getMonth() + 1) + '/' + date.getDate() + '/' +  date.getFullYear();
		
		var splitD = d.split('/');
		if(splitD[0].length == 1)
			splitD[0] = "0"+splitD[0];
		if(splitD[1].length == 1)
			splitD[1] = "0"+splitD[1];
		
		var datumZaSlanje = splitD[1]+splitD[0]+splitD[2];
		
		
		request = {brojRacuna : overviewSectionRequest.brojRacuna, datum :  datumZaSlanje,
			redniBrojPreseka: overviewSectionRequest.redniBrojPreseka};
		return $http({
			  method: 'POST',
			  url: '../Firma/overview/overview-section/'+request.brojRacuna+'/'+request.datum+'/'+request.redniBrojPreseka,
			  headers: { 'Accept': 'application/json' }
			}).then(function successCallback(response) {
				return response;
			  }, function errorCallback(response) {
				  return response;
			  });
	}
	
}]);