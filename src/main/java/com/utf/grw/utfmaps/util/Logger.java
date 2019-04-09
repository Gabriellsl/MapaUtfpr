/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.utf.grw.utfmaps.modelo.logger.Log;
import com.utf.grw.utfmaps.modelo.logger.LogDAOHibernate;
import java.util.logging.Level;

/**
 *
 * @author Boniolo
 */

public class Logger {
    public static void persist(Class clazz, String error){
        Log log = new Log(clazz, error);
        LogDAOHibernate logDao = new LogDAOHibernate();
        try {
            logDao.salvar(log);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void log(Class clazz, String error){
        Log log = new Log(clazz, error);
        System.err.print("Erro na classe "+clazz.getClass().getName()+"\n"+"Erro: "+error);
    }
    
    public static void logAndPersist(Class clazz, String error){
        Log log = new Log(clazz, error);
        persist(clazz, error);
        Logger.log(clazz, error);
    }
    
    
}
