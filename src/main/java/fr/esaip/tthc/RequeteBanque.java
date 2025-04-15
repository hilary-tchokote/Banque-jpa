package fr.esaip.tthc;

import fr.esaip.tthc.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.time.Month;

public class RequeteBanque {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        et.begin();

        // Requete pour inserer un compte associé à 2 clients

        // Utilisation de LocalDateTime.now
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime date2 = LocalDateTime.of(2026, Month.APRIL, 20, 12, 30);

        //Creation de 2 clients
        Client client1 = new Client("Ticha", 200.000, "New Account", date);
        Client client2 = new Client("Joyce", 100.000, "Second Account", date);

        em.persist(client1);
        em.persist(client2);

        //Creation du compte
        LivretA compte = new LivretA("LIV-1", 500.000, 50);

        compte.addClient(client1);
        compte.addClient(client2);

        em.persist(compte);


        //Requete pour inserer un client avec plusieurs comptes

        Client client3 = new Client("Tichou", 300.000, "New Account", date);
        em.persist(client3);

        //Creation d'un compte courant et AssuranceVie
        LivretA compteLivretA = new LivretA("LIV-2", 40.000,40);
        AssuranceVie compteAssuranceVie = new AssuranceVie("ASV-1", 500.000,date2, 60);

        compteLivretA.addClient(client3);
        compteAssuranceVie.addClient(client3);

        em.persist(compteLivretA);
        em.persist(compteAssuranceVie);


        //Requete pour inserer des operations sur un compte
        Compte account = em.find(Compte.class,1);

        if (account != null) {
            Virement virement = new Virement(200, "Saving",date,"Joyce");
            account.addOperation(virement);
            em.persist(virement);
        }

        et.commit();
        em.close();
        emf.close();

    }
}
