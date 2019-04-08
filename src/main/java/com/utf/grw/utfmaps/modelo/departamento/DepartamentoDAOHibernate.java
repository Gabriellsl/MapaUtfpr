package com.utf.grw.utfmaps.modelo.departamento;

import com.utf.grw.utfmaps.util.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ALUNO
 */
public class DepartamentoDAOHibernate implements DepartamentoDAO {

    EntityManager manager;

    public DepartamentoDAOHibernate() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(Departamento departamento) {
        this.manager.getTransaction().begin();
        this.manager.persist(departamento);
        this.manager.getTransaction().commit();
    }

    @Override
    public void atualizar(Departamento departamento) {
        this.manager.getTransaction().begin();
        this.manager.merge(departamento);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(Departamento departamento) {
        this.manager.getTransaction().begin();
        this.manager.remove(departamento);
        this.manager.getTransaction().commit();
    }

    @Override
    public Departamento carregar(Integer codigo) {
        Departamento departamento = manager.getReference(Departamento.class, codigo);
        return departamento;
    }

    @Override
    public Departamento buscarPorId(Long codigo) {
        Departamento departamento = manager.find(Departamento.class, codigo);
        return departamento;
    }

    @Override
    public List<Departamento> listar() {
        /*Query q = manager.createQuery("SELECT p FROM Departamento p");
        List<Departamento> departamentoes = q.getResultList();*/
        
        Query query = manager.createNamedQuery("Departamento.findAll");
        List<Departamento> departamentos = query.getResultList();
        return departamentos;
    }
    
    //ESTE VAI USAAAARRR
    @Override
    public Departamento buscarPorNome(String nomeDep) {
        String jpql = "SELECT d FROM Departamento d WHERE d.nomeDep = ?1";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, nomeDep);
        Departamento departamento = (Departamento)query.getSingleResult();
        return departamento;
    }
    
}
