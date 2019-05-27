
package com.utf.grw.utfmaps.modelo.usuario;

import com.utf.grw.utfmaps.modelo.permissao.Permissao;
import com.utf.grw.utfmaps.util.Logger;
import java.util.List;




public class UsuarioRN {
    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = new UsuarioDAOHibernate();
    }
    
    public void salvar(Usuario usuario) {
        try {
            this.usuarioDAO.salvar(usuario);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public void atualizar(Usuario usuario){
        try {
            this.usuarioDAO.atualizar(usuario);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Usuario usuario){
        try {
            this.usuarioDAO.excluir(usuario);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public Usuario buscar(Long codigo){
        try {
            return this.usuarioDAO.buscarPorId(codigo);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public Usuario buscar(String login){
        try {
            return this.usuarioDAO.buscarPorLogin(login);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Usuario> listar(){
        try{    
            return this.usuarioDAO.listar();
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
