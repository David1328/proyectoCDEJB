/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.repository.ICantanteRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author David
 */
@Stateless
public class CantanteRepoImpl implements ICantanteRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    @Override
    public List<Cantante> listar() {
        TypedQuery<Cantante> info = conexion.createNamedQuery("cantante.listartodos", Cantante.class);
        List<Cantante> listaCantante = info.getResultList();
        return listaCantante;
    }

    @Override
    public Cantante listarId(Integer id) {
        return this.conexion.createNamedQuery("cantante.listarPorId", Cantante.class).setParameter("idCantante", id).getResultList().get(0);
    }

    @Override
    public void agregar(Cantante nuevo) {
        this.conexion.persist(nuevo);
    }

    @Override
    public void actualizar(Cantante actualizar) {
        System.out.println("actualizar"+actualizar.getNick_name());
        conexion.createNamedQuery("cantante.actualizar", Cantante.class)
                .setParameter("nombre", actualizar.getNombre())
                .setParameter("categoria", actualizar.getCategoria())
                .setParameter("idCantante", actualizar.getIdCantante()) 
                .setParameter("nick_name", actualizar.getNick_name()).executeUpdate();
    }

    @Override
    public void eliminar(Integer eliminar) {
        this.conexion.createNamedQuery("cantante.eliminarCantante", Cantante.class).setParameter("idCantante", eliminar)
                .executeUpdate();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
