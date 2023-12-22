app.controller('ContactController', function ($scope, ContactService) {
    $scope.contacts = [];
 
    $scope.loadContacts = function () {
        ContactService.list().then(function (response) {
            $scope.contacts = response.data;
            console.log($scope.contacts);
        }, function (error) {
            console.error('Error loading contacts', error);
        });
    };
 
    $scope.saveContact = function () {
        ContactService.save($scope.newcontact).then(function (response) {
            $scope.loadContacts();
            $scope.newcontact = {};
        }, function (error) {
            console.error('Error saving contact', error);
        });
    }
 
    $scope.edit = function (id) {
        ContactService.get(id).then(function (response) {
            $scope.newcontact = response.data;
        }, function (error) {
            console.error('Error loading contact for editing', error);
        });
    }
 
    $scope.delete = function (id) {
        ContactService.delete(id).then(function () {
            $scope.loadContacts();
            if ($scope.newcontact.id == id) $scope.newcontact = {};
        }, function (error) {
            console.error('Error deleting contact', error);
        });
    }
 
    $scope.loadContacts();
});