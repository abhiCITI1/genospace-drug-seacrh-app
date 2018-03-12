package com.genospace.genospace.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "MECHANISM")
public class Mechanism {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="mechanism_id")
    private int id;


    @Column(name = "mechanism_name")
    private String mechanismName;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "mechanism")
    private List<Drug> drugs;


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


    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
