
package com.utf.grw.utfmaps.web.bean;
	


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

@ManagedBean(name = "mapaBean")
@RequestScoped
public class MapaBean {
    
    
    public void teste(){
        System.out.println("Testando...");
    }
    
}
