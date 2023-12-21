angular.module('myApp').factory('Contact', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/contacts/:id', { id: '@id' }, {
        'query': { method: 'GET', isArray: true },
        'get': { method: 'GET' },
        'save': { method: 'POST' },
        'update': { method: 'PUT' },
        'remove': { method: 'DELETE' }
    });
}]);