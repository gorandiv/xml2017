invoiceModule.controller('invoiceController', [
		'$scope',
		'$interval',
		'invoiceObjectFactoryService',
		'invoiceService',
		'invoiceCompanyService',
		'productOrServiceService',
		function($scope, $interval, invoiceObjectFactoryService, invoiceService,
				invoiceCompanyService, productOrServiceService) {

			$scope.createdInvoices = [];
			$scope.sentInvoices = [];
			$scope.receivedInvoices = [];

			var intervalInMS = 10000;
			
			var getCreatedInvoices = function() {
				invoiceService.getCreatedInvoices().then(function(response) {
					if (response.status == -1)
						$interval.cancel($scope.createdInvoicesInterval);
					$scope.createdInvoices = response.data;
				});
			}

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
			
			getCreatedInvoices();
			getSentInvoices();
			getReceivedInvoices();
			
			
			$scope.createdInvoicesInterval = $interval(getCreatedInvoices,
					intervalInMS);
			$scope.sentInvoicesInterval = $interval(getSentInvoices,
					intervalInMS);
			$scope.receivedInvoicesInterval = $interval(getReceivedInvoices,
					intervalInMS);

			$scope.thisCompany = {};
			$scope.companies = [];
			$scope.productsOrServices = [];
			
			invoiceCompanyService.getThisCompany().then(function(response) {
				$scope.thisCompany = response.data;
			});
			
			invoiceCompanyService.getCompanies().then(function(response) {
				$scope.companies = response.data;
			});
			
			productOrServiceService.getCompanyProductsOrServices().then(function(response) {
				$scope.productsOrServices = response.data;
			});
			

			$scope.data = new invoiceObjectFactoryService.Data();
			$scope.invoice = new invoiceObjectFactoryService.Invoice(new invoiceObjectFactoryService.InvoiceHeader());
			
			$scope.setInvoiceHeaderBuyer = function(company) {
				invoiceService.setInvoiceHeaderBuyer($scope.invoice, company);
			}
			
			$scope.$watch('invoice.stavkaFakture', function(newVal, oldVal){
		        invoiceService.setInvoiceHeaderValues($scope.invoice);
		    }, true);

			$scope.addInvoiceItem = function() {
				if($scope.invoice.stavkaFakture.length == 0)
					$scope.invoice.stavkaFakture
					.push(new invoiceObjectFactoryService.InvoiceItem(1));
				else {
					$scope.invoice.stavkaFakture
					.push(new invoiceObjectFactoryService.InvoiceItem($scope.invoice.stavkaFakture[$scope.invoice.stavkaFakture.length - 1].redniBroj + 1));
				}
					
			}
			
			$scope.removeInvoiceItem = function(invoiceItem) {
				$scope.invoice.stavkaFakture
				.splice($scope.invoice.stavkaFakture.indexOf(invoiceItem), 1);
			}
			
			$scope.setInvoiceItemValues = function(invoiceItem, check) {
				invoiceService.setInvoiceItemValues(invoiceItem, check);
				
			}
			$scope.createInvoice = function() {
					invoiceService.createInvoice($scope.invoice, $scope.thisCompany).then(function(response) {
						console.log(response.data)
						$scope.createdInvoices.push(response.data);
						$scope.invoice = new invoiceObjectFactoryService.Invoice(new invoiceObjectFactoryService.InvoiceHeader());
						toastr.info("Faktura uspešno kreirana.");
					});
			}
			
			$scope.sendInvoice = function(invoice) {
				invoiceService.sendInvoice(invoice).then(function(response) {
					$scope.sentInvoices.push(response.data);
					$scope.createdInvoices.splice($scope.createdInvoices.indexOf(invoice), 1);
					invoice = response.data;
					toastr.info("Faktura uspešno poslata.");
				});
			}
			
			$scope.removeInvoice = function(invoice) {
				invoiceService.removeInvoice(invoice).then(function(response) {
					$scope.createdInvoices.splice($scope.createdInvoices.indexOf(invoice), 1);
					toastr.info("Faktura uspešno obrisana.");
				});
			}
			
			$scope.$on('$destroy',function(){
				$interval.cancel($scope.createdInvoicesInterval);
				$interval.cancel($scope.sentInvoicesInterval);
				$interval.cancel($scope.receivedInvoicesInterval);
			});

		} ]);