package fr.moi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.moi.model.Joueur;
import fr.moi.services.IJoueurService;

@RestController
public class JoueurRestController {

	@Autowired
	private IJoueurService jService;

	public void setjService(IJoueurService jService) {
		this.jService = jService;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST, produces="application/json",consumes="application/json")
	public Joueur addJoueur(@RequestBody Joueur j){
		return jService.ajouterJoueur(j);
	}
	
	@RequestMapping(value="/liste",method=RequestMethod.GET, produces="application/json")
	public List<Joueur> getAllJoueurs(){
		return jService.getAllJoueurs();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT, produces="application/json",consumes="application/json")
	public Joueur updateJoueur(@RequestBody Joueur j){
		return jService.modifierJoueur(j);
	}
	
	@RequestMapping(value="/delete/{jId}", method=RequestMethod.DELETE, produces="application/json")
	public void deleteJoueur(@PathVariable("jId") int id){
		jService.supprimerJoueur(id);
	}
	
	@RequestMapping(value="/joueur", method=RequestMethod.GET, produces="application/json")
	public Joueur getJoueurByName(@RequestParam("jUserName") String userName){
		return jService.getJoueurByUserName(userName);
	}
}
