package fr.esaip.tthc.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "VIREMENT")
public class Virement extends Operation {

    @Column(name = "BENEFICIAIRE")
    private String beneficiare;

    public Virement() {}

    public Virement(double montant, String motif, LocalDateTime date, String beneficiare) {
        super(montant, motif, date);
        this.beneficiare = beneficiare;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }

    @Override
    public String toString() {
        return "Virement{" +
                "beneficiare='" + beneficiare + '\'' +
                '}';
    }



}
