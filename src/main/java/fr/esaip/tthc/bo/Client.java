package fr.esaip.tthc.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false, unique = true)
    private Integer id;

    @Column(name="NOM", nullable = false)
    private String nom;

    @Column(name="MONTANT", nullable = false)
    private double montant;

    @Column(name="MOTIF", nullable = false)
    private String motif;

    @Column(name="DATE", nullable = false)
    private LocalDateTime date;


    public Client() {

    }

    public Client(String nom, double montant, String motif, LocalDateTime date) {
        this.nom = nom;
        this.montant = montant;
        this.motif = motif;
        this.date = date;
    }

    {
        this.comptes = new HashSet<Compte>();
    }

    // Relation uni-directionelle entre Client et Adresse
    @OneToOne
    @JoinColumn(name = "ADD_ID")
    private  Adresse adresse;

    // Relation bi-directionelle entre Client et Compte
    @ManyToMany
    @JoinTable(name="COMPTES_CLIENTS",
            joinColumns = @JoinColumn(name="ID_CLI", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMP",referencedColumnName = "ID")
    )
    private Set<Compte> comptes;

    // Relation avec Banques
    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom=" + nom +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", date=" + date +
                ", adresse=" + adresse +
                ", comptes=" + comptes +
                ", banque=" + banque +
                '}';
    }

    //fonction pour ajouter un compte
    public void addCompte(Compte compte) {
        this.comptes.add(compte);
        compte.getClients().add(this);
    }



}