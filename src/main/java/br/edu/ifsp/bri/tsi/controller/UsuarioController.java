/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.controller;

import br.edu.ifsp.bri.tsi.domain.Status;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.domain.TipoUsuario;
import br.edu.ifsp.bri.tsi.domain.Usuario;
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
public class UsuarioController implements Serializable {
  
    private Usuario usuario; //usar para adição 
    private Usuario usuarioSelecionado; //usar alteração e exclusão     
//    private List<TipoUser> listaTipoUser;
    private List<SelectItem> listaTipoUser;
    private List<Status> listaStatus;
    private List<Usuario> listaUsuario;    
    
    @Inject
    private UsuarioService usuarioService;
    @Inject
    private TipoUserService tipoUserService;


    @PostConstruct
    public void startDados(){
        usuario = new Usuario();
        usuarioSelecionado = new Usuario();
//        tipoUserService = new TipoUserService();
//        listaTipoUser = new ArrayList<>();
        listaStatus = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        listaTipoUser = new ArrayList<>();
        //tipoUsuario = this.getTipoUserService().getTipoUsuario();
        listar();
    }    
    
    
    public void listar(){
        listaUsuario = this.getUsuarioService().listUsuario();
//        listaTipoUser = this.getTipoUserService().listTipoUser();
        listaStatus = this.getUsuarioService().getListaStatus();
        listaTipoUser = this.getTipoUserService().getListTipoUser();
    }
    
    public String incluir(){
        this.getUsuarioService().addUsuario(usuario);
        this.clearDados();
        this.listar();
        return "lista.xhtml?faces-redirect=true";
    }
  
    public String alterar(){
        this.getUsuarioService().updateUsuario(usuarioSelecionado);
        this.clearDados();
        this.listar();
        return "lista.xhtml?faces-redirect=true";
    }
    
    public String remover(){
        this.getUsuarioService().removeUsuario(usuarioSelecionado);
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
        usuario = new Usuario();
        usuarioSelecionado = new Usuario();
//        tipoUserService = new TipoUserService();
//        listaTipoUser = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        listaTipoUser = new LinkedList<>();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }
 
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    public TipoUserService getTipoUserService() {
        return tipoUserService;
    }

    public void setTipoUserService(TipoUserService tipoUserService) {
        this.tipoUserService = tipoUserService;
    }

//    public List<TipoUser> getListaTipoUser() {
//        return listaTipoUser;
//    }
//
//    public void setListaTipoUser(List<TipoUser> listaTipoUser) {
//        this.listaTipoUser = listaTipoUser;
//    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<Status> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(List<Status> listaStatus) {
        this.listaStatus = listaStatus;
    }

    public List<SelectItem> getListaTipoUser() {
        return listaTipoUser;
    }

    public void setListaTipoUser(List<SelectItem> listaTipoUser) {
        this.listaTipoUser = listaTipoUser;
    }
    
}
