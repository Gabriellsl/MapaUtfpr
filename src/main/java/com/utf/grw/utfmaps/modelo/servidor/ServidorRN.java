package com.utf.grw.utfmaps.modelo.servidor;

/**
 *
 * @author Geovani José
 */
public class ServidorRN {
    
    private ServidorDAO servidorDAO;

    public ServidorRN() {
        this.servidorDAO = new ServidorDAOHibernate();
    }
    
    public void salvar(Servidor servidor) {
        try {
            this.servidorDAO.salvar(servidor);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void atualizar(Servidor servidor){
        try {
            this.servidorDAO.atualizar(servidor);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Servidor servidor){
        try {
            this.servidorDAO.excluir(servidor);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Servidor buscar(Long codigo){
        try {
            return this.servidorDAO.buscarPorId(codigo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public Servidor buscar(String login){
        try {
            return this.servidorDAO.buscarPorLogin(login);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
}
