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
			
			$scope.sendOverviewSectionRequest = function() {
				overviewService.sendOverviewSectionRequest($scope.overviewSections, $scope.overviewSectionRequest).then(function(response) {
					$scope.overviewSections = response.data;
				});
			}
}]);