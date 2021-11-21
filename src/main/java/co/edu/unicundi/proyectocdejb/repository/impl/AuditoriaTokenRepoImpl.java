/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.AuditoriaToken;
import co.edu.unicundi.proyectocdejb.repository.IAuditoriaTokenRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asantibo
 */
@Stateless
public class AuditoriaTokenRepoImpl implements IAuditoriaTokenRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    @Override
    public List<AuditoriaToken> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AuditoriaToken listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(AuditoriaToken nuevo) {
        System.out.println("entro sin problemas"+nuevo.getToken());
        //this.conexion.persist(nuevo);
    }

    @Override
    public void actualizar(AuditoriaToken actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
