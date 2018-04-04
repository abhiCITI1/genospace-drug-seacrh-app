package com.genospace.genospace.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DRUG")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="drug_id")
    private int id;

    @Column(name = "drug_name")
    private String drugName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanism_id")
    private Mechanism mechanism;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "drug")
    private List<NamesCode> namesCodes;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "drug")
    private List<NamesBrand> namesBrands;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "drug")
    private List<NamesGeneric> namesGenerics;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "drug")
    private List<DevelopmentStatusSummaryRow> developmentStatusSummaryRows;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "drug")
    private List<MechanismMolecular> mechanismMoleculars;


    public List<NamesCode> getNamesCodes() {
        return namesCodes;
    }

    public void setNamesCodes(List<NamesCode> namesCodes) {
        this.namesCodes = namesCodes;
    }

    public List<NamesBrand> getNamesBrands() {
        return namesBrands;
    }

    public void setNamesBrands(List<NamesBrand> namesBrands) {
        this.namesBrands = namesBrands;
    }

    public List<NamesGeneric> getNamesGenerics() {
        return namesGenerics;
    }

    public void setNamesGenerics(List<NamesGeneric> namesGenerics) {
        this.namesGenerics = namesGenerics;
    }

    public List<DevelopmentStatusSummaryRow> getDevelopmentStatusSummaryRows() {
        return developmentStatusSummaryRows;
    }

    public void setDevelopmentStatusSummaryRows(List<DevelopmentStatusSummaryRow> developmentStatusSummaryRows) {
        this.developmentStatusSummaryRows = developmentStatusSummaryRows;
    }

    public List<MechanismMolecular> getMechanismMoleculars() {
        return mechanismMoleculars;
    }

    public void setMechanismMoleculars(List<MechanismMolecular> mechanismMoleculars) {
        this.mechanismMoleculars = mechanismMoleculars;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mechanism getMechanism() {
        return mechanism;
    }

    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }
}
