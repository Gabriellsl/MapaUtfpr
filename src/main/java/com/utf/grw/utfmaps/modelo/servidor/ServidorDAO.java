package com.utf.grw.utfmaps.modelo.servidor;

import java.util.List;

/**
 *
 * @author Geovani José
 */
public interface ServidorDAO {
    
    void salvar(Servidor servidor);
    void atualizar(Servidor servidor);
    void excluir(Servidor servidor);
    Servidor carregar(Integer codigo);
    Servidor buscarPorId(Long codigo);
    List<Servidor> listar();
    Servidor buscarPorLogin(String login);
    
}
