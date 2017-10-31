app

.controller("findAllPokemonCtrl",function($scope,pokemonProvider,$rootScope,$location){
		id=$rootScope.joueurId;
		console.log(id);
		pokemonProvider.getListePokemon(id,function(callBack){
		$scope.listePokemon=callBack;
		console.log($scope.listePokemon);
	});
	
	$scope.deleteLien=function(id){
		pokemonProvider.deletePokemon(id,function(callBack){
			
			if(callBack!=undefined && callBack!=''){
				pokemonProvider.getListePokemon(function(callBack){
					$scope.listePokemon=callBack;
				});
			}
		});
	}
	
	$scope.modifLien=function(pokemon){
		$rootScope.pokemonMod=pokemon;
		$location.path('/updatePokemon');
	}
})

.controller("addPokemonCtrl",function($scope,pokemonProvider,$location){
	$scope.pokemonForm={
			nom:undefined,
			nbBonbon:undefined,
			evalBesoin:undefined,
			image:undefined,
	}
	$scope.ajouter=function(){
		pokemonProvider.addPokemon($scope.pokemonForm,function(callBack){
			if(callBack!=undefined && callBack!=''){
			$location.path('/findListePokemon');
		}
		});
	}
})



.controller("delPokemonCtrl",function($scope,pokemonProvider,$location){
	$scope.id=undefined;
$scope.supprimer=function(){
		
	pokemonProvider.deletePokemon($scope.id,function(callBack){
		if(callBack!=undefined && callBack!=''){
			$location.path('/findListePokemon');
		}
	});
	}
})

.controller("updatePokemonCtrl",function($scope,pokemonProvider,$location, $rootScope){
	if($rootScope.pokemonMod==null){
	$scope.pokemonForm={
			id:undefined,
			nom:undefined,
			nbBonbon:undefined,
			evalBesoin:undefined,
			image:undefined,
			}
	}else{
		$scope.pokemonForm={
				id:$rootScope.pokemonMod.id,
				nom:$rootScope.pokemonMod.nom,
				nbBonbon:$rootScope.pokemonMod.nbBonbon,
				evalBesoin:$rootScope.pokemonMod.evalBesoin,
				image:$rootScope.pokemonMod.image,
				}
		
		$rootScope.pokemonMod=null;
	}
$scope.modifier=function(){
		
	pokemonProvider.updatePokemon($scope.pokemonForm,function(callBack){
		if(callBack!=undefined && callBack!=''){
			$location.path('/findListePokemon');
		}
	});
	}
})