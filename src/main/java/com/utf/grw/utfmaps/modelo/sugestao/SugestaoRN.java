package com.utf.grw.utfmaps.modelo.sugestao;

import com.utf.grw.utfmaps.properties.PropertiesReader;
import com.utf.grw.utfmaps.util.SendData;

/**
 *
 * @author Boniolo
 */
public class SugestaoRN {
    public void salvar(Sugestao sugestao) {
        try {
            PropertiesReader pr = new PropertiesReader();
            SendData sd = new SendData(pr.getURI_SUGESTAO(), pr.getTOKEN_SUGESTAO());
            sd.POST(sugestao, Sugestao.class);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
