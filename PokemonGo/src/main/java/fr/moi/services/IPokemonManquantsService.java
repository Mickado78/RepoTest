package fr.moi.services;

import java.util.List;

import fr.moi.model.PokemonManquants;

public interface IPokemonManquantsService {

	public PokemonManquants ajouterPokemon(PokemonManquants pm);
	public List<PokemonManquants> getAllPokemonByJoueur(int id);
	public PokemonManquants modifierPokemon(PokemonManquants pm);
	public void supprimerPokemon(int id);
}
