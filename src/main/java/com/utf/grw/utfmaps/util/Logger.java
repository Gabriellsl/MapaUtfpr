/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.utf.grw.utfmaps.modelo.logger.Log;
import java.util.logging.Level;

/**
 *
 * @author Boniolo
 */

public class Logger {
    public static void save(Class clazz, String error){
        Log log = new Log(clazz, error);
        try {
            //
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
