angular.module('myApp', []).controller('myController', function($scope,$http) {
    
    
//    $scope.person={};
//    $scope.message = {};
//    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
//    //var details = JSON.stringify('{"name": $scope.name}');
//    
//    $scope.getMessage = function(){ 
//    //var details = JSON.stringify('{"UserName": $scope.fname, "Email": $scope.lname}');
//     var details = $scope.fields;
//    	//var details = $scope.fname;
//     console.log(details);
//        $http({
//            url : 'javaAngularJS',
//            method : "POST",
//            data : details
//        }).then(function(response) {
//            console.log(response.data);
//            $scope.message = response.data;
//        }, function(response) {
//            //fail case
//            console.log(response);
//            $scope.message = response;
//        });
//    
//    };
//    $scope.getDataFromServer = function() {
//      
//    	$http.get('javaAngularJS')
//    	.success(function(data, status, headers, config) {
//            $scope.person = data;
//    	})
//    	.error(function(data, status, headers, config) {
//            // called asynchronously if an error occurs
//            // or server returns response with an error status.
//    	});
//    	
//    };
//   
    

	 $scope.person={};
   $scope.message = {};
   $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
   //var details = JSON.stringify('{"name": $scope.name}');
   
   $scope.submitForm = function(){ 
   var details = {UserName: $scope.user, Email: $scope.email};
   //var details2 = JSON.stringify('{"UserName" : $scope.user, "Email" : $scope.email}');
   var formData = new FormData();
   formData.append('UserName', details.UserName);
   formData.append('Email', details.Email);
    //var details = $scope.user;
   	//var details = $scope.fname;
    console.log(formData);
       $http({
           url : 'javaAngularJS',
           method : "POST",
           data : formData
       }).then(function(response) {
           console.log(response.data);
           $scope.message = response.data;
       }, function(response) {
           //fail case
           console.log(response);
           $scope.message = response[0];
       });
   
   };
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});