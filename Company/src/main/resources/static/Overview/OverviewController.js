overviewModule.controller('overviewController', [
		'$scope',
		'$interval',
		'overviewService',
		'companyService',
		'overviewObjectFactoryService',
		function($scope, $interval, overviewService, overviewCompanyService,
				overviewObjectFactoryService) {
			
			$scope.thisCompany = {};
			$scope.overviewSectionRequest = new overviewObjectFactoryService.OverviewSectionRequest();
			$scope.overviewSections = [];
			
			companyService.getThisCompany().then(function(response) {
				$scope.thisCompany = response.data;
			});
			
			
		}]);