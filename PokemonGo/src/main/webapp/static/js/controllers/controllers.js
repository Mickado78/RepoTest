app

.controller("findAllCtrl",function($scope,joueurProvider,$rootScope,$location){
	joueurProvider.getListeJoueurs(function(callBack){
		$scope.listeJoueurs=callBack;
		console.log($scope.listeJoueurs);
	});
	
	$scope.deleteLien=function(id){
		joueurProvider.deleteJoueur(id,function(callBack){
			
			if(callBack!=undefined && callBack!=''){
				joueurProvider.getListeJoueurs(function(callBack){
					$scope.listeJoueurs=callBack;
				});
			}
		});
	}
	
	$scope.modifLien=function(joueur){
		$rootScope.joueurMod=joueur;
		$location.path('/update');
	}
	$scope.affichLien=function(id){
		$rootScope.joueurId=id;
		$location.path('/findListePokemonByJoueur')
	}
})

.controller("addCtrl",function($scope,joueurProvider,$location){
	$scope.joueurForm={
			nom:undefined,
			prenom:undefined,
			userName:undefined,
			mdp:undefined,
	}
	$scope.ajouter=function(){
		joueurProvider.addJoueur($scope.joueurForm,function(callBack){
			if(callBack!=undefined && callBack!=''){
			$location.path('/findListe');
		}
		});
	}
})



.controller("delCtrl",function($scope,joueurProvider,$location){
	$scope.id=undefined;
$scope.supprimer=function(){
		
	joueurProvider.deleteJoueur($scope.id,function(callBack){
		if(callBack!=undefined && callBack!=''){
			$location.path('/findListe');
		}
	});
	}
})

.controller("updateCtrl",function($scope,joueurProvider,$location, $rootScope){
	if($rootScope.joueurMod==null){
	$scope.joueurForm={
			id:undefined,
			nom:undefined,
			prenom:undefined,
			userName:undefined,
			mdp:undefined,
			}
	}else{
		$scope.joueurForm={
				id:$rootScope.joueurMod.id,
				nom:$rootScope.joueurMod.nom,
				prenom:$rootScope.joueurMod.prenom,
				userName:$rootScope.joueurMod.userName,
				mdp:$rootScope.joueurMod.mdp,
				}
		
		$rootScope.joueurMod=null;
	}
$scope.modifier=function(){
		
	joueurProvider.updateJoueur($scope.joueurForm,function(callBack){
		if(callBack!=undefined && callBack!=''){
			$location.path('/findListe');
		}
	});
	}
})

.controller("getByUserNameCtrl",function($scope,joueurProvider,$location,$rootScope){
	$scope.userName=undefined;
	$scope.indice=false;
	
	$scope.rechercher=function(){
		
	joueurProvider.getJoueurByUserName($scope.userName,function(callBack){
		if(callBack!=undefined && callBack!=''){
			$scope.indice=true;
			$scope.joueurRec=callBack;
		}else{
			$scope.indice=false;
		}
	});
	}
	$scope.deleteLien=function(id){
		joueurProvider.deleteJoueur(id,function(callBack){
			
			if(callBack!=undefined && callBack!=''){
				joueurProvider.getListeJoueurs(function(callBack){
					$location.path('/findListe');
				});
			}
		});
	}
	
	$scope.modifLien=function(joueur){
		$rootScope.joueurMod=joueur;
		$location.path('/update');
	}
})