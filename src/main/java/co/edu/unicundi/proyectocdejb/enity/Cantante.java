/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author David
 */
@Entity

@Table(name = "cantante",schema = "usuarios")


public class Cantante implements Serializable{
    
    @Id
    @Column(name = "id_cantante")
    private Integer idCantante;
    
    @Column(name =  "nombre",nullable = false)
    private String nombre;
    
    @Column(name = "categoria",nullable = false)
    private String categoria;
    
    

    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the idCantante
     */
    public Integer getIdCantante() {
        return idCantante;
    }

    /**
     * @param idCantante the idCantante to set
     */
    public void setIdCantante(Integer idCantante) {
        this.idCantante = idCantante;
    }
    
    
    
    
}
