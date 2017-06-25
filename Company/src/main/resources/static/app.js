var appModule = angular.module('app' , ['ngRoute', 'invoice', 'paymentOrder', 'overview']);

appModule.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider
        .when('/invoice', {
            templateUrl : 'Firma/Invoice/invoice.html',
            controller  : 'invoiceController'
        })
        .when('/payment-order', {
            templateUrl : 'Firma/Payment Order/payment-order.html',
            controller  : 'paymentOrderController'
        })
        .when('/overview', {
            templateUrl : 'Firma/Overview/overview.html',
            controller  : 'overviewController'
        })
        
});
