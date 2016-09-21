/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.service;

import br.edu.ifsp.bri.tsi.domain.Pais;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.repository.PaisRepository;
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
public class PaisService implements Serializable {
    
    private List<Pais> pais;
    
    @Inject
    private PaisRepository paisRepository;

    public PaisService() {
        
    }

    
    public void add(Pais pais) {
        this.getPaisRepository().add(pais);                       
    }
    
    public void update(Pais pais){                                
        this.getPaisRepository().update(pais);                
    }    
    
    public void remove(Pais pais){
        this.getPaisRepository().remove(pais.getId());
    }
    
    public List<Pais> list(){
        return this.getPaisRepository().list();
    }
    
    public PaisRepository getPaisRepository() {
        return paisRepository;
    }

    public void setPaisRepository(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> getPais() {
        return pais;
    }
    
    public Pais findPaisById( int id ){
        return this.getPaisRepository().findPaisById(id);
    }

    public List<SelectItem> getListPais() {
        List<Pais> listPais = new ArrayList<>();
        List<SelectItem> listaPais = new LinkedList<SelectItem>();
        listPais = this.getPaisRepository().list();
        for (Pais pa : listPais) {
            listaPais.add(new SelectItem(pa, pa.getNome()));
        }
        return listaPais;
    } 
}
