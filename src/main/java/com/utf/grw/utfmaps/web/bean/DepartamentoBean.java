/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.departamento.DepartamentoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.*;

/**
 *
 * @author Gabriellsl
 */
@ManagedBean(name = "departamentoBean")
@RequestScoped
public class DepartamentoBean {

    private Departamento selecionado = new Departamento();
    private Departamento editado = new Departamento();
    private Departamento departamento = new Departamento();
    private List<Departamento> lista = null;
    private String estadoTela = "buscar";//Inserir, Editar, Buscar
    
    public void selected(){
        //System.out.println("selecionou !");
        this.editado = this.selecionado;
        //System.out.println("$$$$   "+this.editado.getNomeDep()+" id "+this.editado.getIdDepartamento()+"   id selecionado: "+this.selecionado.getIdDepartamento());
    }
    
    public void create() {
        mudarParaBusca();
        DepartamentoRN departamentoRN = new DepartamentoRN();
        departamentoRN.salvar(this.departamento);

        System.out.println(this.departamento.getNomeDep() + " criado com sucesso !");
        this.lista = null;
        this.departamento = new Departamento();
    }

    public void delete() {
        DepartamentoRN departamentoRN = new DepartamentoRN();
        try {
            departamentoRN.excluir(this.selecionado);
        } catch (Error e) {
            System.out.println("Houve um erro ao excluir um departamento: " + e);
        }
        this.lista = null;
    }
    
    public void update(){
        mudarParaEdita();
        DepartamentoRN departamentoRN = new DepartamentoRN();
        departamentoRN.atualizar(this.selecionado);
        System.out.println(this.selecionado.getNomeDep() + " alterado com sucesso !"+" ID: "+this.selecionado.getIdDepartamento());
        this.lista = null;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }



    public List<Departamento> getAll() {
         if(isBusca() == false){
           mudarParaBusca();
        }
        if (this.lista == null) {
            DepartamentoRN departamentoRN = new DepartamentoRN();
            this.lista = departamentoRN.listar();
        }
        return this.lista;
    }

    public void setLista(List<Departamento> lista) {
        this.lista = lista;
    }

    public Departamento getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Departamento selecionado) {
        this.selecionado = selecionado;
    }

    public Departamento getEditado() {
        return editado;
    }

    public void setEditado(Departamento editado) {
        this.editado = editado;
    }
    
    //Metodos para controle da tela
    public boolean isInseri(){
        return "inserir".equals(estadoTela);
    }
    public boolean isEdita(){
        return "editar".equals(estadoTela);
    }
    public boolean isBusca(){
        return "buscar".equals(estadoTela);
    }
    public void mudarParaInseri(){
        estadoTela = "inserir";
    }
    public void mudarParaEdita(){
        estadoTela = "editar";
    }
    public void mudarParaBusca(){
        estadoTela = "buscar";
    }
    

    
}
