invoiceModule.controller('invoiceController', [
		'$scope',
		'$interval',
		'objectFactoryService',
		'invoiceService',
		'companyService',
		'productOrServiceService',
		function($scope, $interval, objectFactoryService, invoiceService,
				companyService, productOrServiceService) {

			$scope.sentInvoices = [];
			$scope.receivedInvoices = [];
			$scope.createdInvoices = [];

			var intervalInMS = 10000;

			var getSentInvoices = function() {
				invoiceService.getSentInvoices().then(function(response) {
					if (response.status == -1)
						$interval.cancel($scope.sentInvoicesInterval);
					$scope.sentInvoices = response.data;
				});
			}

			var getReceivedInvoices = function() {
				invoiceService.getReceivedInvoices().then(function(response) {
					if (response.status == -1)
						$interval.cancel($scope.receivedInvoicesInterval);
					$scope.receivedInvoices = response.data;
				});

			}
			
			getSentInvoices();
			getReceivedInvoices();

			$scope.sentInvoicesInterval = $interval(getSentInvoices,
					intervalInMS);
			$scope.receivedInvoicesInterval = $interval(getReceivedInvoices,
					intervalInMS);

			$scope.thisCompany = {};
			$scope.companies = [];
			$scope.productsOrServices = [];
			
			companyService.getThisCompany().then(function(response) {
				$scope.thisCompany = response.data;
			});
			
			companyService.getCompanies().then(function(response) {
				console.log(response.data)
				$scope.companies = response.data;
			});
			
			productOrServiceService.getCompanyProductsOrServices().then(function(response) {
				$scope.productsOrServices = response.data;
			});
			

			$scope.data = new objectFactoryService.Data();
			$scope.invoice = new objectFactoryService.Invoice($scope.thisCompany);

			$scope.addInvoiceItem = function() {
				$scope.invoice.stavkaFakture
						.push(new objectFactoryService.InvoiceItem());
			}
			
			$scope.removeInvoiceItem = function(invoiceItem) {
				$scope.invoice.stavkaFakture
				.splice($scope.invoice.stavkaFakture.indexOf(invoiceItem), 1);
			}
			
			$scope.setInvoiceItemValues = function(invoiceItem, check) {
				invoiceService.setInvoiceItemValues(invoiceItem, check);
				
			}
			$scope.sendInvoice = function(invoice) {
				invoiceService.sendInvoice(invoice);
			}
			
			$scope.$on('$destroy',function(){
				$interval.cancel($scope.sentInvoicesInterval);
				$interval.cancel($scope.receivedInvoicesInterval);
			});

		} ]);