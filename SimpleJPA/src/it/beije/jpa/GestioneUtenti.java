package it.beije.jpa;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.beije.jpa.entities.Utente;

public class GestioneUtenti {
	
	public void creaUtente(
			String nome,
			String cognome,
			String email,
			Date dataIscrizione
			) {
		
	      EntityManagerFactory emfactory = JpaEntityManager.getInstance();
	      
	      EntityManager entitymanager = emfactory.createEntityManager();
	      entitymanager.getTransaction().begin();

	      Utente utente = new Utente();
	      utente.setCognome(cognome);
	      utente.setNome(nome);
	      utente.setEmail(email);
	      utente.setDataIscrizione(dataIscrizione);
	      
	      entitymanager.persist(utente);
	      entitymanager.getTransaction().commit();

	      entitymanager.close( );
	      emfactory.close( );
	}
	
	public void trovaUtente(int id) {
		
		EntityManagerFactory emfactory = JpaEntityManager.getInstance();
		EntityManager entitymanager = emfactory.createEntityManager();
		Utente utente = entitymanager.find(Utente.class, id);

		System.out.println("utente ID = " + utente.getId());
		System.out.println("utente Nome = " + utente.getNome());
		System.out.println("utente getCognome = " + utente.getCognome());
		System.out.println("utente Email = " + utente.getEmail());

	}


	public static void main( String[ ] args ) {
		
		GestioneUtenti gestioneUtenti = new GestioneUtenti();
		gestioneUtenti.creaUtente("Pippo", "Kappa", "pk@bbb4.com", new Date(2000000000000L));
		
		//gestioneUtenti.trovaUtente(9);
		
	}
}
