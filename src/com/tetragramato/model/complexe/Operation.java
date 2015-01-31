package com.tetragramato.model.complexe;

import com.tetragramato.model.type.TypeOperation;

import java.math.BigDecimal;

/**
 * Une opération est réalisé pour toute "transaction" : une opération fait référence à une quittance. (une quittance a plusieurs opérations, pour le test ce lien n'existe que sur Operation)
 * Created by tetragramato on 31/01/2015.
 */
public class Operation {
    private TypeOperation typeOperation;
    private BigDecimal montant;
    private Quittance quittance;

    private Operation(Builder builder) {
        setTypeOperation(builder.typeOperation);
        setMontant(builder.montant);
        quittance = builder.quittance;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Quittance getQuittance() {
        return quittance;
    }

    public void setQuittance(Quittance quittance) {
        this.quittance = quittance;
    }

    public static final class Builder {
        private TypeOperation typeOperation;
        private BigDecimal montant;
        private Quittance quittance;

        public Builder() {
        }

        public Builder typeOperation(TypeOperation typeOperation) {
            this.typeOperation = typeOperation;
            return this;
        }

        public Builder montant(BigDecimal montant) {
            this.montant = montant;
            return this;
        }

        public Builder quittance(Quittance quittance) {
            this.quittance = quittance;
            return this;
        }

        public Operation build() {
            return new Operation(this);
        }
    }
}
