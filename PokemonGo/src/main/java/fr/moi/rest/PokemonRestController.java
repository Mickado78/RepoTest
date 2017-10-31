package fr.moi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.moi.model.Pokemon;
import fr.moi.services.IPokemonService;

@RestController
@RequestMapping(value="/pokemon")
public class PokemonRestController {

	@Autowired
	private IPokemonService pService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST, produces="application/json",consumes="application/json")
	public Pokemon addPokemon(@RequestBody Pokemon p){
		return pService.ajouterPokemon(p);
	}
	
	@RequestMapping(value="/liste",method=RequestMethod.GET, produces="application/json")
	public List<Pokemon> getAllPokemonsByJoueur(@RequestParam("jId") int id){
		return pService.getAllPokemonByJoueur(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public Pokemon updatePokemon(@RequestBody Pokemon p){
		return pService.modifierPokemon(p);
	}
	
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE, produces="application/json")
	public void deletePokemon(@PathVariable("pId") int id){
		pService.supprimerPokemon(id);
	}
	
}

