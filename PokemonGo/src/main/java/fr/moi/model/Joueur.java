package fr.moi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Joueurs")
public class Joueur implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idJ")
	private int id;
	private String nom;
	private String prenom;
	private String userName;
	private String mdp;
	
	@OneToMany(mappedBy="joueur", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PokemonPokedex> listePokemonPokedex;
	
	@OneToMany(mappedBy="joueur", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PokemonManquants> listePokemonManquants;
	
	@OneToMany(mappedBy="joueur", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PokemonPossedes> listePokemonPossedes;
	
	@OneToMany(mappedBy="joueur", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PokemonBesoins> listePokemonBesoins;
	
	@OneToMany(mappedBy="joueur", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<PokemonAEvoluer> listePokemonAEvoluer;
	
	public Joueur() {
		super();
	}

	public Joueur(String nom, String prenom, String userName, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.userName = userName;
		this.mdp = mdp;
	}

	public Joueur(int id, String nom, String prenom, String userName, String mdp) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.userName = userName;
		this.mdp = mdp;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public List<PokemonManquants> getListePokemonManquants() {
		return listePokemonManquants;
	}

	public void setListePokemonManquants(List<PokemonManquants> listePokemonManquants) {
		this.listePokemonManquants = listePokemonManquants;
	}

	public List<PokemonPossedes> getListePokemonPossedes() {
		return listePokemonPossedes;
	}

	public void setListePokemonPossedes(List<PokemonPossedes> listePokemonPossedes) {
		this.listePokemonPossedes = listePokemonPossedes;
	}

	public List<PokemonBesoins> getListePokemonBesoins() {
		return listePokemonBesoins;
	}

	public void setListePokemonBesoins(List<PokemonBesoins> listePokemonBesoins) {
		this.listePokemonBesoins = listePokemonBesoins;
	}

	public List<PokemonAEvoluer> getListePokemonAEvoluer() {
		return listePokemonAEvoluer;
	}

	public void setListePokemonAEvoluer(List<PokemonAEvoluer> listePokemonAEvoluer) {
		this.listePokemonAEvoluer = listePokemonAEvoluer;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", userName=" + userName + ", mdp=" + mdp
				+ "]";
	}
	
		
	
}
