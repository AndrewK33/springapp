angular.module('market-front', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/market/';
    let currentPageIndex = 1;


    $scope.loadProducts = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + 'api/v1/products',
            method: 'GET',
            params: {
                p: pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
            $scope.paginationArray = $scope.generatePagesIndexes(1, $scope.productsPage.totalPages);
        });
    };

    $scope.showInfo = function (product) {
        console.log(product)
        alert(product.title);
    };

    $scope.deleteProduct = function (product, index) {
        $http({
            url: contextPath + 'api/v1/products/delete/' + encodeURIComponent(product.id),
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


    $scope.createNewProduct = function () {
        $http.post(contextPath + 'api/v1/products', $scope.new_product)
            .then(function successCallback (response) {
                $scope.loadProducts(currentPageIndex);
                $scope.new_product = null;
            }, function failureCallback (response){
                alert(response.data.message);
            });
        console.log();
    }

    $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }


    $scope.loadProducts();
});
