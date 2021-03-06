package fr.moi.dao;

import java.util.List;

import fr.moi.model.Joueur;

public interface IJoueurDao {

	public Joueur ajouterJoueur(Joueur j);
	public List<Joueur> getAllJoueurs();
	public Joueur modifierJoueur(Joueur j);
	public void supprimerJoueur(int id);
	public Joueur getJoueurByUserName(String userName);
}
