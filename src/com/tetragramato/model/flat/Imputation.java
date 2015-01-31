package com.tetragramato.model.flat;

import java.math.BigDecimal;

/**
 * Super type de Commission / Prime.
 * Created by tetragramato on 31/01/2015.
 */
public class Imputation {
    private Long idImputation;
    private String libelle;
    private BigDecimal totalDue;
    private BigDecimal totalAPercevoir;

    public Long getIdImputation() {
        return idImputation;
    }

    public void setIdImputation(Long idImputation) {
        this.idImputation = idImputation;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public BigDecimal getTotalAPercevoir() {
        return totalAPercevoir;
    }

    public void setTotalAPercevoir(BigDecimal totalAPercevoir) {
        this.totalAPercevoir = totalAPercevoir;
    }
}
