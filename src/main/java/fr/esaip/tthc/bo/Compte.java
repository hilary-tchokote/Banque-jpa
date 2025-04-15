package fr.esaip.tthc.bo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false, unique = true)
    private Integer id;

    @Column(name="NUMERO", nullable = false)
    private String numero;

    @Column(name="SOLDE", nullable = false)
    private Double solde;

    {
        this.clients = new HashSet<Client>();
        this.operations = new HashSet<Operation>();
    }

    public Compte() {

    }

    public Compte(String numero, Double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    // Relation bidirectionelle entre clients et compte
    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    // Relation avec Operation
    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", clients=" + clients +
                ", operations=" + operations +
                '}';
    }

    public void addClient(Client client) {
        this.clients.add(client);
        client.getComptes().add(this);
    }

    public void addOperation(Operation op) {
        this.operations.add(op);
        op.setCompte(this);
    }
}
