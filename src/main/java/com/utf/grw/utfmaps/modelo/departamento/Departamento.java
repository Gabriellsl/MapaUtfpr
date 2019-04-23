package com.utf.grw.utfmaps.modelo.departamento;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ALUNO
 */

@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento {
    @Id
    @GeneratedValue
    @Column(name="DEP_ID")
    private Long idDepartamento;
    @Column(name="DEP_NOME")
    private String nomeDep;
    @Column(name="DEP_NOMEEXT")
    private String nomeDepExt;
    @Column(name="DEP_DESCRICAO", length=4000)
    private String descricao;
    @Column(name="DEP_RESPONSAVEL")
    private String responsavel;
    @Column(name="DEP_HORAABRE")
    private String horaAbre;
    @Column(name="DEP_HORAFECHA")
    private String horaFecha;
    @Column(name="DEP_LOCALIZACAO")
    private String localizacao;
    
//    @OneToMany(/*mappedBy = "Departamento",*/ cascade = CascadeType.REMOVE)
//    private List<Sugestao> sugestoes;
    
    public Departamento(/*String nomeDep,String nomeDepExt, String descricao, String responsavel, String horaAbre, String horaFecha, int indice*/) {
//        this.nomeDep = nomeDep;
//        this.descricao = descricao;
//        this.responsavel = responsavel;
//        this.horaAbre = horaAbre;
//        this.horaFecha = horaFecha;
//        this.nomeDepExt = nomeDepExt;
//        this.indice = indice;
    }

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDep() {
        return nomeDep;
    }

    public void setNomeDep(String nomeDep) {
        this.nomeDep = nomeDep;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getHoraAbre() {
        return horaAbre;
    }

    public void setHoraAbre(String horaAbre) {
        this.horaAbre = horaAbre;
    }

    public String getHoraFecha() {
        return horaFecha;
    }

    public void setHoraFecha(String horaFecha) {
        this.horaFecha = horaFecha;
    }

    public String getNomeDepExt() {
        return nomeDepExt;
    }

    public void setNomeDepExt(String nomeDepExt) {
        this.nomeDepExt = nomeDepExt;
    }
    
    

//    public int getIndice() {;
//        return indice;
//    }
//
//    public void setIndice(int indice) {
//        this.indice = indice;
//    }
    
//    public List<Sugestao> getSugestoes() {;
//        return sugestoes;
//    }
//
//    public void setSugestoes(List<Sugestao> sugestoes) {
//        this.sugestoes = sugestoes;
//    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
}