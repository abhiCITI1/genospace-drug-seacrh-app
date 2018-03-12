package com.genospace.genospace.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DevelopmentStatusSummaryRow.class)
public abstract class DevelopmentStatusSummaryRow_ {

	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, Boolean> conditionInActiveDevelopment;
	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, Integer> year;
	public static volatile ListAttribute<DevelopmentStatusSummaryRow, Organization> organizations;
	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, String> conditionName;
	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, String> phaseHighest;
	public static volatile ListAttribute<DevelopmentStatusSummaryRow, AdministrationRoute> administrationRoutes;
	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, Integer> id;
	public static volatile SingularAttribute<DevelopmentStatusSummaryRow, Drug> drug;

}

