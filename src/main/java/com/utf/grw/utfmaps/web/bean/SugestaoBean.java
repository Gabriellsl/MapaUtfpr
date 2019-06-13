/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import com.utf.grw.utfmaps.modelo.sugestao.SugestaoRN;

/**
 *
 * @author a1808338
 */

@ManagedBean(name = "sugestaoBean")
@RequestScoped
public class SugestaoBean {
    
    Sugestao sugestao;
    
    @PostConstruct
    public void init() {
        System.out.println("*********************************************************************************");

        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        System.out.println("*********************************************************************************");
        
        this.sugestao  = new Sugestao();
    }
    
    public void salvar(){
        SugestaoRN sugestaoRN = new SugestaoRN();
        System.out.println("a descrição é:  "+this.sugestao.getSugestao());
        sugestaoRN.salvar(this.sugestao);
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }
    
    
}
