'use strict';

app.factory('pokemonProvider',function($http){
	
	var restPokemonUrl="http://localhost:8181/PokemonGo/spring/pokemon";
	
	function findAllPokemonManquants(id, callBack){
		$http({
			method:'GET',
			url:restPokemonUrl+'Manquants/liste?jId='+id
		}).then(function successCallBack(response){
			console.log(response.data);
			callBack(response.data);
		},function echecCallBack(response){
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	function ajoutPokemon(pokemonAjoutee,callBack){
		$http({
			method:'POST',
			url:restPokemonUrl+'/create',
			data:angular.toJson(pokemonAjoutee),
			headers:{
				'content-Type':'application/json'
			}
		}).then(function successCallBack(response) {
			console.log(response.data);
			callBack(response.data);
		},function echecCallBack(response) {
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	function supprimerPokemon(id,callBack){
		$http({
			method:'DELETE',
			url:restPokemonUrl+'/delete/'+id
			
		}).then(function successCallBack(response) {
			console.log(response);
			callBack(response);
		},function echecCallBack(response) {
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	function modifPokemon(pokemonModif,callBack){
		$http({
			method:'PUT',
			url:restPokemonUrl+'/update',
			data:angular.toJson(pokemonModif),
			headers: {
				'content-Type':'application/json'
			}
		}).then(function successCallBack(response) {
			console.log(response.data);
			callBack(response.data);
		},function echecCallBack(response) {
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	
	return {
		getListePokemonManquants:findAllPokemonManquants,
		addPokemon:ajoutPokemon,
		deletePokemon:supprimerPokemon,
		updatePokemon:modifPokemon
	}
	
	
});