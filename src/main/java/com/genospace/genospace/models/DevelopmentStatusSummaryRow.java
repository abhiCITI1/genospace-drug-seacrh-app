package com.genospace.genospace.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Development_Status_Summary_Row")
public class DevelopmentStatusSummaryRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "condition_id")
    private int id;

    @Column(name = "condition_name")
    private String conditionName;

    @Column(name = "phase_highest")
    private String phaseHighest;

    @Column(name ="condition_active")
    private boolean conditionInActiveDevelopment;

    private int year;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "developmentStatusSummaryRow")
    private List<Organization> organizations;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "developmentStatusSummaryRow")
    private List<AdministrationRoute> administrationRoutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getPhaseHighest() {
        return phaseHighest;
    }

    public void setPhaseHighest(String phaseHighest) {
        this.phaseHighest = phaseHighest;
    }

    public boolean isConditionInActiveDevelopment() {
        return conditionInActiveDevelopment;
    }

    public void setConditionInActiveDevelopment(boolean conditionInActiveDevelopment) {
        this.conditionInActiveDevelopment = conditionInActiveDevelopment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<AdministrationRoute> getAdministrationRoutes() {
        return administrationRoutes;
    }

    public void setAdministrationRoutes(List<AdministrationRoute> administrationRoutes) {
        this.administrationRoutes = administrationRoutes;
    }
}
