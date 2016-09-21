/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ifsp
 */
@ApplicationScoped
public class JPAConnection {
    
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("FeedingPeoplePU");
    
    @Produces
    @RequestScoped
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
    
    public void close (@Disposes EntityManager entityManager){
        if(entityManager.isOpen()){
            entityManager.close();
        }
    }

}
