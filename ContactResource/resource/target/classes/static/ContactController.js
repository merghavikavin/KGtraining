angular.module('myApp').controller('ContactController', ['$scope', 'Contact', function ($scope, Contact) {
    $scope.contacts = [];
    $scope.newContact = {};
 
    // Function to load contacts
    $scope.loadContacts = function () {
        Contact.query().$promise.then(function (data) {
            $scope.contacts = data;
        });
    };
 
    // Function to save or update a contact
    $scope.saveContact = function () {
        if ($scope.newContact.id) {
            // Update existing contact
            Contact.update({ id: $scope.newContact.id }, $scope.newContact, function () {
                $scope.refreshContacts();
            });
        } else {
            // Create new contact
            Contact.save($scope.newContact, function () {
                $scope.refreshContacts();
            });
        }
        $scope.newContact = {};
    };
 
    // Function to edit a contact
    $scope.editContact = function (id) {
        $scope.newContact = Contact.get({ id: id });
    };
 
    // Function to delete a contact
    $scope.deleteContact = function (id) {
        Contact.remove({ id: id }, function () {
            $scope.refreshContacts();
        });
    };
 
    // Function to refresh contacts
    $scope.refreshContacts = function () {
        $scope.loadContacts();
    };
 
    // Load contacts on controller initialization
    $scope.loadContacts();
}]);