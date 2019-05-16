package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;

public class Sugestao {
    private Long idServidor;
    
    private String sugestao;
    
    private String nome;
    
    private Departamento dep;

    public Sugestao(String sugestao, String nome, Departamento dep) {
        this.sugestao = sugestao;
        this.nome = nome;
        this.dep = dep;
    }

    public Long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Long idServidor) {
        this.idServidor = idServidor;
    }

    public String getSugestao() {
        return sugestao;
    }

    public void setSugestao(String sugestao) {
        this.sugestao = sugestao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }
    
}