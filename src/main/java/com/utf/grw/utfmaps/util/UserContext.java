/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author boniolo
 */
public class UserContext {
    public static Usuario getUser(){
        
        UsuarioRN usuarioRN = new UsuarioRN();
        
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioRN.buscar(login);
        
        return user;
    }
}
