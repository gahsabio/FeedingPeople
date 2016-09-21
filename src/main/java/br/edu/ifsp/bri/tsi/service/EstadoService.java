/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.service;

import br.edu.ifsp.bri.tsi.domain.Estado;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
import br.edu.ifsp.bri.tsi.repository.EstadoRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * @author ifsp
 */
public class EstadoService implements Serializable {
    
    @Inject
    private EstadoRepository estadoRepository;

    public EstadoService() {
        
    }

    
    public void add(Estado estado) {
        this.getEstadoRepository().add(estado);
    
    }
    
    public void update(Estado estado){
        this.getEstadoRepository().update(estado);
    }           
    
    public void remove(Estado estado){
        this.getEstadoRepository().remove(estado.getId());
    }
    
    public List<Estado> list(){
        return this.getEstadoRepository().list();
    }
    
    public EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }
}
