package com.utf.grw.utfmaps.modelo.departamento;

import com.utf.grw.utfmaps.util.Logger;
import java.util.List;


public class DepartamentoRN {
    
    private DepartamentoDAO departamentoDAO;
    
    public DepartamentoRN(){
        this.departamentoDAO = new DepartamentoDAOHibernate();
    }
    
    public void salvar(Departamento departamento) {
        try {
            this.departamentoDAO.salvar(departamento);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    
    public void atualizar(Departamento departamento){
        try {
            this.departamentoDAO.atualizar(departamento);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Departamento departamento){
        try {
            this.departamentoDAO.excluir(departamento);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
    }
    
    public Departamento buscar(String nomeDep){
        try {
            return this.departamentoDAO.buscarPorNome(nomeDep);
        } catch (Exception ex) {
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Departamento> listar(){
        try{
            return this.departamentoDAO.listar();
        }catch(Exception ex){
            Logger.save(this.getClass(), ex.getMessage());
            System.err.println(ex.getMessage());
        }
        return null;
        
        
    }
    
}
