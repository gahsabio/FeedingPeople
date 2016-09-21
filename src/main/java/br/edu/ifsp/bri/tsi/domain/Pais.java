/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gahsabio
 */

@Entity
@Table(name = "TAB_PAIS")
public class Pais {
    private String nome;
    private int id;

    public Pais() {
    }

    @Id
    @Column (name = "TAB_IDPAIS")
    @SequenceGenerator (name = "SEQ_PAIS", sequenceName = "SEQ_TAB_PAIS", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }        

    @NotNull
    @Column (name = "TAB_NOMEPAIS", length = 50, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pais{" + "nome=" + nome + ", id=" + id + '}';
    }   
    
}
