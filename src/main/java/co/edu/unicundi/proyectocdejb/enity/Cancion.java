/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author asantibo
 */
@Entity

@Table(name = "cancion", schema = "disquera")

@NamedQueries({
    @NamedQuery(name = "cancion.nombrecancion_artista", query = "select c from Cancion c Where c.nombre = :nombre AND c.artista_productor = :artista_productor AND c.id_album = :id_album"),
    @NamedQuery(name = "cancion.listarcanciones_segunNombre", query = "select c from Cancion c Where c.nombre = :nombre"),
    @NamedQuery(name = "cancion.listarcanciones_segunArtista", query = "select c from Cancion c Where c.artista_productor = :artista_productor"),
    @NamedQuery(name = "cancion.listarCancionPorAlbum", query = "select c from Cancion c Where c.id_album = :id_album"),
    @NamedQuery(name = "cancion.listarCancion", query = "select c from Cancion c"),
    //venta
    @NamedQuery(name = "cancion.infoCancion", query = "select c from Cancion c Where c.id = :id"),
    @NamedQuery(name = "cancion.actualizarCopias", query = "UPDATE Cancion c SET c.copias_fisicas = :copias_fisicas WHERE c.id = :id")

})

public class Cancion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Integer id;

    @NotNull(message = "Es necesario nombrar la cancion")
    @Size(min = 2, max = 12, message = "Ingrese valores de entre 2 y 12 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull(message = "Es necesario ingresar un artista principal")
    @Size(min = 2, max = 12, message = "Ingrese valores de entre 2 y 12 caracteres")
    @Column(name = "artista_productor", nullable = false)
    private String artista_productor;

    @NotNull(message = "Es necesario un artista secundario")
    @Size(min = 2, max = 30, message = "Ingrese valores de entre 2 y 30 caracteres")
    @Column(name = "artistas_secundarios", nullable = false)
    private String artistas_secundarios;

    @Min(0)
    @Column(name = "id_album", nullable = true)
    private Integer id_album;

    @NotNull(message = "Es necesario ingresar una cantidad de copias en fidsico disponibles")
    @Min(0)
    @Column(name = "copias_fisicas", nullable = false)
    private Integer copias_fisicas;

    @NotNull(message = "Es necesario ingresar un precio")
    @Min(0)
    @Column(name = "precio", nullable = false)
    private Integer precio;

    public Cancion() {
    }

    public Cancion(Integer id, String nombre, String artista_productor, String artistas_secundarios, Integer id_album, Integer copias_fisicas, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.artista_productor = artista_productor;
        this.artistas_secundarios = artistas_secundarios;
        this.id_album = id_album;
        this.copias_fisicas = copias_fisicas;
        this.precio = precio;
    }

    /**
     * Metodo que envia la intancia para validar si tiene alguna violación
     *
     * @return
     *
     *
     */
    public Set<ConstraintViolation<Cancion>> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the artista_productor
     */
    public String getArtista_productor() {
        return artista_productor;
    }

    /**
     * @param artista_productor the artista_productor to set
     */
    public void setArtista_productor(String artista_productor) {
        this.artista_productor = artista_productor;
    }

    /**
     * @return the artistas_secundarios
     */
    public String getArtistas_secundarios() {
        return artistas_secundarios;
    }

    /**
     * @param artistas_secundarios the artistas_secundarios to set
     */
    public void setArtistas_secundarios(String artistas_secundarios) {
        this.artistas_secundarios = artistas_secundarios;
    }

    /**
     * @return the id_album
     */
    public Integer getId_album() {
        return id_album;
    }

    /**
     * @param id_album the id_album to set
     */
    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    /**
     * @return the copias_fisicas
     */
    public Integer getCopias_fisicas() {
        return copias_fisicas;
    }

    /**
     * @param copias_fisicas the copias_fisicas to set
     */
    public void setCopias_fisicas(Integer copias_fisicas) {
        this.copias_fisicas = copias_fisicas;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

}
