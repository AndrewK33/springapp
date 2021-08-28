angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';



    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + 'products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
        });
    };

    $scope.showInfo = function (product) {
        console.log(product)
        alert(product.title);
    };

    $scope.deleteProduct = function (product, index) {
           $http({
                url: contextPath + 'products/delete/' + encodeURIComponent(product.id),
                    method: 'DELETE',
                }).then(
                    function (response) {
                       console.log(response);
                       $scope.productsPage.content.splice(index, 1);
                    },
                    function (response) {
                       console.log(response);
                       alert('Не удалось удалить объект');
                    }
                );
    };



    $scope.loadProducts();
});
