package com.utf.grw.utfmaps.modelo.permissao;

import com.utf.grw.utfmaps.util.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ALUNO
 */
public class PermissaoDAOHibernate implements PermissaoDAO {

    EntityManager manager;

    public PermissaoDAOHibernate() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(Permissao permissao) {
        this.manager.getTransaction().begin();
        this.manager.persist(permissao);
        this.manager.getTransaction().commit();
    }

    @Override
    public void atualizar(Permissao permissao) {
        this.manager.getTransaction().begin();
        this.manager.merge(permissao);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(Permissao permissao) {
        this.manager.getTransaction().begin();
        this.manager.remove(permissao);
        this.manager.getTransaction().commit();
    }

    @Override
    public Permissao carregar(Integer codigo) {
        Permissao permissao = manager.getReference(Permissao.class, codigo);
        return permissao;
    }

    @Override
    public Permissao buscarPorId(Long codigo) {
        Permissao permissao = manager.find(Permissao.class, codigo);
        return permissao;
    }

    @Override
    public List<Permissao> listar() {
        /*Query q = manager.createQuery("SELECT p FROM Permissao p");
        List<Permissao> Permissaoes = q.getResultList();*/
        
        Query query = manager.createNamedQuery("Permissao.findAll");
        List<Permissao> permissoes = query.getResultList();
        return permissoes;
    }
    
    //ESTE VAI USAAAARRR
    @Override
    public Permissao buscarPorNome(String nomePer) {
        String jpql = "SELECT s FROM Permissao s WHERE s.nomePer = ?1";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, nomePer);
        Permissao permissao = (Permissao)query.getSingleResult();
        return permissao;
    }
    
}
