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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;

/**
 *
 * @author David
 */
@Entity

@Table(name = "cantante",schema = "usuarios")

@NamedQueries({
    @NamedQuery(name = "cantante.listartodos",query = "select c from Cantante c")
})
public class Cantante implements Serializable{
    /*
    @NotNull(message = "Error con el id, no puede ser nulo")
    @Size(min = 1, max = 3, message = "Ingrese valores de entre 1 y 3 caracteres")*/
    @Max(value = 999, message = "no puede ingresar valores mayores a 999")
    @Min(value = 1, message = "no puede ingresar valores minimos a 1")
    @Id
    @Column(name = "id_cantante")
    private Integer idCantante;
    
    @NotNull(message = "Es necesario ingresar un nombre")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 12 caracteres")
    @Column(name =  "nombre",nullable = false)
    private String nombre;
    
    @NotNull(message = "Es necesario ingresar una categoria")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 15 caracteres")
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
    
    
    
        /**
     * Metodo que envia la intancia para validar si tiene alguna violación
     *
     * @return
     *
     * */
    public Set<ConstraintViolation<Cantante>> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
    
    
    
}
