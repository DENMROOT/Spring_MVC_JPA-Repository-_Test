/**
 * Created by dmakarov on 10/13/2015.
 */
var clientServices = angular.module('clientServices', ['ngResource']);

clientServices.factory('Client', ['$resource',
    function($resource){
        return $resource('http://localhost:8080/rest/clients/:id',{id: '@id' }, {
            update: {method: 'PUT'}
        });
    }]
).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});