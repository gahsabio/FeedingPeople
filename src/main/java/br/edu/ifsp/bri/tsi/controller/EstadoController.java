/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.controller;

import br.edu.ifsp.bri.tsi.domain.Estado;
import br.edu.ifsp.bri.tsi.domain.Status;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.domain.TipoUsuario;
import br.edu.ifsp.bri.tsi.domain.Usuario;
import br.edu.ifsp.bri.tsi.service.EstadoService;
import br.edu.ifsp.bri.tsi.service.PaisService;
import br.edu.ifsp.bri.tsi.service.TipoUserService;
import br.edu.ifsp.bri.tsi.service.UsuarioService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ifsp
 */

@Named
@SessionScoped
public class EstadoController implements Serializable {
  
    private Estado estado; //usar para adição 
    private Estado estadoSelecionado; //usar alteração e exclusão
    private List<SelectItem> listaPais;
    
    @Inject
    private EstadoService estadoService;
    @Inject
    private PaisService paisService;

    @PostConstruct
    public void startDados(){
        estado = new Estado();
        estadoSelecionado = new Estado();
        listaPais = new ArrayList<>();        
        listar();
    }    
        
    public void listar(){
        listaPais = this.getPaisService().getListPais();
    }
    
    public String incluir(){
        this.getEstadoService().add(estado);
        this.clearDados();
        this.listar();
        return "lista.xhtml?faces-redirect=true";
    }
  
    public String alterar(){
        this.getEstadoService().update(estadoSelecionado);
        this.clearDados();
        this.listar();
        return "lista.xhtml?faces-redirect=true";
    }
    
    public String remover(){
        this.getEstadoService().remove(estadoSelecionado);
        this.clearDados();
        this.listar();
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
    
    public String doConsulta(){
        return "consultar.xhtml?faces-redirect=true";
    }
    
    public String doCancelar(){
        return "lista.xhtml?faces-redirect=true";
    }
    
    public void clearDados(){
        estado = new Estado();
        estadoSelecionado = new Estado();        
        listaPais = new LinkedList<>();
    }
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }
 
    public EstadoService getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }
    
    public PaisService getPaisService() {
        return paisService;
    }

    public void setPaisService(PaisService paisService) {
        this.paisService = paisService;
    }

//    public List<TipoUser> getListaTipoUser() {
//        return listaTipoUser;
//    }
//
//    public void setListaTipoUser(List<TipoUser> listaTipoUser) {
//        this.listaTipoUser = listaTipoUser;
//    }

    public List<SelectItem> getListaPais() {
        return listaPais;
    }

    public void setListaPais(List<SelectItem> listaPais) {
        this.listaPais = listaPais;
    }
    
}
