package fr.moi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.moi.model.PokemonManquants;
import fr.moi.services.IPokemonManquantsService;

@RestController
@RequestMapping(value="/pokemonManquants")
public class PokemonManquantsRestController {

	@Autowired
	private IPokemonManquantsService pmService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST, produces="application/json",consumes="application/json")
	public PokemonManquants addPokemon(@RequestBody PokemonManquants pm){
		return pmService.ajouterPokemon(pm);
	}
	
	@RequestMapping(value="/liste",method=RequestMethod.GET, produces="application/json")
	public List<PokemonManquants> getAllPokemonsByJoueur(@RequestParam("jId") int id){
		return pmService.getAllPokemonByJoueur(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public PokemonManquants updatePokemon(@RequestBody PokemonManquants pm){
		return pmService.modifierPokemon(pm);
	}
	
	@RequestMapping(value="/delete/{pId}", method=RequestMethod.DELETE, produces="application/json")
	public void deletePokemon(@PathVariable("pId") int id){
		pmService.supprimerPokemon(id);
	}
	
}

