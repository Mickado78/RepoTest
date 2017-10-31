package fr.moi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.moi.dao.IPokemonDao;
import fr.moi.model.Pokemon;

@Service
@Transactional
public class PokemonServiceImpl implements IPokemonService {

	@Autowired
	private IPokemonDao pDao;
	
	public void setPmDao(IPokemonDao pDao) {
		this.pDao = pDao;
	}

	@Override
	public Pokemon ajouterPokemon(Pokemon p) {
		return pDao.ajouterPokemon(p);
	}

	@Override
	public List<Pokemon> getAllPokemonByJoueur(int id) {
		return pDao.getAllPokemonByJoueur(id);
	}

	@Override
	public Pokemon modifierPokemon(Pokemon p) {
		return pDao.modifierPokemon(p);
	}

	@Override
	public void supprimerPokemon(int id) {
		pDao.supprimerPokemon(id);

	}

}
