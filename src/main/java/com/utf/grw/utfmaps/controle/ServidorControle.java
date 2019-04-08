package com.utf.grw.utfmaps.controle;

import com.utf.grw.utfmaps.modelo.servidor.Servidor;
import com.utf.grw.utfmaps.modelo.servidor.ServidorRN;


/**
 *
 * @author Geovani José
 */
public class ServidorControle {
    
    private ServidorRN servidorRN;

    public ServidorControle() {
        this.servidorRN = new ServidorRN();
    }
    
    public void salvarServidor(Servidor servidor) {
        servidorRN.salvar(servidor);
    }
    
    public void atualizarServidor(Servidor servidor) {
        servidorRN.atualizar(servidor);
    }
    
    public void excluirServidor(Servidor servidor) {
        servidorRN.excluir(servidor);
    }
    
    public Servidor buscarServidor(Long codigo) {
        return servidorRN.buscar(codigo);
    }
    
    public Servidor buscarServidor(String login) {
        return servidorRN.buscar(login);
    }
    
}
