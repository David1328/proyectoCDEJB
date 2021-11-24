/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.Admin;
import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
import co.edu.unicundi.proyectocdejb.enity.AuditoriaToken;
import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.repository.IAdminRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asantibo
 */
@Stateless
public class AdminRepoImpl implements IAdminRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    @Override
    public int validarUsuarioContra(Admin datosE) {
        return this.conexion.createNamedQuery("admin.validarlogin", Cancion.class)
                .setParameter("usuario", datosE.getUsuario())
                .setParameter("contrasena", datosE.getContrasena())
                .getResultList().size();
    }

    @Override
    public List<AlbumCantante> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlbumCantante listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(AlbumCantante nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(AlbumCantante actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarAuditoria(Admin datosE) {
        this.conexion.createNamedQuery("admin.actualizar_datostoken", Admin.class)
                .setParameter("token_activo", datosE.getToken_activo())
                .setParameter("fecha_actividad", datosE.getFecha_actividad())
                .setParameter("usuario", datosE.getUsuario())
                .setParameter("contrasena", datosE.getContrasena()).executeUpdate();
    }
}
