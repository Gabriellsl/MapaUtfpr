package com.utf.grw.utfmaps.modelo.usuario;

import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.permissao.Permissao;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "USU_ID")
    private Long idUsuario;

    @Column(name = "USU_NOME")
    private String nome;

    @Column(name = "USU_LOGIN")
    private String login;

    @Column(name = "USU_SENHA")
    private String senha;

    @Column(name = "USU_ATIVO")
    private Boolean ativo;

//    @ManyToMany(targetEntity = Permissao.class);
//    @JoinTable(name = "Usuario_Permissao", joinColumns = { @JoinColumn(name = "") })
//    public List<Usuario_Permissao> usuario_permissao;
    @ManyToMany(targetEntity = Departamento.class)
    @JoinTable(name = "Departamento_Usuario", joinColumns = {
        @JoinColumn(name = "USU_FK_ID", referencedColumnName = "USU_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "DEP_FK_ID", referencedColumnName = "DEP_ID")})
    private List<Departamento> departamentos;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

}
