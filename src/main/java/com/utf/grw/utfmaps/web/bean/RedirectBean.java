/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.departamento.DepartamentoRN;
import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
import com.utf.grw.utfmaps.util.Logger;
import com.utf.grw.utfmaps.util.UserContext;

/**
 *
 * @author Boniolo
 */

@ManagedBean(name = "redirectBean")
@RequestScoped
public class RedirectBean {
    

    @PostConstruct
    public void init() {

        // System.out.println(UserContext.getUserContext().getNome());


        // Usuario usuario = UserContext.getUserContext();
        
        DepartamentoRN deprn =  new DepartamentoRN();

        List<Departamento> dep = deprn.listar();

        for (Departamento u : dep) {
            System.out.println(u.getNomeDep());
        }

        // if(usuario == null) return;
        // String path = this.path(usuario);
        // this.redirectTo("/root/departamento.xhtml");
    }


    private void redirectTo(String path) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(path);
        } catch (IOException e) {
            Logger.save(this.getClass(), e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    private String path(Usuario usuario){
        if(usuario.getLogin().equals("root"))
            return "/root/departamento.xhtml";
        else return "/private/departamento.xhtml"; 
    }

    
    
}
