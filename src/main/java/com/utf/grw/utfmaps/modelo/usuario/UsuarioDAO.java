/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.modelo.usuario;

import java.util.List;

/**
 *
 * @author a1808052
 */
public interface UsuarioDAO {
    
    void salvar(Usuario usuario);
    void atualizar(Usuario usuario);
    void excluir(Usuario usuario);
    Usuario carregar(Integer codigo);
    Usuario buscarPorId(Long codigo);
    List<Usuario> listar();
    Usuario buscarPorLogin(String nome);
    public Usuario refresh(Usuario selecionado);
    
    
}
