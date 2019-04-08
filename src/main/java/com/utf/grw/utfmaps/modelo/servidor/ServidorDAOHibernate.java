package com.utf.grw.utfmaps.modelo.servidor;

import com.utf.grw.utfmaps.util.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Geovani José
 */
public class ServidorDAOHibernate implements ServidorDAO {
    
    EntityManager manager;

    public ServidorDAOHibernate() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(Servidor servidor) {
        this.manager.getTransaction().begin();
        this.manager.persist(servidor);
        this.manager.getTransaction().commit();
    }

    @Override
    public void atualizar(Servidor servidor) {
        this.manager.getTransaction().begin();
        this.manager.merge(servidor);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(Servidor servidor) {
        this.manager.getTransaction().begin();
        this.manager.remove(servidor);
        this.manager.getTransaction().commit();
    }

    @Override
    public Servidor carregar(Integer codigo) {
        Servidor servidor = manager.getReference(Servidor.class, codigo);
        return servidor;
    }

    @Override
    public Servidor buscarPorId(Long codigo) {
        Servidor servidor = manager.find(Servidor.class, codigo);
        return servidor;
    }

    @Override
    public List<Servidor> listar() {
        /*Query q = manager.createQuery("SELECT p FROM Servidor p");
        List<Servidor> servidores = q.getResultList();*/
        
        Query query = manager.createNamedQuery("Servidor.findAll");
        List<Servidor> servidores = query.getResultList();
        return servidores;
    }
    
    @Override
    public Servidor buscarPorLogin(String login) {
        String jpql = "SELECT s FROM Servidor s WHERE s.login = ?1";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, login);
        Servidor departamento = (Servidor)query.getSingleResult();
        return departamento;
    }
    
}
