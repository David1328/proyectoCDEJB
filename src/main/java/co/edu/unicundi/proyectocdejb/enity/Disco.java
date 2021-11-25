/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author David
 */
@Entity

@Table(name = "disco", schema = "disquera")

@NamedQueries({
    @NamedQuery(name = "disco.listartodos", query = "select d from Disco d"),
    @NamedQuery(name = "disco.discoExistente", query = "select d from Disco d Where d.nombre_disco =:nombre_disco")
})
@NamedNativeQuery(name = "disco.listarporid", query = "SELECT * FROM disquera.disco Where id_artista_principal = ?",resultClass = Disco.class)
public class Disco implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disco", nullable = true)
    private Integer id_disco;
    
    @NotNull(message = "Es necesario ingresar el nombre del disco")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "nombre_disco", nullable = false)
    private String nombre_disco;
    
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

    @NotNull(message = "Es necesario ingresar la cantidad de dicos")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "cant_discos", nullable = false)
    private Integer cantidad_discos;
    
    @NotNull(message = "Es necesario ingresar el precio")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name = "precio", nullable = false)
    private Integer precio;
    
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista_principal", nullable = false)
    private Cantante cantante;
     
    @Transient
    private Integer id_artista_principal;
    
    public Disco() {
    }

    public Disco(Integer id_disco, String nombre_disco, String compania_productora, String formato, String ano_lanzamiento, Integer cantidad_discos, Integer precio) {
        this.id_disco = id_disco;
        this.nombre_disco = nombre_disco;
        this.compania_productora = compania_productora;
        this.formato = formato;
        this.ano_lanzamiento = ano_lanzamiento;
        this.cantidad_discos = cantidad_discos;
        this.precio = precio;
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
     * @return the nombre_disco
     */
    public String getNombre_disco() {
        return nombre_disco;
    }

    /**
     * @param nombre_disco the nombre_disco to set
     */
    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
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
     * @return the cantidad_discos
     */
    public Integer getCantidad_discos() {
        return cantidad_discos;
    }

    /**
     * @param cantidad_discos the cantidad_discos to set
     */
    public void setCantidad_discos(Integer cantidad_discos) {
        this.cantidad_discos = cantidad_discos;
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

    /**
     * @return the cantante
     */
    @JsonIgnore
    public Cantante getCantante() {
        return cantante;
    }

    /**
     * @param cantante the cantante to set
     */
    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    /**
     * @return the id_artista_principal
     */
    public Integer getId_artista_principal() {
        return id_artista_principal;
    }

    /**
     * @param id_artista_principal the id_artista_principal to set
     */
    public void setId_artista_principal(Integer id_artista_principal) {
        this.id_artista_principal = id_artista_principal;
    }

    
    
        
}
