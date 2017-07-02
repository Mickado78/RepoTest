package fr.moi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.moi.dao.IJoueurDao;
import fr.moi.model.Joueur;

@Service
@Transactional
public class JoueurServiceImpl implements IJoueurService {

	@Autowired
	private IJoueurDao jDao;
	
	
	public void setjDao(IJoueurDao jDao) {
		this.jDao = jDao;
	}

	@Override
	public Joueur ajouterJoueur(Joueur j) {
		return jDao.ajouterJoueur(j);
	}

	@Override
	public List<Joueur> getAllJoueurs() {
		return jDao.getAllJoueurs();
	}

	@Override
	public Joueur modifierJoueur(Joueur j) {
		return jDao.modifierJoueur(j);
	}

	@Override
	public void supprimerJoueur(int id) {
		jDao.supprimerJoueur(id);

	}

	@Override
	public Joueur getJoueurByUserName(String userName) {
		return jDao.getJoueurByUserName(userName);
	}

}
