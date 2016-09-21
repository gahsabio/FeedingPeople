/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author gahsabio
 */
public class MensagemJSF {
    
    public static void mensagemErro(String mensagem){        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);                
    }
    
    public static void mensagemSucesso (String mensagem){
        FacesMessage facesMessage = new FacesMessage (FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMessage);
    }
    
}
