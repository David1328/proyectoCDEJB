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

@Table(name = "formato_album", schema = "disquera")

public class FormartoAlbum implements Serializable{
    @Id
    @Column(name = "id_formato")
    private Integer id_formato;
    
    @Column(name = "nombre_formato")
    private String nombre_formato;

    public FormartoAlbum() {
    }

    public FormartoAlbum(Integer id_formato, String nombre_formato) {
        this.id_formato = id_formato;
        this.nombre_formato = nombre_formato;
    }

    /**
     * @return the id_formato
     */
    public Integer getId_formato() {
        return id_formato;
    }

    /**
     * @param id_formato the id_formato to set
     */
    public void setId_formato(Integer id_formato) {
        this.id_formato = id_formato;
    }

    /**
     * @return the nombre_formato
     */
    public String getNombre_formato() {
        return nombre_formato;
    }

    /**
     * @param nombre_formato the nombre_formato to set
     */
    public void setNombre_formato(String nombre_formato) {
        this.nombre_formato = nombre_formato;
    }
    
    
    
}
