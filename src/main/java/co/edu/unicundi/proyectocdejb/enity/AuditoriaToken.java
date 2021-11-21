/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author asantibo
 */

@Entity

@Table(name = "token", schema = "auditoria")

@NamedQueries({
    @NamedQuery(name = "token.listar", query = "select c from AuditoriaToken c Where c.token = :token"),
})

public class AuditoriaToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Integer id;
    
    @NotNull(message = "Es necesario un token")
    @Size(min = 7, message = "Ingrese valores mayores de 7")
    @Column(name = "token", nullable = false)
    private String token;
    
    @NotNull(message = "Es necesaria una fecha")
    @Size(min = 7, max = 12, message = "Ingrese valores de entre 7 y 12 caracteres")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha; 

    public AuditoriaToken() {
    }

    public AuditoriaToken(Integer id, String token, LocalDateTime fecha) {
        this.id = id;
        this.token = token;
        this.fecha = fecha;
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
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the fecha
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    
    
}
