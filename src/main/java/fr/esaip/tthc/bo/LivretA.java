package fr.esaip.tthc.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRETA")
public class LivretA extends Compte{

    @Column(name = "TAUX")
    private double taux;

    public LivretA() {}

    public LivretA(String numero, Double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                '}';
    }



}
