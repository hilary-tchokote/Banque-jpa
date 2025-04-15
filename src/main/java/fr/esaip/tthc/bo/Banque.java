package fr.esaip.tthc.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BANQUE")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false, unique = true)
    private Integer id;

    @Column(name="NOM", nullable = false)
    private String nom;

    public Banque() {}

    public Banque(String nom){
        this.nom = nom;
    }

    {
        this.client = new HashSet<Client>();
    }
    // Relation avec Client
    @OneToMany(mappedBy = "banque")
    private Set<Client> client;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Set<Client> getClient() {
        return client;
    }

    public void setClient(Set<Client> client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", client=" + client +
                '}';
    }


}
