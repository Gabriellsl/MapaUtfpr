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
import com.utf.grw.utfmaps.util.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.*;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Gabriellsl
 */
@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
    //picklist

    private DualListModel<Departamento> deps;
    private DualListModel<Departamento> departamentos2;

    @PostConstruct
    public void init() {  
        
        this.lista = null;
        //Cities
        this.DepartamentoOrigem = new ArrayList<Departamento>();
        this.DepartamentoDestino = new ArrayList<Departamento>();

        this.DepartamentoOrigem2 = new ArrayList<Departamento>();
        this.DepartamentoDestino2 = new ArrayList<Departamento>();

        DepartamentoOrigem = this.getDepartamentos();
        deps = new DualListModel<Departamento>(DepartamentoOrigem, DepartamentoDestino);
        departamentos2 = new DualListModel<Departamento>(DepartamentoOrigem2, DepartamentoDestino2);
    }

    List<Departamento> DepartamentoOrigem;
    List<Departamento> DepartamentoDestino;

    List<Departamento> DepartamentoOrigem2;
    List<Departamento> DepartamentoDestino2;

    private Usuario selecionado = new Usuario();
    private Usuario editado = new Usuario();
    private Usuario usuario = new Usuario();
    private List<Usuario> lista = null;
    private String estadoTela = "buscar";//Inserir, Editar, Buscar

    public void selected() {
        //System.out.println("selecionou !");
        this.editado = this.selecionado;
    }

    public void create() {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        departamentos = this.getDepartamentos();
        System.out.println("Nome da primeira Departamento: " + departamentos.get(0).getNomeDep());
        this.usuario.setDepartamentos(this.deps.getTarget());

        mudarParaBusca();
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.salvar(this.usuario);

        System.out.println(this.usuario.getNome() + " criado com sucesso !");
        this.lista = null;
        this.usuario = new Usuario();
    }

    public void delete() {
        UsuarioRN usuarioRN = new UsuarioRN();
        try {
            usuarioRN.excluir(this.selecionado);
        } catch (Error e) {
            Logger.save(this.getClass(), e.getMessage());
            System.out.println("Houve um erro ao excluir um Usuario: " + e);
        }
        this.lista = null;
    }

    public void update() {
        
        this.selecionado.setDepartamentos(this.getdepartamentos2().getTarget());
        //mudarParaEdita();
        UsuarioRN usuarioRN = new UsuarioRN();
        usuarioRN.atualizar(this.selecionado);
        System.out.println(this.selecionado.getNome() + " alterado com sucesso !" + " ID: " + this.selecionado.getIdUsuario());
        this.lista = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public List<Usuario> getAllUsuarios() {
        if (isBusca() == false) {
            mudarParaBusca();
        }
        if (this.lista == null) {
            UsuarioRN usuarioRN = new UsuarioRN();
            this.lista = usuarioRN.listar();
        }
        return this.lista;
    }

    public List<Departamento> getDepartamentos() {
        DepartamentoRN departamentoRN = new DepartamentoRN();
        return departamentoRN.listar();
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Usuario selecionado) {
        this.selecionado = selecionado;
    }

    public Usuario getEditado() {
        return editado;
    }

    public void setEditado(Usuario editado) {
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
        /*System.out.println("usuario: "+this.selecionado.getNome()+" - codigo "+this.selecionado+"\n Departamentos: ");
        for (Departamento departamento : this.selecionado.getDepartamentos()) {
            System.out.println(departamento.getNomeDep() + " - codigo: "+departamento);
        }
        */
        UsuarioRN usuarioRN = new UsuarioRN();
        this.selecionado = usuarioRN.refresh(this.selecionado);
        
        this.DepartamentoOrigem2 = this.getDepartamentos();
        this.setDepartamentoDestino2(this.selecionado.getDepartamentos());
        for (Departamento departamento : this.selecionado.getDepartamentos()) {
            this.DepartamentoOrigem2.remove(departamento);
        }
        this.departamentos2.setSource(this.DepartamentoOrigem2);
        this.departamentos2.setTarget(this.DepartamentoDestino2);
        estadoTela = "editar";
    }

    public void mudarParaBusca() {
        estadoTela = "buscar";
    }

    public DualListModel<Departamento> getDeps() {
        return deps;
    }

    public void setDeps(DualListModel<Departamento> deps) {
        this.deps = deps;
    }

    public List<Departamento> getDepartamentoOrigem() {
        return DepartamentoOrigem;
    }

    public void setDepartamentoOrigem(List<Departamento> DepartamentoOrigem) {
        this.DepartamentoOrigem = DepartamentoOrigem;
    }

    public List<Departamento> getDepartamentoDestino() {
        return DepartamentoDestino;
    }

    public void setDepartamentoDestino(List<Departamento> DepartamentoDestino) {
        this.DepartamentoDestino = DepartamentoDestino;
    }

    public DualListModel<Departamento> getdepartamentos2() {
        return this.departamentos2;
    }

    public void setdepartamentos2(DualListModel<Departamento> deps2) {
        this.departamentos2 = deps2;
    }

    public List<Departamento> getDepartamentoOrigem2() {
        return DepartamentoOrigem2;
    }

    public void setDepartamentoOrigem2(List<Departamento> DepartamentoOrigem2) {
        this.DepartamentoOrigem2 = DepartamentoOrigem2;
    }

    public List<Departamento> getDepartamentoDestino2() {
        return DepartamentoDestino2;
    }

    public void setDepartamentoDestino2(List<Departamento> DepartamentoDestino2) {
        this.DepartamentoDestino2 = DepartamentoDestino2;
    }

}
