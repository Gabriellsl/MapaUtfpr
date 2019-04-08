package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sugestao.class)
public abstract class Sugestao_ {

	public static volatile SingularAttribute<Sugestao, Long> idServidor;
	public static volatile SingularAttribute<Sugestao, String> sugestao;
	public static volatile SingularAttribute<Sugestao, String> nome;
	public static volatile SingularAttribute<Sugestao, Departamento> dep;

}

