/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.util;

import java.util.Set;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ifsp
 */
public class ClassLocatorService {
    
    private static BeanManager getBeanManager(){
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/env/BeanManager");
        } catch( NamingException ne){
            throw new RuntimeException("Classe não eoncontrada!");
        }
    }
    
    public static <T> T getBean( Class<T> classe ) {
        BeanManager bm = getBeanManager();
        Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(classe);
        if ( beans == null || beans.isEmpty() ){
            return null;
        }                
        Bean<T> bean = (Bean<T>) beans.iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T objeto = (T) bm.getReference(bean, classe, ctx);
        return objeto;
    }    
    
}
