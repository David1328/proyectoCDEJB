/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.enity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

@Table(name = "cantante", schema = "disquera")

@NamedQueries({
    @NamedQuery(name = "cantante.listartodos", query = "select c from Cantante c"),
    @NamedQuery(name = "cantante.eliminarCantante",query = "Delete FROM Cantante c Where c.idCantante =:idCantante"),
    @NamedQuery(name = "cantante.nick_name", query = "select c FROM Cantante c Where c.nick_name =:nick_name")//,
    //@NamedQuery(name = "cantante.actualizar", query = "update Cantante set categoria = :categoria,nick_name = :nick_name WHERE idCantante = :idCantante")
})
public class Cantante implements Serializable {

    /*
    @NotNull(message = "Error con el id, no puede ser nulo")
    @Size(min = 1, max = 3, message = "Ingrese valores de entre 1 y 3 caracteres")*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cantante")
    private Integer idCantante;

    @NotNull(message = "Es necesario ingresar una categoria")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 15 caracteres")
    @Column(name = "categoria", nullable = false)
    private String categoria;
    
    @NotNull(message = "Es necesario ingresar el nombre artistico")
    @Size(min = 3, max = 12, message = "Ingrese valores de entre 3 y 15 caracteres")
    @Column(name = "nick_name", nullable = false, unique = true)
    private String nick_name;
    
    @OneToMany(mappedBy = "cantante", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Disco> discos = new ArrayList<>();
    
    public Cantante() {
    }

    public Cantante(String categoria, String nick_name) {
        this.categoria = categoria;
        this.nick_name = nick_name;
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
     *
     */
    public Set<ConstraintViolation<Cantante>> validar() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(this);
    }

    /**
     * @return the nick_name
     */
    public String getNick_name() {
        return nick_name;
    }

    /**
     * @param nick_name the nick_name to set
     */
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    /**
     * @return the discos
     */
    public List<Disco> getDiscos() {
        return discos;
    }

    /**
     * @param discos the discos to set
     */
    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    
    
    
}
