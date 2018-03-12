package com.genospace.genospace.models;

import javax.persistence.*;

@Entity
@Table(name = "Administration_Route")
public class AdministrationRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "route_id")
    private int id;

    @Column(name = "administrative_route_name")
    private String administrativeRouteName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    private DevelopmentStatusSummaryRow developmentStatusSummaryRow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdministrativeRouteName() {
        return administrativeRouteName;
    }

    public void setAdministrativeRouteName(String administrativeRouteName) {
        this.administrativeRouteName = administrativeRouteName;
    }
}
