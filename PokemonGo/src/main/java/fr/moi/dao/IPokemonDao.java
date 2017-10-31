package fr.moi.dao;

import java.util.List;

import fr.moi.model.Pokemon;

public interface IPokemonDao {

	public Pokemon ajouterPokemon(Pokemon p);
	public List<Pokemon> getAllPokemonByJoueur(int id);
	public Pokemon modifierPokemon(Pokemon p);
	public void supprimerPokemon(int id);
	
}
