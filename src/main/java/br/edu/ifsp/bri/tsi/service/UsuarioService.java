/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.service;

import br.edu.ifsp.bri.tsi.domain.Status;
import br.edu.ifsp.bri.tsi.domain.TipoUsuario;
import br.edu.ifsp.bri.tsi.domain.Usuario;
import br.edu.ifsp.bri.tsi.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ifsp
 */
public class UsuarioService implements Serializable {
    
    private List<TipoUsuario> tipoUsuario;
    private List<Status> listaStatus;
    
    private Status statusUsuario;
    
    @Inject
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
//        tipoUserRepository = new TipoUserRepository();
        tipoUsuario = Arrays.asList(TipoUsuario.values());
        listaStatus = Arrays.asList(Status.values());
    }

    
    public void addUsuario(Usuario usuario) {
        this.getUsuarioRepository().addUsuario(usuario);
    
    }
    
    public void updateUsuario(Usuario usuario){
        this.getUsuarioRepository().updateUsuario(usuario);
    }           
    
    public void removeUsuario(Usuario usuario){
        this.getUsuarioRepository().removeUsuario(usuario.getCodigoUsuario());
    }
    
    public boolean isUsuarioLogado(String email){
        boolean toReturn = false;
        Usuario usuario = this.getUsuarioRepository().usuarioByEmail(email);
        
        if(usuario != null && (usuario.getStatusUsuario() == this.getStatusUsuario().LOGIN)){
            toReturn = true;
        }        
        
        return toReturn;
    }
    
    public Usuario buscaUsuario(String email, String senha){
        Usuario usuario = null;
        usuario = this.getUsuarioRepository().usuarioByEmail(email);
        if((usuario != null) && (usuario.getSenhaUsuario().equals(senha))){
            usuario.setStatusUsuario(this.getStatusUsuario().LOGIN);
            this.getUsuarioRepository().updateUsuario(usuario);            
        }
        
        return usuario;        
    }
    
    public List<Usuario> listUsuario(){
        return this.getUsuarioRepository().listUsuario();
    }
    
    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<TipoUsuario> getUsuario() {
        return tipoUsuario;
    }

    public List<Status> getListaStatus() {
        return listaStatus;
    }

    public Status getStatusUsuario() {
        return statusUsuario;
    }
    
    
    
}
