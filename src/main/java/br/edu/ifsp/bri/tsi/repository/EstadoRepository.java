/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.repository;

import br.edu.ifsp.bri.tsi.domain.Estado;
import br.edu.ifsp.bri.tsi.util.Transactional;
import br.edu.ifsp.bri.tsi.domain.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import javax.inject.Inject;

/**
 *
 * @author ifsp
 */
public class EstadoRepository implements Serializable {
    
    private Estado estado; 

    @Inject
    private EntityManager entityManager;
    
    public EstadoRepository() {
    }
    
    @Transactional
    public void add(Estado estado){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();        
        entityManager.persist(estado);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void update(Estado estado){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.merge(estado);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void remove( int id ){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        Estado estadoEncontrado = entityManager.find(Estado.class, id );
        entityManager.remove(estadoEncontrado);
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
        
    }
    
    
    public List<Estado> list(){
        List<Estado> listaEstado = new ArrayList<>();
//        EntityManager entityManager = JPAConnection.getEntityManager();
        try {       
            Query query = entityManager.createQuery("SELECT e FROM Estado e ");
            listaEstado = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
//        entityManager.close();
        return listaEstado;
    }
    
}
