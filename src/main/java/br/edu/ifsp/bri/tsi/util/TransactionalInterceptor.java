/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.util;

import java.io.Serializable;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author gahsabio
 */

@Interceptor
@Transactional
public class TransactionalInterceptor implements Serializable {
        
    @Inject
    private EntityManager entityManager;
    
    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception{
        
        EntityTransaction trx = entityManager.getTransaction();
        
        boolean proprietario = false;
        
        try{
            if(!trx.isActive()){
                trx.begin();
                trx.rollback();
                trx.begin();
                proprietario = true;
                                
            }
            
            return context.proceed();
            
        } catch (Exception e){
            if(trx != null && proprietario){
                trx.rollback();
            }
            throw e;
        } finally{
            if(trx != null && trx.isActive() && proprietario){
                trx.commit();
            }
        }
        
    }
}
