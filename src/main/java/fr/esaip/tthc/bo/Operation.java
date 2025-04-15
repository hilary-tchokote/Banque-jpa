package fr.esaip.tthc.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "OPERATION")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false, unique = true)
    private Integer id;

    @Column(name="MONTANT", nullable = false)
    private double montant;

    @Column(name="MOTIF", nullable = false)
    private String motif;

    @Column(name="DATE", nullable = false)
    private LocalDateTime date;

    public Operation() {}

    public Operation(double montant, String motif, LocalDateTime date) {
        this.montant = montant;
        this.motif = motif;
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name= "ID_COMP")
    private Compte compte;

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", date=" + date +
                ", compte=" + compte +
                '}';
    }

}
