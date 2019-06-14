/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.modelo.usuario;

import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.util.ConexaoHibernate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author a1808052
 */
public class UsuarioDAOHibernate implements UsuarioDAO {

   EntityManager manager;

    public UsuarioDAOHibernate() {     
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(Usuario usuario) {
        this.manager.getTransaction().begin();
        this.manager.persist(usuario);
        this.manager.getTransaction().commit();
    }

    @Override
    public void atualizar(Usuario usuario) {
        this.manager.getTransaction().begin();
        this.manager.merge(usuario);
        this.manager.getTransaction().commit();
    }

    @Override
    public void excluir(Usuario usuario) {
        this.manager.getTransaction().begin();
        this.manager.remove(usuario);
        this.manager.getTransaction().commit();
    }

    @Override
    public Usuario carregar(Integer codigo) {
        Usuario usuario = manager.getReference(Usuario.class, codigo);
        return usuario;
    }

    @Override
    public Usuario buscarPorId(Long codigo) {
        Usuario usuario = new Usuario();
        try{
            usuario = manager.find(Usuario.class, codigo);
        }catch(Exception e){
            usuario = new Usuario();
        }finally{
            return usuario;
        }
        
    }

    @Override
    public List<Usuario> listar() {
        /*Query q = manager.createQuery("SELECT p FROM Usuario p");
        List<Usuario> Usuarioes = q.getResultList();*/
        
        Query query = manager.createNamedQuery("Usuario.findAll");
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
    
    @Override
    public Usuario buscarPorLogin(String nome) {
        String jpql = "SELECT s FROM Usuario s WHERE USU_LOGIN = ?1";
        Query query = manager.createQuery(jpql);
        query.setParameter(1, nome);
        System.out.println(query.getSingleResult());

        Usuario usuario = (Usuario) query.getSingleResult();
        return usuario;
    }
    
    @Override
    public Usuario refresh(Usuario usuario){
        manager.refresh(usuario);
        return usuario;
    }
    
}
