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
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author asantibo
 */

@Entity

@Table(name = "venta", schema = "venta")

@NamedQueries({
    @NamedQuery(name = "venta.listartodos", query = "select v from Venta v")
})
@NamedNativeQuery(name = "venta.cancionId", query = "SELECT * FROM disquera.cancion Where id = ?",resultClass = Cancion.class)
//@NamedNativeQuery(name = "venta.cancionId", query = "SELECT * FROM disquera.cancion Where id = ?",resultClass = Venta.class)
public class Venta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Integer id;
    
    @NotNull(message = "Es necesario ingresar una cedula")
    @Size(min = 7, max = 12, message = "Ingrese valores de entre 7 y 12 caracteres")
    @Column(name = "cedula", nullable = false)
    private String cedula;
    
    @NotNull(message = "Es necesario ingresar una cantidad")
    @Min(1)
    @Max(50)
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @NotNull(message = "Es necesario ingresar una descripcion de la compra")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
        
    @NotNull(message = "Es necesario ingresar un tipo de venta")//cancion-1,album-2
    @Column(name = "tipo_venta", nullable = false)
    private Integer tipo_venta;
    
    @NotNull(message = "Es necesario ingresar un id de la cancion o album vendido")
    @Column(name = "id_tipo_venta", nullable = false)
    private String idTipo_venta;    
    
    
    @Transient
    private String tipoDeProdcuto;
    
    @Transient
    private String ventaProducto;
    
    @Transient
    private int precioProducto;
    
    public Venta() {
    }

    public Venta(Integer id, String cedula, Integer cantidad, String descripcion, Integer tipo_venta, String idTipo_venta) {
        this.id = id;
        this.cedula = cedula;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.tipo_venta = tipo_venta;
        this.idTipo_venta = idTipo_venta;
    }
    
        /**
     * Metodo que envia la intancia para validar si tiene alguna violación
     *
     * @return
     *
     *
     */
    public Set<ConstraintViolation<Venta>> validar() {
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
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipo_venta
     */
    public Integer getTipo_venta() {
        return tipo_venta;
    }

    /**
     * @param tipo_venta the tipo_venta to set
     */
    public void setTipo_venta(Integer tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    /**
     * @return the idTipo_venta
     */
    public String getIdTipo_venta() {
        return idTipo_venta;
    }

    /**
     * @param idTipo_venta the idTipo_venta to set
     */
    public void setIdTipo_venta(String idTipo_venta) {
        this.idTipo_venta = idTipo_venta;
    }

    /**
     * @return the tipoDeProdcuto
     */
    public String getTipoDeProdcuto() {
        return tipoDeProdcuto;
    }

    /**
     * @param tipoDeProdcuto the tipoDeProdcuto to set
     */
    public void setTipoDeProdcuto(String tipoDeProdcuto) {
        this.tipoDeProdcuto = tipoDeProdcuto;
    }

    /**
     * @return the ventaProducto
     */
    public String getVentaProducto() {
        return ventaProducto;
    }

    /**
     * @param ventaProducto the ventaProducto to set
     */
    public void setVentaProducto(String ventaProducto) {
        this.ventaProducto = ventaProducto;
    }

    /**
     * @return the precioProducto
     */
    public int getPrecioProducto() {
        return precioProducto;
    }

    /**
     * @param precioProducto the precioProducto to set
     */
    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}