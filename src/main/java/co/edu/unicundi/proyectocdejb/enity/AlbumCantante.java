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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Entity

@Table(name = "album_cantante", schema = "disquera")

@NamedQueries({
    @NamedQuery(name = "album_cantante.listartodos", query = "select c from AlbumCantante c"),})

public class AlbumCantante implements Serializable {

    @Max(value = 999, message = "no puede ingresar valores mayores a 999")
    @Min(value = 1, message = "no puede ingresar valores minimos a 1")
    @Id
    @Column(name = "id_cantante", nullable = true)
    private Integer id_cantante;

    @NotNull(message = "Es necesario ingresar un nombre")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull(message = "Es necesario ingresar un nombre de album")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "nombre_album", nullable = false)
    private String nombre_album;

    public Integer getId_cantante() {
        return id_cantante;
    }

    public void setId_cantante(Integer id_cantante) {
        this.id_cantante = id_cantante;
    }

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
     * @return the nombre_album
     */
    public String getNombre_album() {
        return nombre_album;
    }

    /**
     * @param nombre_album the nombre_album to set
     */
    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

}
