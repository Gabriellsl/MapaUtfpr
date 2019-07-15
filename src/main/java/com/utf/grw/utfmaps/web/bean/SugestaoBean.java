/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.web.bean;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import com.utf.grw.utfmaps.modelo.sugestao.SugestaoRN;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
        this.sugestao  = new Sugestao();
    }
    
    public void salvar(){
        SugestaoRN sugestaoRN = new SugestaoRN();
        sugestaoRN.salvar(this.sugestao);
    }

    public Sugestao getSugestao() {
        return sugestao;
    }

    public void setSugestao(Sugestao sugestao) {
        this.sugestao = sugestao;
    }
    
    
}
