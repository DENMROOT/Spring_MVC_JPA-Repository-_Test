/**
 * Created by dmakarov on 10/13/2015.
 */
var clientControllers = angular.module('clientControllers', []);

clientControllers.controller('ClientsController', function($scope, $state, popupService, $window, Client) {
    $scope.clients = Client.query();

    $scope.deleteClient = function(client) { // Delete a client. Issues a DELETE to /api/clients/:id
        if (popupService.showPopup('Really delete this?')) {
            client.$delete(function() {
                $window.location.href = '/pages/index.html'; //redirect to home
            });
        }
    };
}).controller('ClientViewController', function($scope, $stateParams, Client) {
    $scope.client = Client.get({ id: $stateParams.id }); //Get a single client.Issues a GET to /api/clients/:id
}).controller('ClientCreateController', function($scope, $state, $stateParams, Client) {
    $scope.client = new Client();  //create new client instance. Properties will be set via ng-model on UI

    $scope.addClient = function() { //create a new client. Issues a POST to /api/clients
        $scope.client.$save(function() {
            $state.go('clients'); // on success go back to home i.e. clients state.
        });
    };
}).controller('ClientEditController', function($scope, $state, $stateParams, Client) {
    $scope.updateClient = function() { //Update the edited client. Issues a PUT to /api/clients/:id
        $scope.client.$update(function() {
        //$scope.client = Client.update({ id: client.id }); //Get a single client.Issues a GET to /api/clients/:id
            $state.go('clients'); // on success go back to home i.e. clients state.
        });
    };

    $scope.loadClient = function() { //Issues a GET request to /api/clients/:id to get a client to update
        $scope.client = Client.get({ id: $stateParams.id });
    };

    $scope.loadClient(); // Load a client which can be edited on UI
});