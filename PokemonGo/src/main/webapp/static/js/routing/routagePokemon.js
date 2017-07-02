'use strict';

app.config(function($routeProvider){
	$routeProvider.when('/findListePokemonByJoueur',{
		controller: 'findAllPokemonCtrl',
		templateUrl:'partials/findAllPokemonByJoueur.html'
	})
	.when('/addPokemon',{
		controller: 'addPokemonCtrl',
		templateUrl:'partials/ajouterPokemon.html'
	})
	.when('/updatePokemon',{
		controller: 'updatePokemonCtrl',
		templateUrl:'partials/modifierPokemon.html'
	})
	.when('/delPokemon',{
		controller: 'delPokemonCtrl',
		templateUrl:'partials/supprimerPokemon.html'
	})
	.otherwise({
		redirectTo: '/findListe'
	});
});