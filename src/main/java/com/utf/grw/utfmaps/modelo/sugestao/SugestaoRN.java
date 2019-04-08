package com.utf.grw.utfmaps.modelo.sugestao;

/**
 *
 * @author Geovani José
 */
public class SugestaoRN {
    
    private SugestaoDAO sugestaoDAO;

    public SugestaoRN() {
        this.sugestaoDAO = new SugestaoDAOHibernate();
    }
    
    public void salvar(Sugestao sugestao) {
        try {
            this.sugestaoDAO.salvar(sugestao);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void atualizar(Sugestao sugestao){
        try {
            this.sugestaoDAO.atualizar(sugestao);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void excluir(Sugestao sugestao){
        try {
            this.sugestaoDAO.excluir(sugestao);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public Sugestao buscar(Long codigo){
        try {
            return this.sugestaoDAO.buscarPorId(codigo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public Sugestao buscar(String login){
        try {
            return this.sugestaoDAO.buscarPorLogin(login);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
    
}
