package fr.moi.services;

import java.util.List;

import fr.moi.model.Pokemon;

public interface IPokemonService {

	public Pokemon ajouterPokemon(Pokemon p);
	public List<Pokemon> getAllPokemonByJoueur(int id);
	public Pokemon modifierPokemon(Pokemon p);
	public void supprimerPokemon(int id);
}
