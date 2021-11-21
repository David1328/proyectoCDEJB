/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author asantibo
 */


@Entity

@Table(name = "admin", schema = "usuario")

@NamedQueries({
    @NamedQuery(name = "admin.listartodos", query = "select a from Admin a"),
    @NamedQuery(name = "admin.validarlogin", query = "select a from Admin a WHERE a.usuario = :usuario AND a.contrasena = :contrasena"),

    
})

public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Integer id;
    
    @NotNull(message = "Es necesario ingresar un usuario")
    @Size(min = 7, max = 12, message = "Ingrese valores de entre 7 y 12 caracteres")
    @Column(name = "usuario", nullable = false)
    private String usuario;
    
    @NotNull(message = "Es necesario ingresar una contrasena")
    @Size(min = 7, max = 12, message = "Ingrese valores de entre 7 y 12 caracteres")
    @Column(name = "contrasena", nullable = false)
    private String contrasena;  

    public Admin() {
    }
    
    public Admin(Integer id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
        /**
     * Metodo que envia la intancia para validar si tiene alguna violación
     *
     * @return
     *
     *
     */
    public Set<ConstraintViolation<Admin>> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }
    
    
}
