package com.utf.grw.utfmaps.modelo.permissao;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public interface PermissaoDAO {
    
    void salvar(Permissao permissao);
    void atualizar(Permissao permissao);
    void excluir(Permissao permissao);
    Permissao carregar(Integer codigo);
    Permissao buscarPorId(Long codigo);
    List<Permissao> listar();
    Permissao buscarPorNome(String nomePer);
    
}
