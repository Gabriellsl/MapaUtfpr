/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.modelo.logger;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Boniolo
 */

@Entity
public class Log implements Serializable {

    public Log(Class clazz, String error) {
        this.clazz = clazz.getName();
        this.error = error;
    }
    
    @GeneratedValue @Id
    @Column(name = "LOG_ID")
    private long idLog;
    
    @Column(name = "LOG_CLASS")
    private String clazz;
    
    @Column(name = "LOG_ERROR")
    private String error;
    
    @Column(name = "LOG_CREATEDAT")
    private String createdAt;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
    
    
}
