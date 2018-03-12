package com.genospace.genospace.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Drug.class)
public abstract class Drug_ {

	public static volatile ListAttribute<Drug, NamesGeneric> namesGenerics;
	public static volatile ListAttribute<Drug, NamesBrand> namesBrands;
	public static volatile SingularAttribute<Drug, String> drugName;
	public static volatile SingularAttribute<Drug, Integer> id;
	public static volatile SingularAttribute<Drug, Mechanism> mechanism;
	public static volatile ListAttribute<Drug, NamesCode> namesCodes;
	public static volatile ListAttribute<Drug, DevelopmentStatusSummaryRow> developmentStatusSummaryRows;
	public static volatile ListAttribute<Drug, MechanismMolecular> mechanismMoleculars;

}

