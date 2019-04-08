package com.utf.grw.utfmaps.modelo.servidor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Geovani José
 */
@Entity
@NamedQuery(name="Servidor.findAll", query="SELECT s FROM Servidor s")
public class Servidor {
    @Id
    @GeneratedValue
    @Column(name="SER_ID")
    private Long idServidor;
    @Column(name="SER_LOGIN")
    private String login;
    @Column(name="SER_SENHA")
    private String senha;
    @Column(name="SER_NOME")
    private String nome;
    @Column(name="SER_RA")
    private long ra;
    @Column(name="SER_SETOR")
    private String setor;

    public Servidor(String login, String senha, String nome, long ra, String setor) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.ra = ra;
        this.setor = setor;
    }

    public Long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(Long idServidor) {
        this.idServidor = idServidor;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getRa() {
        return ra;
    }

    public void setRa(long ra) {
        this.ra = ra;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
}
