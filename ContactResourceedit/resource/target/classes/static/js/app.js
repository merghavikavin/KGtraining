angular.module('contactapp', ['ngRoute', 'ngResource'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when("/", {
                templateUrl: "partials/details.html",
                controller: "ContactController"
            })
            .when("/create", {
                templateUrl: "partials/create.html",
                controller: "ContactController"
            })
            .when("/update", {
                templateUrl: "partials/update.html",
                controller: "ContactController"
            })
            .when("/delete", {
                templateUrl: "partials/delete.html",
                controller: "ContactController"
            })
            .when("/getcontact", {
                templateUrl: "partials/getbyid.html",
                controller: "ContactController"
            })
            .otherwise({
                redirectTo: "/404",
                templateUrl: "partials/404.html"
            });
    }]);