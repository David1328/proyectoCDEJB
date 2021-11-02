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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David
 */
@Entity

@Table(name = "disco", schema = "disquera")

@NamedQueries({
    @NamedQuery(name = "disco.listartodos", query = "select d from Disco d")
})
public class Disco implements Serializable{
   
    @Id
    @Column(name = "id_disco", nullable = true)
    @NotNull(message = "Es necesario ingresar un nombre")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    private Integer id_disco;
    
    @NotNull(message = "Es necesario ingresar un album")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "nombre_album", nullable = false)
    private String nombre_album;
    
    @NotNull(message = "Es necesario ingresar una compañia productora")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "compania_productora", nullable = false)
    private String compania_productora;
    
    @NotNull(message = "Es necesario ingresar un formato(fisio, etc..)")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "formato", nullable = false)
    private String formato;
    
    @NotNull(message = "Es necesario ingresar el año del lanzamiento")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "ano_lanzamiento", nullable = false)
    private String ano_lanzamiento;
    
    @NotNull(message = "Es necesario ingresar el formato del album")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "id_formato", nullable = false)
    private Integer id_formato;
    
    
    private Integer cantidad;
    
    public Disco() {
    }

    public Disco(Integer id_disco, String nombre_album, String compania_productora, String formato, String ano_lanzamiento, Integer id_formato, Integer cantidad) {
        this.id_disco = id_disco;
        this.nombre_album = nombre_album;
        this.compania_productora = compania_productora;
        this.formato = formato;
        this.ano_lanzamiento = ano_lanzamiento;
        this.id_formato = id_formato;
        this.cantidad = cantidad;
    }
    
    /**
     * @return the id_disco
     */
    public Integer getId_disco() {
        return id_disco;
    }

    /**
     * @param id_disco the id_disco to set
     */
    public void setId_disco(Integer id_disco) {
        this.id_disco = id_disco;
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


    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
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
     * @return the ano_lanzamiento
     */
    public String getAno_lanzamiento() {
        return ano_lanzamiento;
    }

    /**
     * @param ano_lanzamiento the ano_lanzamiento to set
     */
    public void setAno_lanzamiento(String ano_lanzamiento) {
        this.ano_lanzamiento = ano_lanzamiento;
    }

    /**
     * @return the compania_productora
     */
    public String getCompania_productora() {
        return compania_productora;
    }

    /**
     * @param compania_productora the compania_productora to set
     */
    public void setCompania_productora(String compania_productora) {
        this.compania_productora = compania_productora;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
