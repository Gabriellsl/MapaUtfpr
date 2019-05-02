package com.utf.grw.utfmaps.modelo.departamento;

import java.util.List;

/**
 *
 * @author Geovani José
 */
public interface DepartamentoDAO {
    
    void salvar(Departamento departamento);
    void atualizar(Departamento departamento);
    void excluir(Departamento departamento);
    Departamento carregar(Integer codigo);
    Departamento buscarPorId(Long codigo);
    List<Departamento> listar();
    Departamento buscarPorNome(String nomeDep);

    public Departamento refresh(Departamento selecionado);
    
}
