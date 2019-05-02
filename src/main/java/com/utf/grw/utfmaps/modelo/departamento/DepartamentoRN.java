package com.utf.grw.utfmaps.modelo.departamento;

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
            System.err.println(ex.getMessage());
        }
    }
    
    
    public void atualizar(Departamento departamento){
        try {
            this.departamentoDAO.atualizar(departamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Departamento departamento){
        try {
            this.departamentoDAO.excluir(departamento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Departamento buscar(String nomeDep){
        try {
            return this.departamentoDAO.buscarPorNome(nomeDep);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public List<Departamento> listar(){
        return this.departamentoDAO.listar();
    }
    
        public Departamento refresh(Departamento selecionado) {
         return this.departamentoDAO.refresh(selecionado);
    }
    
}
