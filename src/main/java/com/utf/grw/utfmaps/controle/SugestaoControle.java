package com.utf.grw.utfmaps.controle;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import com.utf.grw.utfmaps.modelo.sugestao.SugestaoRN;

/**
 *
 * @author ALUNO
 */
public class SugestaoControle {
    
    private SugestaoRN sugestaoRN;
    
    public SugestaoControle() {
        this.sugestaoRN = new SugestaoRN();
    }
    
    public void salvarSugestao(Sugestao sugestao) {
        sugestaoRN.salvar(sugestao);
    }
    
    public void atualizarSugestao(Sugestao sugestao) {
        sugestaoRN.atualizar(sugestao);
    }
    
    public void excluirSugestao(Sugestao sugestao) {
        sugestaoRN.excluir(sugestao);
    }
    
    public Sugestao buscarSugestao(String nome) {
        return sugestaoRN.buscar(nome);
    }
    
}
