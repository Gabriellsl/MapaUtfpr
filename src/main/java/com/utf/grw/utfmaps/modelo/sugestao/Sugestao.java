package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sugestao {
    @Id
    @GeneratedValue
    @Column(name="SUG_ID")
    private Long idServidor;
    
    @Column(name="SUG_DESC")
    private String sugestao;
    
    @Column(name="SUG_NOME")
    private String nome;
    
    @ManyToOne
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