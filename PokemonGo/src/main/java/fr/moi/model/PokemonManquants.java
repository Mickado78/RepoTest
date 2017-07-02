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
@Table(name="pokemonManquants")
public class PokemonManquants implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idP")
	private int id;
	private int numeroPokedex;
	private String nom;
	private String image;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="joueur_id",referencedColumnName="idJ")
	private Joueur joueur;
	
	public PokemonManquants() {
		super();
	}

	public PokemonManquants(int numeroPokedex, String nom, String image) {
		super();
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.image = image;
	}

	public PokemonManquants(int id, int numeroPokedex, String nom, String image) {
		super();
		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumeroPokedex() {
		return numeroPokedex;
	}

	public void setNumeroPokedex(int numeroPokedex) {
		this.numeroPokedex = numeroPokedex;
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
		return "PokemonManquants [id=" + id + ", numeroPokedex=" + numeroPokedex + ", nom=" + nom + ", image=" + image
				+ "]";
	}


}
