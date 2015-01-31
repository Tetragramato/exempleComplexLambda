package com.tetragramato.model.complexe;

import com.tetragramato.model.type.TypeQuittance;

/**
 * Une quittance a plusieurs opérations : dans notre cas le lien entre les 2 n'existe que dans Operation.
 * Created by tetragramato on 31/01/2015.
 */
public class Quittance {
    private Long idQuittance;
    private String libelle;
    private TypeQuittance typeQuittance;

    public Quittance() {
    }

    private Quittance(Builder builder) {
        setIdQuittance(builder.idQuittance);
        setLibelle(builder.libelle);
        setTypeQuittance(builder.typeQuittance);
    }

    public Long getIdQuittance() {
        return idQuittance;
    }

    public void setIdQuittance(Long idQuittance) {
        this.idQuittance = idQuittance;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TypeQuittance getTypeQuittance() {
        return typeQuittance;
    }

    public void setTypeQuittance(TypeQuittance typeQuittance) {
        this.typeQuittance = typeQuittance;
    }


    public static final class Builder {
        private Long idQuittance;
        private String libelle;
        private TypeQuittance typeQuittance;

        public Builder() {
        }

        public Builder idQuittance(Long idQuittance) {
            this.idQuittance = idQuittance;
            return this;
        }

        public Builder libelle(String libelle) {
            this.libelle = libelle;
            return this;
        }

        public Builder typeQuittance(TypeQuittance typeQuittance) {
            this.typeQuittance = typeQuittance;
            return this;
        }

        public Quittance build() {
            return new Quittance(this);
        }
    }
}
