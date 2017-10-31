package fr.moi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.moi.model.Joueur;

@Repository
public class JoueurDaoImpl implements IJoueurDao {

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Joueur ajouterJoueur(Joueur j) {
		Session s=sf.getCurrentSession();
		s.save(j);
		String req1="INSERT INTO pokemon (image, nom, numeroPokedex, joueur_id, etatCapture, etatEV, etatIV, iVbesoin, iVmax, nombreBonbons, nombreBonbons4EV, nombreEV) SELECT image, nom, numeroPokedex, joueur_id, etatCapture, etatEV, etatIV, iVbesoin, iVmax, nombreBonbons, nombreBonbons4EV, nombreEV FROM pokedex";
		Query query=s.createSQLQuery(req1);
		query.executeUpdate();
		String req2="UPDATE from Pokemon as p set p.joueur.id=:pJid where p.joueur.id=:pId";
		Query query2=s.createQuery(req2);
		query2.setParameter("pJid", j.getId());
		query2.setParameter("pId", 1);
		query2.executeUpdate();
		return j;
	}

	@Override
	public List<Joueur> getAllJoueurs() {
		Session s=sf.getCurrentSession();
		String req="from Joueur";
		Query query=s.createQuery(req);
		List<Joueur> listeJoueurs=query.list();
		return listeJoueurs;
	}

	@Override
	public Joueur modifierJoueur(Joueur j) {
		Session s=sf.getCurrentSession();
		String req="update from Joueur as j set j.nom=:pNom, j.prenom=:pPrenom, j.userName=:pUN, j.mdp=:pMdp where j.id=:pId";
		Query query=s.createQuery(req);
		query.setParameter("pNom", j.getNom());
		query.setParameter("pPrenom", j.getPrenom());
		query.setParameter("pUN", j.getUserName());
		query.setParameter("pMdp", j.getMdp());
		query.setParameter("pId", j.getId());
		query.executeUpdate();
		return j;
	}

	@Override
	public void supprimerJoueur(int id) {
		Session s=sf.getCurrentSession();
		Joueur j=(Joueur) s.get(Joueur.class, id);
		s.delete(j);

	}

	@Override
	public Joueur getJoueurByUserName(String userName) {
		Session s=sf.getCurrentSession();
		String req="from Joueur as j where j.userName=:pUN";
		Query query=s.createQuery(req);
		query.setParameter("pUN", userName);
		Joueur j_rec=(Joueur) query.uniqueResult();
		return j_rec;
	}

}
