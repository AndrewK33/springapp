angular.module('market-front').controller('userRegistrationController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/market/';


    $scope.userRegistration = function (){
        $http.post(contextPath + 'registration', $scope.user_registration)
            .then(function successCallback (response) {
                $scope.user_registration = null;
                alert('Пользователь успешно создан');
            }, function failureCallback (response) {
                console.log(response);
                $scope.user_registration = null;
            });
    }


});