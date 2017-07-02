package fr.moi.services;

import java.util.List;

import fr.moi.model.Joueur;

public interface IJoueurService {

	public Joueur ajouterJoueur(Joueur j);
	public List<Joueur> getAllJoueurs();
	public Joueur modifierJoueur(Joueur j);
	public void supprimerJoueur(int id);
	public Joueur getJoueurByUserName(String userName);
}
