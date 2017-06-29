overviewModule.controller('overviewController', [
		'$scope',
		'$interval',
		'overviewService',
		'companyService',
		'overviewObjectFactoryService',
		function($scope, $interval, overviewService, companyService,
				overviewObjectFactoryService) {
			
			$scope.thisCompanyBills = [];
			$scope.overviewSectionRequest = new overviewObjectFactoryService.OverviewSectionRequest();
			$scope.overviewSections = [];
			
			companyService.getThisCompanyBills().then(function(response) {
				$scope.thisCompanyBills = response.data;
			});
			
			$scope.$watch('overviewSectionRequest', function(oldVal, newVal) {
				if(oldVal.brojRacuna != newVal.brojRacuna || oldVal.datum != newVal.datum) {
					$scope.overviewSections = [];
				}
				
		    }, true);
			
			$scope.sendOverviewSectionRequest = function() {
				overviewService.sendOverviewSectionRequest($scope.overviewSections, $scope.overviewSectionRequest).then(function(response) {
					if(response.data !== "")
						$scope.overviewSections.push(response.data);
					else
						toastr.warning("Nema preseka za izabrani račun, datum i redni broj.");
				});
			}
}]);