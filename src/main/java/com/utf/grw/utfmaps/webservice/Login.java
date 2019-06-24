package com.utf.grw.utfmaps.webservice;

import com.google.gson.Gson;
import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
import com.utf.grw.utfmaps.util.Logger;
import java.io.BufferedReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.core.Response;

@Path("login")
public class Login {

    @POST
    @Path("logar")
//    @Produces(MediaType.TEXT_PLAIN);
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Response logar(InputStream incomingData) {
        StringBuilder json = new StringBuilder();
        try {
                BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
                String line = null;
                while ((line = in.readLine()) != null) {
                        json.append(line);
                }
        } catch (Exception e) {
                System.out.println("Error Parsing: - ");
        }
        
        Gson gson = new Gson();
        Usuario user1 = gson.fromJson(json.toString(), Usuario.class);
        
        UsuarioRN uRN = new UsuarioRN();
        
        try{
            Usuario user2 = uRN.buscar(user1.getLogin());
            if(user1.getSenha().equals(user2.getSenha()))
                return Response.status(200).build();
            else 
                return Response.status(401).build();
        }catch(Exception e){
            Logger.save(this.getClass().getName(), e.getMessage());;
        }
        return Response.status(400).build();
    }
    
    
  
    
}