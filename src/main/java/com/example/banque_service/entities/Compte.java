package com.example.banque_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // solde initial (peut être utilisé comme montant de départ)
    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    // transactions associées au compte
    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    // Getter personnalisé : calcule le solde dynamique en tenant compte des transactions
    public double getSolde() {
        double delta = 0.0;
        if (transactions != null) {
            for (Transaction t : transactions) {
                if (t.getType() == TypeTransaction.DEPOT) delta += t.getMontant();
                else if (t.getType() == TypeTransaction.RETRAIT) delta -= t.getMontant();
            }
        }
        return this.solde + delta;
    }
}
