/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.repository.ICancionRepo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author asantibo
 */
@Stateless
public class CancionRepoImpl implements ICancionRepo {

    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    /*@Override
    public void agregar(Cancion nuevo) {
        this.conexion.persist(nuevo);
    }*/
    @Override
    public int buscarNombreCancion_Artista(String nombre, String artista_productor, int id_album) {
        return this.conexion.createNamedQuery("cancion.nombrecancion_artista", Cancion.class)
                .setParameter("nombre", nombre)
                .setParameter("artista_productor", artista_productor)
                .setParameter("id_album", id_album)
                .getResultList().size();
    }

    @Override
    public int buscarNombreCancion(String nombre) {
        return this.conexion.createNamedQuery("cancion.listarcanciones_segunNombre", Cancion.class)
                .setParameter("nombre", nombre)
                .getResultList().size();
    }

    @Override
    public List<Cancion> listarcanciones_segunArtista(String artista_productor) {
        TypedQuery<Cancion> info = conexion.createNamedQuery("cancion.listarcanciones_segunArtista", Cancion.class)
                .setParameter("artista_productor", artista_productor);
        return info.getResultList();
    }

    @Override
    public List<Cancion> listarcanciones_segunNombre(String nombre) {
        TypedQuery<Cancion> info = conexion.createNamedQuery("cancion.listarcanciones_segunNombre", Cancion.class)
                .setParameter("nombre", nombre);
        return info.getResultList();
    }

    @Override
    public List<Cancion> listarCancionPorAlbum(int id_album) {
        TypedQuery<Cancion> info = conexion.createNamedQuery("cancion.listarCancionPorAlbum", Cancion.class)
                .setParameter("id_album", id_album);
        return info.getResultList();
    }
    
    @Override
    public int buscarAlbum(int id_album) {
        return this.conexion.createNamedQuery("cancion.listarCancionPorAlbum", Cancion.class)
                .setParameter("id_album", id_album).getResultList().size();
    }

    @Override
    public Cancion listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Cancion nuevo) {
        this.conexion.persist(nuevo);
    }

    @Override
    public void actualizar(Cancion actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cancion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
