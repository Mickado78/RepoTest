package fr.moi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.moi.dao.IPokemonManquantsDao;
import fr.moi.model.PokemonManquants;

@Service
@Transactional
public class PokemonManquantsServiceImpl implements IPokemonManquantsService {

	@Autowired
	private IPokemonManquantsDao pmDao;
	
	public void setPmDao(IPokemonManquantsDao pmDao) {
		this.pmDao = pmDao;
	}

	@Override
	public PokemonManquants ajouterPokemon(PokemonManquants pm) {
		return pmDao.ajouterPokemon(pm);
	}

	@Override
	public List<PokemonManquants> getAllPokemonByJoueur(int id) {
		return pmDao.getAllPokemonByJoueur(id);
	}

	@Override
	public PokemonManquants modifierPokemon(PokemonManquants pm) {
		return pmDao.modifierPokemon(pm);
	}

	@Override
	public void supprimerPokemon(int id) {
		pmDao.supprimerPokemon(id);

	}

}
