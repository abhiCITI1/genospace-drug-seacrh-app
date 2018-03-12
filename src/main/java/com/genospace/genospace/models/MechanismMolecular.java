package com.genospace.genospace.models;


import javax.persistence.*;

@Entity
@Table(name = "Mechanism_Molecular")
public class MechanismMolecular {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mechanism_id")
    private  int id;

    private String mechanismName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMechanismName() {
        return mechanismName;
    }

    public void setMechanismName(String mechanismName) {
        this.mechanismName = mechanismName;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

}
