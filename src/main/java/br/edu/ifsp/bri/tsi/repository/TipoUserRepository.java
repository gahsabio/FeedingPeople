/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.repository;

import br.edu.ifsp.bri.tsi.util.Transactional;
import br.edu.ifsp.bri.tsi.domain.TipoUser;
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
public class TipoUserRepository implements Serializable {
    
    private TipoUser tipoUser; 

    @Inject
    private EntityManager entityManager;
    
    public TipoUserRepository() {
    }
    
    @Transactional
    public void addTipoUser(TipoUser tipoUser){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.persist(tipoUser);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void updateTipoUser(TipoUser tipoUser ){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.merge(tipoUser);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void removeTipoUser( int id ){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        TipoUser tipoUserEncontrado = entityManager.find(TipoUser.class, id );
        entityManager.remove(tipoUserEncontrado);
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
        
    }
    
    
    public List<TipoUser> listTipoUser(){
        List<TipoUser> listaTipoUser = new ArrayList<>();
//        EntityManager entityManager = JPAConnection.getEntityManager();
        try {       
            Query query = entityManager.createQuery("SELECT tp FROM TipoUser tp ");
            listaTipoUser = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
//        entityManager.close();
        return listaTipoUser;
    }
    
    public TipoUser findTipoUserById( int id ){
        return entityManager.find(TipoUser.class, id );
    }

    public List<TipoUser> listTipoUserNome(String tipoUsuario) {
        List<TipoUser> listTipoUser = new ArrayList<>();
        try{
            Query query = entityManager.createQuery("SELECT tp FROM TipoUser tp where tp.tipoUsuario like :tipoUsuario ");
            query.setParameter("tipoUsuario", tipoUsuario);
            listTipoUser = query.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return listTipoUser;
    }
    
    
    
}
