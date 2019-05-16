package com.utf.grw.utfmaps.controle;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import com.utf.grw.utfmaps.modelo.sugestao.SugestaoRN;

/**
 *
 * @author Boniolo
 */
public class SugestaoControle {
    
    public void salvarSugestao(Sugestao sugestao) {
        SugestaoRN.salvar(sugestao);
    }   
}
