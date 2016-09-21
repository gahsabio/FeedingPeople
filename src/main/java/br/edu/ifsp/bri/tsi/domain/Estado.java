/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.bri.tsi.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gahsabio
 */

@Entity
@Table(name = "TAB_ESTADO")
public class Estado {
    
    private String nome;
    private int id;
    private Pais pais;

    public Estado(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Estado() {
    }

    @NotNull
    @Column(name = "TAB_NOMEESTADO",length = 100, nullable = false) 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Id
    @Column(name = "TAB_IDPAIS")
    @SequenceGenerator(name = "SEQ_PAIS", sequenceName = "SEQ_TAB_PAIS",allocationSize = 1 ) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAIS")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne (fetch = FetchType.LAZY, targetEntity = Pais.class)
    @JoinColumn(name = "TAB_NOMEPAIS", nullable = false, referencedColumnName = "TAB_NOMEPAIS")    
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
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
        final Estado other = (Estado) obj;
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
        return "Estado{" + "nome=" + nome + ", id=" + id + '}';
    }
       
}
