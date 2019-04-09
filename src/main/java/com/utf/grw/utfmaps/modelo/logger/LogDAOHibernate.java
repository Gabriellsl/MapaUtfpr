/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.modelo.logger;

import com.utf.grw.utfmaps.util.ConexaoHibernate;
import javax.persistence.EntityManager;

/**
 *
 * @author a1808338
 */
public class LogDAOHibernate {
    EntityManager manager;

    public LogDAOHibernate() {
        this.manager = ConexaoHibernate.getInstance();
    }
    
    public void salvar(Log log) throws Exception{
        this.manager.getTransaction().begin();
        this.manager.persist(log);
        this.manager.getTransaction().commit();
    }
    
    
}
