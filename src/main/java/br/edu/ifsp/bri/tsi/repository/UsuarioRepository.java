/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.repository;

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
public class UsuarioRepository implements Serializable {
    
    private Usuario usuario; 

    @Inject
    private EntityManager entityManager;
    
    public UsuarioRepository() {
    }
    
    @Transactional
    public void addUsuario(Usuario usuario){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        System.out.println("TipoUser " + usuario.getTipoUser().toString());
        entityManager.persist(usuario);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void updateUsuario(Usuario usuario){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        entityManager.merge(usuario);  //grava um novo registro
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
    }
    
    @Transactional
    public void removeUsuario( int id ){
//        EntityManager entityManager = JPAConnection.getEntityManager();
//        entityManager.getTransaction().begin();
        Usuario usuarioEncontrado = entityManager.find(Usuario.class, id );
        entityManager.remove(usuarioEncontrado);
//        entityManager.getTransaction().commit();  //executa o banco para grava 
//        entityManager.close();
        
    }
     
    public Usuario usuarioByEmail(String email) {
        Usuario usuario = null;
        try{
            Query query = entityManager.createQuery("SELECT u FROM Usuario u where u.emailUsuario = :email ");
            query.setParameter("email", email);
            usuario = (Usuario) query.getSingleResult();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return usuario;
    }
    
    public List<Usuario> listUsuario(){
        List<Usuario> listaUsuario = new ArrayList<>();
//        EntityManager entityManager = JPAConnection.getEntityManager();
        try {       
            Query query = entityManager.createQuery("SELECT u FROM Usuario u ");
            listaUsuario = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
//        entityManager.close();
        return listaUsuario;
    }
    
}
