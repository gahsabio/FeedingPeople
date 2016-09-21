/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.service;

import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.domain.TipoUsuario;
import br.edu.ifsp.bri.tsi.repository.TipoUserRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author ifsp
 */
public class TipoUserService implements Serializable {
    
    private List<TipoUsuario> tipoUsuario;
    
    @Inject
    private TipoUserRepository tipoUserRepository;

    public TipoUserService() {
//        tipoUserRepository = new TipoUserRepository();
        tipoUsuario = Arrays.asList(TipoUsuario.values());
    }

    
    public void addTipoUser(TipoUser tipoUser) {
        this.getTipoUserRepository().addTipoUser(tipoUser);                       
    }
    
    public void updateTipoUser(TipoUser tipoUser){                                
        this.getTipoUserRepository().updateTipoUser(tipoUser);            ;
    }    
    
    public void removeTipoUser(TipoUser tipoUser){
        this.getTipoUserRepository().removeTipoUser(tipoUser.getCodigoTpUsuario());            
    }
    
    public List<TipoUser> listTipoUser(){
        return this.getTipoUserRepository().listTipoUser();
    }
    
    public TipoUserRepository getTipoUserRepository() {
        return tipoUserRepository;
    }

    public void setTipoUserRepository(TipoUserRepository tipoUserRepository) {
        this.tipoUserRepository = tipoUserRepository;
    }

    public List<TipoUsuario> getTipoUsuario() {
        return tipoUsuario;
    }
    
    public TipoUser findTipoUserById( int id ){
        return this.getTipoUserRepository().findTipoUserById(id);
    }
    
    public List<SelectItem> getListTipoUser() {
        List<TipoUser> listTipoUser = new ArrayList<>();
        List<SelectItem> listaTipoUser = new LinkedList<SelectItem>();
        listTipoUser = this.getTipoUserRepository().listTipoUser();
        for (TipoUser tp: listTipoUser ) {
            listaTipoUser.add(new SelectItem(tp, tp.getTipoUsuario().toString() ));
        }
        return listaTipoUser;
    }
    
    public boolean verificarTipoUser (TipoUser tipoUser){
        boolean toReturn = false;
        List<TipoUser> tipoUserCadastrado = this.getTipoUserRepository().listTipoUserNome(tipoUser.getTipoUsuario().toString());
        
        if(tipoUserCadastrado.size() == 1){
            toReturn = true;
        }
        
        return toReturn;
    }
}
