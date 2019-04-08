package com.utf.grw.utfmaps.controle;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.departamento.DepartamentoRN;


public class DepartamentoControle {
    
    private DepartamentoRN departamentoRN;
    
    public DepartamentoControle() {
        this.departamentoRN = new DepartamentoRN();
    }
    
    public void salvarDepartamento(Departamento departamento) {
        departamentoRN.salvar(departamento);
    }
    
    public void atualizarDepartamento(Departamento departamento) {
        departamentoRN.atualizar(departamento);
    }
    
    public void excluirDepartamento(Departamento departamento) {
        departamentoRN.excluir(departamento);
    }
    
    public Departamento buscarDepartamento(String nomeDep) {
        return departamentoRN.buscar(nomeDep);
    }
    
}
