
package com.utf.grw.utfmaps.web.bean;
	


import com.utf.grw.utfmaps.modelo.departamento.Departamento;
import com.utf.grw.utfmaps.modelo.departamento.DepartamentoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "mapaBean")
@SessionScoped
public class MapaBean implements Serializable{
    
    private boolean carregar = false;
    
    private List<String> cities;
    DepartamentoRN departamentoRN = new DepartamentoRN();
    List<Departamento> departamentos;
    String mapa = "Mapa UTFPR !";
    String bloco;
    Departamento selecionado = new Departamento();
    
    @PostConstruct
    public void init() {
        //Cities
        cities = new ArrayList<String>();
        cities.add("San Francisco");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        
        //this.departamentos = departamentoRN.buscarPorLocalizacao("L");
              
    }
 
    
    
    public void teste(String bloco){
        System.out.println("Testando..."+ bloco); 
        //this.carregar = true;
        this.departamentos = departamentoRN.buscarPorLocalizacao(bloco);
        this.bloco = bloco;
        RequestContext requestContext = RequestContext.getCurrentInstance();  
        requestContext.execute("PF('cityDialog').show();");
    }
    
    public boolean load(){
        return this.carregar;
    }
    
        public List<String> getCities() {
        return cities;
    }
 
    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public boolean isCarregar() {
        return carregar;
    }

    public void setCarregar(boolean carregar) {
        this.carregar = carregar;
    }

    public DepartamentoRN getDepartamentoRN() {
        return departamentoRN;
    }

    public void setDepartamentoRN(DepartamentoRN departamentoRN) {
        this.departamentoRN = departamentoRN;
    }

    public List<Departamento> getDepartamentos() {
        return this.departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }



    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Departamento getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Departamento selecionado) {
        this.selecionado = selecionado;
    }
    
    
    
}
