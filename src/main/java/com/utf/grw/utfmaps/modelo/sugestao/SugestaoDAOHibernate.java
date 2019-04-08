package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.util.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SugestaoDAOHibernate implements SugestaoDAO {
    
    EntityManager manager;

    public SugestaoDAOHibernate() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(Sugestao sugestao) {
        this.manager.getTransaction().begin();
        this.manager.persist(sugestao);
        this.manager.getTransaction().commit();
    }

    @Override
    public void atualizar(Sugestao sugestao) {
        this.manager.getTransaction().begin();
        this.manager.merge(sugestao);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(Sugestao sugestao) {
        this.manager.getTransaction().begin();
        this.manager.remove(sugestao);
        this.manager.getTransaction().commit();
    }

    @Override
    public Sugestao carregar(Integer codigo) {
        Sugestao sugestao = manager.getReference(Sugestao.class, codigo);
        return sugestao;
    }

    @Override
    public Sugestao buscarPorId(Long codigo) {
        Sugestao sugestao = manager.find(Sugestao.class, codigo);
        return sugestao;
    }

    @Override
    public List<Sugestao> listar() {
        /*Query q = manager.createQuery("SELECT p FROM Sugestao p");
        List<Sugestao> sugestaoes = q.getResultList();*/
        
        Query query = manager.createNamedQuery("Sugestao.findAll");
        List<Sugestao> sugestoes = query.getResultList();
        return sugestoes;
    }
    
    @Override
    public Sugestao buscarPorLogin(String nome) {
        String jpql = "SELECT s FROM Sugestao s WHERE s.nome = ?1";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, nome);
        Sugestao departamento = (Sugestao)query.getSingleResult();
        return departamento;
    }
    
}
