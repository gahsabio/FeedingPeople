/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.util.acesso;

import br.edu.ifsp.bri.tsi.domain.Usuario;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author gahsabio
 */
public class ControleAcesso implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent pe) {
        FacesContext contexto = pe.getFacesContext();
        String pagina = contexto.getViewRoot().getViewId();
        
        if("/login/login.xhtml".equals(pagina)){
            return;
        }
        
        Usuario usuarioLogado = (Usuario) contexto.getExternalContext().getSessionMap().get("Usuario Logado");
        
        if (usuarioLogado != null){
            return;
        }
        NavigationHandler nh = contexto.getApplication().getNavigationHandler();
        nh.handleNavigation(contexto, null, "/login/login.xhtml?faces-redirect=true");
        contexto.renderResponse();
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
