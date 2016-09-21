/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tsi.criartabela;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ifsp
 */
public class CriarTabela {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema");
        
    public static EntityManager createEntityManager(){
        return emf.createEntityManager();
    }
    
    public static void main(String[] args ) {
        EntityManager manager = CriarTabela.createEntityManager();
        manager.close();
        System.out.println(">>>>>  Tabelas Geradas com sucesso! <<<<<<<<<");
        System.exit(0);
    }
    
}
