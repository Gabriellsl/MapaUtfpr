/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Boniolo
 */
public class PropertiesReader {
    
    private String URI_LOGGER;
    private String TOKEN_LOGGER;
    private String URI_SUGESTAO;
    private String TOKEN_SUGESTAO;

    public PropertiesReader() throws IOException {
        
        Properties props = getProp();
        
        this.setURI_LOGGER(props.getProperty("prop.api.logger.uri"));
        this.setTOKEN_LOGGER(props.getProperty("prop.api.logger.token"));
        this.setURI_SUGESTAO(props.getProperty("prop.api.sugestao.uri"));
        this.setTOKEN_SUGESTAO(props.getProperty("prop.api.sugestao.token"));
    }
    
    
    
    public static Properties getProp() throws IOException{
        Properties prop = new Properties();
        
        FacesContext context = FacesContext.getCurrentInstance();

        ServletContext sc = (ServletContext) context.getExternalContext().getContext();

        String path = sc.getRealPath("");

        path = path.split("webapp")[0].concat("java\\com\\utf\\grw\\utfmaps\\properties\\conectionapi.properties");
                
        
        
        FileInputStream file = new FileInputStream(path); 
        prop.load(file);
        return prop;
    }

    public String getURI_LOGGER() {
        return URI_LOGGER;
    }

    public void setURI_LOGGER(String URI_LOGGER) {
        this.URI_LOGGER = URI_LOGGER;
    }

    public String getTOKEN_LOGGER() {
        return TOKEN_LOGGER;
    }

    public void setTOKEN_LOGGER(String TOKEN_LOGGER) {
        this.TOKEN_LOGGER = TOKEN_LOGGER;
    }

    public String getURI_SUGESTAO() {
        return URI_SUGESTAO;
    }

    public void setURI_SUGESTAO(String URI_SUGESTAO) {
        this.URI_SUGESTAO = URI_SUGESTAO;
    }

    public String getTOKEN_SUGESTAO() {
        return TOKEN_SUGESTAO;
    }

    public void setTOKEN_SUGESTAO(String TOKEN_SUGESTAO) {
        this.TOKEN_SUGESTAO = TOKEN_SUGESTAO;
    }
}
