package fr.moi.dao;

import java.util.List;

import fr.moi.model.PokemonManquants;

public interface IPokemonManquantsDao {

	public PokemonManquants ajouterPokemon(PokemonManquants pm);
	public List<PokemonManquants> getAllPokemonByJoueur(int id);
	public PokemonManquants modifierPokemon(PokemonManquants pm);
	public void supprimerPokemon(int id);
	
}
