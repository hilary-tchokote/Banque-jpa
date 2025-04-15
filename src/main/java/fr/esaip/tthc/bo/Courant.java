package fr.esaip.tthc.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "COURANT")
public class Courant extends Compte{

    @Column(name="DECOUVERT",nullable = false)
    private double decouvert;

    public Courant() {}

    public Courant(String numero, Double solde, double decouvert) {
        super(numero, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return "Courant{" +
                "decouvert=" + decouvert +
                '}';
    }



}
