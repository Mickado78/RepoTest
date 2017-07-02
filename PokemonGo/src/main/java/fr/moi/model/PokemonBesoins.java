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
@Table(name="pokemonBesoins")
public class PokemonBesoins implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idP")
	private int id;
	private int numeroPokedex;
	private String nom;
	private double meilleurIV;
	private String meilleureEval;
	private double besoinIV;
	private String besoinEval;
	private String image;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="joueur_id",referencedColumnName="idJ")
	private Joueur joueur;

	public PokemonBesoins() {
		super();
	}

	public PokemonBesoins(int numeroPokedex, String nom, double meilleurIV, String meilleureEval, double besoinIV,
			String besoinEval, String image) {
		super();
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.meilleurIV = meilleurIV;
		this.meilleureEval = meilleureEval;
		this.besoinIV = besoinIV;
		this.besoinEval = besoinEval;
		this.image = image;
	}

	public PokemonBesoins(int id, int numeroPokedex, String nom, double meilleurIV, String meilleureEval,
			double besoinIV, String besoinEval, String image) {
		super();
		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.meilleurIV = meilleurIV;
		this.meilleureEval = meilleureEval;
		this.besoinIV = besoinIV;
		this.besoinEval = besoinEval;
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

	public double getMeilleurIV() {
		return meilleurIV;
	}

	public void setMeilleurIV(double meilleurIV) {
		this.meilleurIV = meilleurIV;
	}

	public String getMeilleureEval() {
		return meilleureEval;
	}

	public void setMeilleureEval(String meilleureEval) {
		this.meilleureEval = meilleureEval;
	}

	public double getBesoinIV() {
		return besoinIV;
	}

	public void setBesoinIV(double besoinIV) {
		this.besoinIV = besoinIV;
	}

	public String getBesoinEval() {
		return besoinEval;
	}

	public void setBesoinEval(String besoinEval) {
		this.besoinEval = besoinEval;
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
		return "PokemonBesoins [id=" + id + ", numeroPokedex=" + numeroPokedex + ", nom=" + nom + ", meilleurIV="
				+ meilleurIV + ", meilleureEval=" + meilleureEval + ", besoinIV=" + besoinIV + ", besoinEval="
				+ besoinEval + ", image=" + image + "]";
	}

	
}