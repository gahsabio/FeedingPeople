/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.controller;

import br.edu.ifsp.bri.tsi.domain.Pais;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.domain.TipoUsuario;
import br.edu.ifsp.bri.tsi.service.PaisService;
import br.edu.ifsp.bri.tsi.service.TipoUserService;
import br.edu.ifsp.bri.tsi.util.MensagemJSF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ifsp
 */

@Named
@SessionScoped
    public class PaisController implements Serializable {
  
    private Pais pais; //usar para adição 
    private Pais paisSelecionado; //usar alteração e exclusão
    private List<Pais> listaPais;
    
    @Inject
    private PaisService paisService;


    @PostConstruct
    public void startDados(){
        pais = new Pais();
        paisSelecionado = new Pais();     
    }
    
    public String incluir(){
        this.getPaisService().add(pais);
        this.clearDados();
        return "lista.xhtml?faces-redirect=true";
    }
  
    public String alterar(){
        this.getPaisService().update(paisSelecionado);
        this.clearDados();
        return "lista.xhtml?faces-redirect=true";
    }
    
    public String remover(){
        this.getPaisService().remove(paisSelecionado);
        this.clearDados();
        return "lista.xhtml?faces-redirect=true";
    }
    
    
    public String doIncluir(){
        return "incluir.xhtml?faces-redirect=true";
    }
    
    public String doAlterar(){
        return "alterar.xhtml?faces-redirect=true";
    }
    
    public String doRemover(){
        return "remover.xhtml?faces-redirect=true";
    }
    
    public String doConsultar(){
        return "consultar.xhtml?faces-redirect=true";
    }
    
    public String doCancelar(){
        return "lista.xhtml?faces-redirect=true";
    }
    
    public void clearDados(){
        pais = new Pais();
        paisSelecionado = new Pais();
    }
    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPaisSelecionado() {
        return paisSelecionado;
    }

    public void setPaisSelecionado(Pais paisSelecionado) {
        this.paisSelecionado = paisSelecionado;
    }
 
    public PaisService getPaisService() {
        return paisService;
    }

    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }
    
    public List<Pais> getListaPais() {
        return listaPais;
    }
    
    public void setListaPais(List<Pais> listaPais) {
        this.listaPais = listaPais;
    }
    
}
