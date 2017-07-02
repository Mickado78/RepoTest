'use strict';

app.factory('joueurProvider',function($http){
	
	var restJoueurUrl="http://localhost:8181/PokemonGo/spring";
	
	function findAll(callBack){
		$http({
			method:'GET',
			url:restJoueurUrl+'/liste'
		}).then(function successCallBack(response){
			console.log(response.data);
			callBack(response.data);
		},function echecCallBack(response){
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	function ajoutJoueur(joueurAjoutee,callBack){
		$http({
			method:'POST',
			url:restJoueurUrl+'/create',
			data:angular.toJson(joueurAjoutee),
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
	
	function supprimerJoueur(id,callBack){
		$http({
			method:'DELETE',
			url:restJoueurUrl+'/delete/'+id
			
		}).then(function successCallBack(response) {
			console.log(response);
			callBack(response);
		},function echecCallBack(response) {
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	function modifJoueur(joueurModif,callBack){
		$http({
			method:'PUT',
			url:restJoueurUrl+'/update',
			data:angular.toJson(joueurModif),
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
	
	function findJoueur(userName,callBack) {
		$http({
			method:'GET',
			url:restJoueurUrl+'/joueur?jUserName='+userName
		}).then(function successCallBack(response) {
			console.log(response.data);
			callBack(response.data);
		},function echecCallBack(response) {
			console.log("Erreur: "+response.status+" "+response.statusText);
		});
	}
	
	return {
		getListeJoueurs:findAll,
		addJoueur:ajoutJoueur,
		deleteJoueur:supprimerJoueur,
		updateJoueur:modifJoueur,
		getJoueurByUserName:findJoueur
	}
	
	
});