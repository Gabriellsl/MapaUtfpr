/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import com.utf.grw.utfmaps.modelo.permissao.Permissao;
import com.utf.grw.utfmaps.modelo.permissao.PermissaoRN;
import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
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

    private DualListModel<Permissao> perms;
    private DualListModel<Permissao> perms2;

    @PostConstruct
    public void init() {
        //Cities
        this.PermissaoOrigem = new ArrayList<Permissao>();
        this.PermissaoDestino = new ArrayList<Permissao>();

        this.PermissaoOrigem2 = new ArrayList<Permissao>();
        this.PermissaoDestino2 = new ArrayList<Permissao>();

        PermissaoOrigem = this.getPermissoes();
        perms = new DualListModel<Permissao>(PermissaoOrigem, PermissaoDestino);
        perms2 = new DualListModel<Permissao>(PermissaoOrigem2, PermissaoDestino2);
    }

    List<Permissao> PermissaoOrigem;
    List<Permissao> PermissaoDestino;

    List<Permissao> PermissaoOrigem2;
    List<Permissao> PermissaoDestino2;

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
        List<Permissao> permissoes = new ArrayList<Permissao>();
        permissoes = this.getPermissoes();
        System.out.println("Nome da primeira permissao: " + permissoes.get(0).getNomePer());
        this.usuario.setPermissoes(this.perms.getTarget());

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
            System.out.println("Houve um erro ao excluir um Usuario: " + e);
        }
        this.lista = null;
    }

    public void update() {
        
        this.selecionado.setPermissoes(this.perms2.getTarget());
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

    public List<Permissao> getPermissoes() {
        PermissaoRN permissaoRN = new PermissaoRN();
        return permissaoRN.listar();
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
        this.PermissaoOrigem2 = this.getPermissoes();
        this.PermissaoDestino2 = this.selecionado.getPermissoes();
        for (Permissao permissao : this.selecionado.getPermissoes()) {
            this.PermissaoOrigem2.remove(permissao);
        }
        this.perms2 = new DualListModel<Permissao>(this.PermissaoOrigem2, this.PermissaoDestino2);
        estadoTela = "editar";
    }

    public void mudarParaBusca() {
        estadoTela = "buscar";
    }

    public DualListModel<Permissao> getPerms() {
        return perms;
    }

    public void setPerms(DualListModel<Permissao> perms) {
        this.perms = perms;
    }

    public List<Permissao> getPermissaoOrigem() {
        return PermissaoOrigem;
    }

    public void setPermissaoOrigem(List<Permissao> PermissaoOrigem) {
        this.PermissaoOrigem = PermissaoOrigem;
    }

    public List<Permissao> getPermissaoDestino() {
        return PermissaoDestino;
    }

    public void setPermissaoDestino(List<Permissao> PermissaoDestino) {
        this.PermissaoDestino = PermissaoDestino;
    }

    public DualListModel<Permissao> getPerms2() {
        return perms2;
    }

    public void setPerms2(DualListModel<Permissao> perms2) {
        this.perms2 = perms2;
    }

    public List<Permissao> getPermissaoOrigem2() {
        return PermissaoOrigem2;
    }

    public void setPermissaoOrigem2(List<Permissao> PermissaoOrigem2) {
        this.PermissaoOrigem2 = PermissaoOrigem2;
    }

    public List<Permissao> getPermissaoDestino2() {
        return PermissaoDestino2;
    }

    public void setPermissaoDestino2(List<Permissao> PermissaoDestino2) {
        this.PermissaoDestino2 = PermissaoDestino2;
    }

}
