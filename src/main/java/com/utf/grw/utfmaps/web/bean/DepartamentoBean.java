/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.departamento.DepartamentoRN;
import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.*;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Gabriellsl
 */
@ManagedBean(name = "departamentoBean")
@RequestScoped
public class DepartamentoBean {

    //picklist
    private DualListModel<Usuario> usus;
    private DualListModel<Usuario> usus2;

    @PostConstruct
    public void init() {
        
        this.lista = null;
        //Cities
        this.UsuarioOrigem = new ArrayList<Usuario>();
        this.UsuarioDestino = new ArrayList<Usuario>();

        this.UsuarioOrigem2 = new ArrayList<Usuario>();
        this.UsuarioDestino2 = new ArrayList<Usuario>();

        UsuarioOrigem = this.getUsuarios();
        usus = new DualListModel<Usuario>(UsuarioOrigem, UsuarioDestino);
        usus2 = new DualListModel<Usuario>(UsuarioOrigem2, UsuarioDestino2);

    }

    List<Usuario> UsuarioOrigem;
    List<Usuario> UsuarioDestino;

    List<Usuario> UsuarioOrigem2;
    List<Usuario> UsuarioDestino2;

    private Departamento selecionado = new Departamento();
    private Departamento editado = new Departamento();
    private Departamento departamento = new Departamento();
    private List<Departamento> lista = null;
    private String estadoTela = "buscar";//Inserir, Editar, Buscar

    public void selected() {
        //System.out.println("selecionou !");
        this.editado = this.selecionado;
        //System.out.println("$$$$   "+this.editado.getNomeDep()+" id "+this.editado.getIdDepartamento()+"   id selecionado: "+this.selecionado.getIdDepartamento());
    }

    public void create() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios = this.getUsuarios();
        this.departamento.setUsuarios(this.usus.getTarget());
        
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

    public void update() {
        
        this.selecionado.setUsuarios(this.getUsus2().getTarget());
        //mudarParaEdita();
        DepartamentoRN departamentoRN = new DepartamentoRN();
        departamentoRN.atualizar(this.selecionado);
        System.out.println(this.selecionado.getNomeDep() + " alterado com sucesso !" + " ID: " + this.selecionado.getIdDepartamento());
        this.lista = null;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getAll() {
        if (isBusca() == false) {
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
    public boolean isInseri() {
        return "inserir".equals(estadoTela);
    }

    public boolean isEdita() {
        return "editar".equals(estadoTela);
    }

    public boolean isBusca() {
        return "buscar".equals(estadoTela);
    }

    public void mudarParaInseri() {
        estadoTela = "inserir";
    }

    public void mudarParaEdita() {
        
        DepartamentoRN departamentoRN = new DepartamentoRN();
        this.selecionado = departamentoRN.refresh(this.selecionado);
        
        this.UsuarioOrigem2 = this.getUsuarios();
        this.setUsuarioDestino2(this.selecionado.getUsuarios());
        for (Usuario usuario : this.selecionado.getUsuarios()) {
            this.UsuarioOrigem2.remove(usuario);
        }
        this.usus2.setSource(this.UsuarioOrigem2);
        this.usus2.setTarget(this.UsuarioDestino2);
        estadoTela = "editar";
    }

    public void mudarParaBusca() {
        estadoTela = "buscar";
    }

    public List<Usuario> getUsuarios() {
        UsuarioRN usuarioRN = new UsuarioRN();
        return usuarioRN.listar();
    }

    public DualListModel<Usuario> getUsus() {
        return usus;
    }

    public void setUsus(DualListModel<Usuario> usus) {
        this.usus = usus;
    }

    public DualListModel<Usuario> getUsus2() {
        return usus2;
    }

    public void setUsus2(DualListModel<Usuario> usus2) {
        this.usus2 = usus2;
    }

    public List<Usuario> getUsuarioOrigem() {
        return UsuarioOrigem;
    }

    public void setUsuarioOrigem(List<Usuario> UsuarioOrigem) {
        this.UsuarioOrigem = UsuarioOrigem;
    }

    public List<Usuario> getUsuarioDestino() {
        return UsuarioDestino;
    }

    public void setUsuarioDestino(List<Usuario> UsuarioDestino) {
        this.UsuarioDestino = UsuarioDestino;
    }

    public List<Usuario> getUsuarioOrigem2() {
        return UsuarioOrigem2;
    }

    public void setUsuarioOrigem2(List<Usuario> UsuarioOrigem2) {
        this.UsuarioOrigem2 = UsuarioOrigem2;
    }

    public List<Usuario> getUsuarioDestino2() {
        return UsuarioDestino2;
    }

    public void setUsuarioDestino2(List<Usuario> UsuarioDestino2) {
        this.UsuarioDestino2 = UsuarioDestino2;
    }

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }
    
    

}
