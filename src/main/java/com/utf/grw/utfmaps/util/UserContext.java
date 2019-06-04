/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utf.grw.utfmaps.util;

import com.utf.grw.utfmaps.modelo.usuario.Usuario;
import com.utf.grw.utfmaps.modelo.usuario.UsuarioRN;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author boniolo
 */
public class UserContext {

    public static Usuario getUserContext() {

        UsuarioRN usuarioRN = new UsuarioRN();
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = usuarioRN.buscar(login);
        user = usuarioRN.refresh(user);
        return user;
    }
}
