paymentOrderModule.controller('paymentOrderController', [
		'$scope',
		'$interval',
		'objectFactoryService',
		'paymentOrderService',
		'invoiceService',
		'companyService',
		function($scope, $interval, objectFactoryService, paymentOrderService,
				invoiceService, companyService) {

			$scope.createdPaymentOrders = [];
			$scope.sentPaymentOrders = [];

			var intervalInMS = 10000;

			var getCreatedPaymentOrders = function() {
				paymentOrderService.getCreatedPaymentOrders().then(
						function(response) {
							if (response.status == -1)
								$interval.cancel($scope.createdPaymentOrders);
							$scope.createdPaymentOrders = response.data;
						});
			}

			var getSentPaymentOrders = function() {
				paymentOrderService.getSentPaymentOrders().then(
						function(response) {
							if (response.status == -1)
								$interval.cancel($scope.sentPaymentOrders);
							$scope.sentPaymentOrders = response.data;
						});
			}

			getCreatedPaymentOrders();
			getSentPaymentOrders();

			$scope.receivedInvoices = [];
			$scope.thisCompany = {};
			
			companyService.getThisCompany().then(function(response) {
				$scope.thisCompany = response.data;
			});

			$scope.paymentOrder = new objectFactoryService.PaymentOrder(
					new objectFactoryService.PaymentInfo(
							new objectFactoryService.Account(),
							new objectFactoryService.Account()));

			invoiceService.getReceivedInvoices().then(function(response) {
				$scope.receivedInvoices = response.data;
			});

			$scope.setPaymentOrderInvoiceValues = function(invoice) {
				paymentOrderService.setPaymentOrderInvoiceValues($paymentOrder,
						invoice);
			}

			$scope.createdPaymentOrdersInterval = $interval(
					getCreatedPaymentOrders, intervalInMS);
			$scope.sentPaymentOrdersInterval = $interval(getSentPaymentOrders,
					intervalInMS);
			
			$scope.createPaymentOrder = function() {
				paymentOrderService.createPaymentOrder($scope.paymentOrder, $scope.thisCompany).then(function(response) {
					console.log(response.data)
					$scope.createdPaymentOrders.push(response.data);
					$scope.paymentOrder = new objectFactoryService.PaymentOrder(
							new objectFactoryService.PaymentInfo(
									new objectFactoryService.Account(),
									new objectFactoryService.Account()));
					toastr.info("Nalog za plaćanje je uspešno kreiran.");
				});
			}
			
			$scope.sendPaymentOrder = function(paymentOrder) {
				paymentOrderService.sendPaymentOrder(paymentOrder).then(function(response) {
					$scope.sentPaymentOrders.push(response.data);
					$scope.createdPaymentOrders.splice($scope.createdPaymentOrders.indexOf(paymentOrder), 1);
					paymentOrder = response.data;
					toastr.info("Nalog za plaćanje je uspešno poslat.");
				});
			}
			
			$scope.removePaymentOrder = function(paymentOrder) {
					paymentOrderService.removePaymentOrder(paymentOrder).then(function(response) {
						$scope.createdPaymentOrders.splice($scope.createdPaymentOrders.indexOf(paymentOrder), 1);
						toastr.info("Nalog za plaćanje uspešno obrisan.");
					});
			}

			$scope.$on('$destroy', function() {
				$interval.cancel($scope.createdPaymentOrdersInterval);
				$interval.cancel($scope.sentPaymentOrdersInterval);
			});

		} ]);