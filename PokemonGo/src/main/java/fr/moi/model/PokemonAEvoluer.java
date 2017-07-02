package fr.moi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pokemonAEvoluer")
public class PokemonAEvoluer implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idP")
	private int id;
	private int numeroPokedex;
	private String nom;
	private int nbBonbons;
	private int nbBonbonsEvolution1;
	private int nbBonbonsEvolution2;
	private int nbBonbonsManquants1;
	private int nbBonbonsManquants2;
	private String image;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="joueur_id",referencedColumnName="idJ")
	private Joueur joueur;

	public PokemonAEvoluer() {
		super();
	}

	public PokemonAEvoluer(int numeroPokedex, String nom, int nbBonbons, int nbBonbonsEvolution1,
			int nbBonbonsEvolution2, int nbBonbonsManquants1, int nbBonbonsManquants2, String image) {
		super();
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.nbBonbons = nbBonbons;
		this.nbBonbonsEvolution1 = nbBonbonsEvolution1;
		this.nbBonbonsEvolution2 = nbBonbonsEvolution2;
		this.nbBonbonsManquants1 = nbBonbonsManquants1;
		this.nbBonbonsManquants2 = nbBonbonsManquants2;
		this.image = image;
	}

	public PokemonAEvoluer(int id, int numeroPokedex, String nom, int nbBonbons, int nbBonbonsEvolution1,
			int nbBonbonsEvolution2, int nbBonbonsManquants1, int nbBonbonsManquants2, String image) {
		super();
		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.nbBonbons = nbBonbons;
		this.nbBonbonsEvolution1 = nbBonbonsEvolution1;
		this.nbBonbonsEvolution2 = nbBonbonsEvolution2;
		this.nbBonbonsManquants1 = nbBonbonsManquants1;
		this.nbBonbonsManquants2 = nbBonbonsManquants2;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbBonbons() {
		return nbBonbons;
	}

	public void setNbBonbons(int nbBonbons) {
		this.nbBonbons = nbBonbons;
	}

	public int getNbBonbonsEvolution1() {
		return nbBonbonsEvolution1;
	}

	public void setNbBonbonsEvolution1(int nbBonbonsEvolution1) {
		this.nbBonbonsEvolution1 = nbBonbonsEvolution1;
	}

	public int getNbBonbonsEvolution2() {
		return nbBonbonsEvolution2;
	}

	public void setNbBonbonsEvolution2(int nbBonbonsEvolution2) {
		this.nbBonbonsEvolution2 = nbBonbonsEvolution2;
	}

	public int getNbBonbonsManquants1() {
		return nbBonbonsManquants1;
	}

	public void setNbBonbonsManquants1(int nbBonbonsManquants1) {
		this.nbBonbonsManquants1 = nbBonbonsManquants1;
	}

	public int getNbBonbonsManquants2() {
		return nbBonbonsManquants2;
	}

	public void setNbBonbonsManquants2(int nbBonbonsManquants2) {
		this.nbBonbonsManquants2 = nbBonbonsManquants2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "PokemonAEvoluer [id=" + id + ", numeroPokedex=" + numeroPokedex + ", nom=" + nom + ", nbBonbons="
				+ nbBonbons + ", nbBonbonsEvolution1=" + nbBonbonsEvolution1 + ", nbBonbonsEvolution2="
				+ nbBonbonsEvolution2 + ", nbBonbonsManquants1=" + nbBonbonsManquants1 + ", nbBonbonsManquants2="
				+ nbBonbonsManquants2 + ", image=" + image + "]";
	}

	
}
