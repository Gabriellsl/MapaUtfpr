/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.jboss.jandex.Main;

/**
 *
 * @author Boniolo
 */
public class SendData {
    HttpClient httpClient = null;
    HttpPost post = null;
    String URI;
    
    public SendData(String URI, String token) {
        this.URI = URI;
        this.httpClient = HttpClients.createDefault();       
        this.post = new HttpPost(URI);
        this.post.setHeader("authorization", token);
        this.post.setHeader("Content-type", "application/json");
    }
    
    public void POST(Object obj, Class clazz){
        
        try {
            this.post.setEntity(new StringEntity(new Gson().toJson(obj, clazz)));
            this.httpClient.execute(this.post);
            
            System.out.println("____________________________________________");
            System.out.println("********************************************");
            System.out.println("*******************SENDED*******************");
            System.out.println(this.URI);
            System.out.println("********************************************");
            System.out.println("____________________________________________");
            
        } catch (Exception ex) {
            System.out.println("____________________________________________");
            System.out.println("********************************************");
            System.out.println("*************Connection Refused*************");
            System.out.println(this.URI);
            System.out.println("********************************************");            
            System.out.println("____________________________________________");
            
        }
    }
}
