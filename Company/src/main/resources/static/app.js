var appModule = angular.module('app' , ['ngRoute', 'invoice', 'paymentOrder', 'overview']);

appModule.config(function($routeProvider, $locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider
        .when('/fakture', {
            templateUrl : 'Firma/Invoice/invoice.html',
            controller  : 'invoiceController'
        })
        .when('/nalozi', {
            templateUrl : 'Firma/Payment Order/payment-order.html',
            controller  : 'paymentOrderController'
        })
        .when('/izvod', {
            templateUrl : 'Firma/Overview/overview.html',
            controller  : 'overviewController'
        })
        
});
