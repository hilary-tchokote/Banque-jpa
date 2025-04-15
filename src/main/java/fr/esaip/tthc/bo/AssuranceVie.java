package fr.esaip.tthc.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ASSURANCEVIE")
public class AssuranceVie extends Compte {

    @Column(name = "DATEFIN", nullable = false)
    private LocalDateTime dateFin;

    @Column(name = "TAUX", nullable = false)
    private double taux;

    public AssuranceVie() {}

    public AssuranceVie(String numero, Double solde, LocalDateTime dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }



    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }



}
