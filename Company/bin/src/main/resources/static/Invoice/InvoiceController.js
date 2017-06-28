invoiceModule.controller('invoiceController', [
		'$scope',
		'$interval',
		'objectFactoryService',
		'invoiceService',
		'companyService',
		function($scope, $interval, objectFactoryService, invoiceService,
				companyService) {
			
			
			//load first two
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

			$scope.sentInvoicesInterval = $interval(getSentInvoices,
					intervalInMS);
			$scope.receivedInvoicesInterval = $interval(getReceivedInvoices,
					intervalInMS);

			//load companies and goods, set this company and remove from companies
			$scope.thisCompany = null;
			$scope.companies = [];
			$scope.servicesOrGoods = [];

			$scope.data = new objectFactoryService.Data();
			$scope.invoice = new objectFactoryService.Invoice();

			$scope.addInvoiceItem = function() {
				$scope.invoice.stavkaFakture
						.push(new objectFactoryService.InvoiceItem());
			}

		} ]);