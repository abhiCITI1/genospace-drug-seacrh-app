package com.genospace.genospace.models;

import javax.persistence.*;

@Entity
@Table(name = "Names_Brand")
public class NamesBrand {

    @Id
    @Column(name = "name_brand_id")
    private int id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }



}
