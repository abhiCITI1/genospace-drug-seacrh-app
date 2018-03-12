package com.genospace.genospace.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mechanism.class)
public abstract class Mechanism_ {

	public static volatile SingularAttribute<Mechanism, String> mechanismName;
	public static volatile ListAttribute<Mechanism, Drug> drugs;
	public static volatile SingularAttribute<Mechanism, Integer> id;

}

