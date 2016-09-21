/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.repository;

import br.edu.ifsp.bri.tsi.domain.Pais;
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
public class PaisRepository implements Serializable {
    
    private Pais pais; 

    @Inject
    private EntityManager entityManager;
    
    public PaisRepository() {
    }
    
    @Transactional
    public void add(Pais pais){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();        
        entityManager.persist(pais);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void update(Pais pais){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.merge(pais);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void remove( int id ){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        Pais paisEncontrado = entityManager.find(Pais.class, id );
        entityManager.remove(paisEncontrado);
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
        
    }
    
    
    public List<Pais> list(){
        List<Pais> listaPais = new ArrayList<>();
//        EntityManager entityManager = JPAConnection.getEntityManager();
        try {       
            Query query = entityManager.createQuery("SELECT p FROM Pais p ");
            listaPais = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
//        entityManager.close();
        return listaPais;
    }
    
    public Pais findPaisById( int id ){
        return entityManager.find(Pais.class, id );
    }
    
}
