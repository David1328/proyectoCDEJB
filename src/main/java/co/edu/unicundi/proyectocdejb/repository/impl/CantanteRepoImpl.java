/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
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
        return info.getResultList();
    }

    @Override
    public Cantante listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
    }
    
    @Override
    public List<AlbumCantante> listarAlbumCantantes() {
        TypedQuery<AlbumCantante> info = conexion.createNamedQuery("album_cantante.listartodos", AlbumCantante.class);
        List<AlbumCantante> listaAlbumCantante = info.getResultList();
        return listaAlbumCantante;
    }

    @Override
    public int buscarCantateNick_name(String nombre) {
        return this.conexion.createNamedQuery("cantante.nick_name", Cantante.class)
                .setParameter("nick_name", nombre).getResultList().size();
    }

    @Override
    public Cantante filtrarPorNick_name(String nick_name) {
        int cantidad = this.conexion.createNamedQuery("cantante.nick_name", Cantante.class)
                .setParameter("nick_name", nick_name).getResultList().size();
        return cantidad==0?null:this.conexion.createNamedQuery("cantante.nick_name", Cantante.class)
                .setParameter("nick_name", nick_name).getResultList().get(0);
    }

    

}
