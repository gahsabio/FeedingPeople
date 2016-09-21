/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.controller;

import br.edu.ifsp.bri.tsi.domain.Usuario;
import br.edu.ifsp.bri.tsi.service.UsuarioService;
import br.edu.ifsp.bri.tsi.util.MensagemJSF;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gahsabio
 */

@Named
@SessionScoped
public class LoginController implements Serializable{
    
    private String emailUsuario;
    private String senhaUsuario;
    
    private FacesContext contexto = FacesContext.getCurrentInstance();
    
    @Inject
    private UsuarioService usuarioService;
    
    private Usuario usuarioLogado;
    
    @PostConstruct
    public void startLogin(){
        this.startDados();
    }
    
    public String  doLogin(){
        if(!this.getUsuarioService().isUsuarioLogado(this.getEmailUsuario())){
            usuarioLogado = this.getUsuarioService().buscaUsuario(this.getEmailUsuario(), this.getSenhaUsuario());
            contexto.getExternalContext().getSessionMap().put("usuarioLogado", this.getUsuarioLogado());
            return "/paginas/menu.xhtml";
        }
        else{
            MensagemJSF.mensagemErro("Usuario não encontrado ou senha incorreta !");
        }
        return "/erro/erro.xhtml";
    }
    
    public  void startDados(){
        usuarioLogado = new Usuario();
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }
    
    
    
}
