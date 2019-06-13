/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.utf.grw.utfmaps.modelo.logger.Log;
import com.utf.grw.utfmaps.properties.PropertiesReader;
import java.util.logging.Level;

/**
 *
 * @author Boniolo
 */

public class Logger {
    public static void save(Class clazz, String error){
        Log log = new Log(clazz, error);
        try {
            PropertiesReader pr = new PropertiesReader();
            SendData sd = new SendData(pr.getURI_LOGGER(),pr.getTOKEN_LOGGER());
            sd.POST(log,Log.class);
        } catch (Exception ex) {
            
        }
    }
    
    public static void save(String clazz, String error){
        Log log = new Log(clazz, error);
        try {
            PropertiesReader pr = new PropertiesReader();
            SendData sd = new SendData(pr.getURI_LOGGER(),pr.getTOKEN_LOGGER());
            sd.POST(log,Log.class);
        } catch (Exception ex) {
            
        }
    }
    
}
