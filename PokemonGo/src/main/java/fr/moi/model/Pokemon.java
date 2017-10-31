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
@Table(name="pokemon")
public class Pokemon implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idP")
	private int id;
	private int numeroPokedex;
	private String nom;
	private String image;
	private int nombreBonbons;
	private int nombreBonbons4EV;
	private int nombreEV;
	private double iVbesoin;
	private double iVmax;
	private double etatCapture;
	private double etatEV;
	private double etatIV;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="joueur_id",referencedColumnName="idJ")
	private Joueur joueur;
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(int numeroPokedex, String nom, String image, int nombreBonbons, int nombreBonbons4EV, int nombreEV,
			double iVbesoin, double iVmax, double etatCapture, double etatEV, double etatIV) {
		super();
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.image = image;
		this.nombreBonbons = nombreBonbons;
		this.nombreBonbons4EV = nombreBonbons4EV;
		this.nombreEV = nombreEV;
		this.iVbesoin = iVbesoin;
		this.iVmax = iVmax;
		this.etatCapture = etatCapture;
		this.etatEV = etatEV;
		this.etatIV = etatIV;
	}
	
	public Pokemon(int id, int numeroPokedex, String nom, String image, int nombreBonbons, int nombreBonbons4EV,
			int nombreEV, double iVbesoin, double iVmax, double etatCapture, double etatEV, double etatIV) {
		super();
		this.id = id;
		this.numeroPokedex = numeroPokedex;
		this.nom = nom;
		this.image = image;
		this.nombreBonbons = nombreBonbons;
		this.nombreBonbons4EV = nombreBonbons4EV;
		this.nombreEV = nombreEV;
		this.iVbesoin = iVbesoin;
		this.iVmax = iVmax;
		this.etatCapture = etatCapture;
		this.etatEV = etatEV;
		this.etatIV = etatIV;
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
	
	public int getNombreBonbons() {
		return nombreBonbons;
	}

	public void setNombreBonbons(int nombreBonbons) {
		this.nombreBonbons = nombreBonbons;
	}

	public int getNombreBonbons4EV() {
		return nombreBonbons4EV;
	}

	public void setNombreBonbons4EV(int nombreBonbons4EV) {
		this.nombreBonbons4EV = nombreBonbons4EV;
	}

	public int getNombreEV() {
		return nombreEV;
	}

	public void setNombreEV(int nombreEV) {
		this.nombreEV = nombreEV;
	}

	public double getiVbesoin() {
		return iVbesoin;
	}

	public void setiVbesoin(double iVbesoin) {
		this.iVbesoin = iVbesoin;
	}

	public double getiVmax() {
		return iVmax;
	}

	public void setiVmax(double iVmax) {
		this.iVmax = iVmax;
	}

	public double getEtatCapture() {
		return etatCapture;
	}

	public void setEtatCapture(double etatCapture) {
		this.etatCapture = etatCapture;
	}

	public double getEtatEV() {
		return etatEV;
	}

	public void setEtatEV(double etatEV) {
		this.etatEV = etatEV;
	}

	public double getEtatIV() {
		return etatIV;
	}

	public void setEtatIV(double etatIV) {
		this.etatIV = etatIV;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", numeroPokedex=" + numeroPokedex + ", nom=" + nom + ", image=" + image
				+ ", nombreBonbons=" + nombreBonbons + ", nombreBonbons4EV=" + nombreBonbons4EV + ", nombreEV="
				+ nombreEV + ", iVbesoin=" + iVbesoin + ", iVmax=" + iVmax + ", etatCapture=" + etatCapture
				+ ", etatEV=" + etatEV + ", etatIV=" + etatIV + "]";
	}

	

}
