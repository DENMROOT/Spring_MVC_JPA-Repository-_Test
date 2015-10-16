angular.module('BankApp').config(function($stateProvider) {
    $stateProvider.state('clients', { // state for showing all clients
        url: 'rest/clients',
        templateUrl: '/pages/clientViews/clients.html',
        controller: 'ClientsController'
    }).state('viewClient', { //state for showing single client
        url: '/rest/clients/:id',
        templateUrl: '/pages/clientViews/client-view.html',
        controller: 'ClientViewController'
    }).state('newClient', { //state for adding a new client
        url: '/rest/clients/',
        templateUrl: '/pages/clientViews/client-add.html',
        controller: 'ClientCreateController'
    }).state('editClient', { //state for updating a client
        url: '/rest/clients/:id',
        templateUrl: '/pages/clientViews/client-edit1.html',
        controller: 'ClientEditController'
    });
}).run(function($state) {
    $state.go('clients'); //make a transition to clients state when app starts
});