package fr.moi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.moi.model.Pokemon;

@Repository
public class PokemonDaoImpl implements IPokemonDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Pokemon ajouterPokemon(Pokemon pm) {
		Session s=sf.getCurrentSession();
		s.save(pm);
		return pm;
	}

	@Override
	public List<Pokemon> getAllPokemonByJoueur(int id) {
		Session s=sf.getCurrentSession();
		String req="from Pokemon as p where p.joueur.id=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pId", id);
		List<Pokemon> listePokemon=query.list();
		return listePokemon;
	}

	@Override
	public Pokemon modifierPokemon(Pokemon p) {
		Session s=sf.getCurrentSession();
		String req="update from Pokemon as p set p.numeroPokedex=:pNumP, p.nom=:pNom, p.image=:pImg, p.nombreBonbons=:pNbBb, p.nombreBonbons4EV=:pNbBb4EV, p.nombreEV=:pNbEV, p.iVbesoin=:pIVb, p.iVmax=:pIVm, p.etatCapture=:pEtatC, p.etatEV=:pEtatEV, p.etatIV=:pEtatIV where p.id=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pNumP", p.getNom());
		query.setParameter("pNom", p.getNom());
		query.setParameter("pImg", p.getImage());
		query.setParameter("pId", p.getId());
		query.setParameter("pNbBb", p.getNombreBonbons());
		query.setParameter("pNbBb4EV", p.getNombreBonbons4EV());
		query.setParameter("pNbEV", p.getNombreEV());
		query.setParameter("pIVb", p.getiVbesoin());
		query.setParameter("pIVm", p.getiVmax());
		query.setParameter("pEtatC", p.getEtatCapture());
		query.setParameter("pEtatEV", p.getEtatEV());
		query.setParameter("pEtatIV", p.getEtatIV());
		query.executeUpdate();
		return p;
	}

	@Override
	public void supprimerPokemon(int id) {
		Session s=sf.getCurrentSession();
		Pokemon p=(Pokemon) s.get(Pokemon.class, id);
		s.delete(p);

	}

}
