'use strict';

app.config(function($routeProvider){
	$routeProvider.when('/findListe',{
		controller: 'findAllCtrl',
		templateUrl:'partials/findAll.html'
	})
	.when('/findByUserName',{
		controller: 'getByUserNameCtrl',
		templateUrl:'partials/getByUserName.html'
	})
	.when('/add',{
		controller: 'addCtrl',
		templateUrl:'partials/ajouter.html'
	})
	.when('/update',{
		controller: 'updateCtrl',
		templateUrl:'partials/modifier.html'
	})
	.when('/del',{
		controller: 'delCtrl',
		templateUrl:'partials/supprimer.html'
	})
	.otherwise({
		redirectTo: '/findListe'
	});
});