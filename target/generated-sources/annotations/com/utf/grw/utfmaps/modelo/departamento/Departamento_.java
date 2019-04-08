package com.utf.grw.utfmaps.modelo.departamento;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, String> nomeDep;
	public static volatile SingularAttribute<Departamento, Long> idDepartamento;
	public static volatile ListAttribute<Departamento, Sugestao> sugestoes;
	public static volatile SingularAttribute<Departamento, String> horaFecha;
	public static volatile SingularAttribute<Departamento, Integer> indice;
	public static volatile SingularAttribute<Departamento, String> nomeDepExt;
	public static volatile SingularAttribute<Departamento, String> horaAbre;
	public static volatile SingularAttribute<Departamento, String> responsavel;
	public static volatile SingularAttribute<Departamento, String> descricao;

}

