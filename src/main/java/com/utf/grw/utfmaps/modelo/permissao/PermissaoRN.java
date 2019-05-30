package com.utf.grw.utfmaps.modelo.permissao;

import com.utf.grw.utfmaps.util.Logger;
import java.util.List;


public class PermissaoRN {
    
    private PermissaoDAO PermissaoDAO;
    
    public PermissaoRN(){
        this.PermissaoDAO = new PermissaoDAOHibernate();
    }
    
    public void salvar(Permissao permissao) {
        try {
            this.PermissaoDAO.salvar(permissao);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    
    public void atualizar(Permissao permissao){
        try {
            this.PermissaoDAO.atualizar(permissao);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Permissao permissao){
        try {
            this.PermissaoDAO.excluir(permissao);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public Permissao buscar(String nomePer){
        try {
            return this.PermissaoDAO.buscarPorNome(nomePer);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Permissao> listar(){
        try{
            return this.PermissaoDAO.listar();
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
}
