package com.genospace.genospace.models;

import javax.persistence.*;

@Entity
@Table(name = "Organization")
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "organization_id")
    private int id;

    @Column(name = "organization_name")
    private String organizationName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condition_id")
    private DevelopmentStatusSummaryRow developmentStatusSummaryRow;

    public DevelopmentStatusSummaryRow getDevelopmentStatusSummaryRow() {
        return developmentStatusSummaryRow;
    }

    public void setDevelopmentStatusSummaryRow(DevelopmentStatusSummaryRow developmentStatusSummaryRow) {
        this.developmentStatusSummaryRow = developmentStatusSummaryRow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
