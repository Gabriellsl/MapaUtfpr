package com.utf.grw.utfmaps.modelo.permissao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Gabriel
 */

@Entity
@NamedQuery(name="Permissao.findAll", query="SELECT p FROM Permissao p")
public class Permissao {
    @Id
    @GeneratedValue
    @Column(name="PER_ID")
    private Long idPermissao;
    @Column(name="PER_NOME")
    private String nomePer;
    
    

    
    public Permissao() {
    }

    public Long getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Long idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getNomePer() {
        return nomePer;
    }

    public void setNomePer(String nomePer) {
        this.nomePer = nomePer;
    }


    
}