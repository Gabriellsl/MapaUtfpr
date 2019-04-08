package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.modelo.sugestao.Sugestao;
import java.util.List;

public interface SugestaoDAO {
    
    void salvar(Sugestao sugestao);
    void atualizar(Sugestao sugestao);
    void excluir(Sugestao sugestao);
    Sugestao carregar(Integer codigo);
    Sugestao buscarPorId(Long codigo);
    List<Sugestao> listar();
    Sugestao buscarPorLogin(String login);
    
}
