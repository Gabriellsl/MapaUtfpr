/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.modelo.logger;

import java.io.Serializable;

/**
 *
 * @author Boniolo
 */

public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    public Log(String clazz, String error) {
        this.clazz = clazz;
        this.error = error;
    }

    public Log(Class clazz, String error) {
        this.clazz = clazz.getName();
        this.error = error;
    }
         
    
    private String clazz;
    private String error;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
