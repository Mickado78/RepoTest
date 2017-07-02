package fr.moi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.moi.model.PokemonManquants;

@Repository
public class PokemonManquantsDaoImpl implements IPokemonManquantsDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public PokemonManquants ajouterPokemon(PokemonManquants pm) {
		Session s=sf.getCurrentSession();
		s.save(pm);
		return pm;
	}

	@Override
	public List<PokemonManquants> getAllPokemonByJoueur(int id) {
		Session s=sf.getCurrentSession();
		String req="from PokemonManquants as p where p.joueur.id=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pId", id);
		List<PokemonManquants> listePokemonM=query.list();
		return listePokemonM;
	}

	@Override
	public PokemonManquants modifierPokemon(PokemonManquants pm) {
		Session s=sf.getCurrentSession();
		String req="update from PokemonManquants as p set p.numeroPokedex=:pNumP, p.nom=:pNom, p.image=:pImg where p.id=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pNumP", pm.getNom());
		query.setParameter("pNom", pm.getNom());
		query.setParameter("pImg", pm.getImage());
		query.setParameter("pId", pm.getId());
		query.executeUpdate();
		return pm;
	}

	@Override
	public void supprimerPokemon(int id) {
		Session s=sf.getCurrentSession();
		PokemonManquants pm=(PokemonManquants) s.get(PokemonManquants.class, id);
		s.delete(pm);

	}

}
