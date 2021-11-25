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
    @NamedQuery(name = "admin.actualizar_datostoken", query = "update Admin set token_activo = :token_activo, fecha_actividad = :fecha_actividad WHERE usuario = :usuario AND contrasena = :contrasena")
})


public class Admin implements Serializable {

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

    @Column(name = "token_activo", nullable = false)
    private String token_activo;

    @Column(name = "fecha_actividad", nullable = false)
    private String fecha_actividad;

    public Admin() {
    }

    public Admin(Integer id, String usuario, String contrasena, String token_activo, String fecha_actividad) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.token_activo = token_activo;
        this.fecha_actividad = fecha_actividad;
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
     * @return the token_activo
     */
    public String getToken_activo() {
        return token_activo;
    }

    /**
     * @param token_activo the token_activo to set
     */
    public void setToken_activo(String token_activo) {
        this.token_activo = token_activo;
    }

    /**
     * @return the fecha_actividad
     */
    public String getFecha_actividad() {
        return fecha_actividad;
    }

    /**
     * @param fecha_actividad the fecha_actividad to set
     */
    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    /**

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
