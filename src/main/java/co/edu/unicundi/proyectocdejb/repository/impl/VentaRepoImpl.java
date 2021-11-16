/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.enity.Venta;
import co.edu.unicundi.proyectocdejb.repository.IVentaRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author asantibo
 */
@Stateless
public class VentaRepoImpl implements IVentaRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    @Override
    public Cancion buscarCancion(String id_cancion) {
        int id = Integer.parseInt(id_cancion);
        return this.conexion.createNamedQuery("cancion.infoCancion", Cancion.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void venderActualizarCancion(Cancion cancion) {
        this.conexion.createNamedQuery("cancion.actualizarCopias", Cancion.class)
                .setParameter("copias_fisicas", cancion.getCopias_fisicas())
                .setParameter("id", cancion.getId());
    }

    @Override
    public void agregar(Venta nuevo) {
        this.conexion.persist(nuevo);
    }

    @Override
    public int buscarAlbum(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Venta actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
