/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository.impl;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.enity.Disco;
import co.edu.unicundi.proyectocdejb.repository.IDiscoRepo;
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
public class DiscoRepoImpl implements IDiscoRepo{
    
    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;

    @Override
    public List<Disco> listar() {
        TypedQuery<Disco> info = conexion.createNamedQuery("disco.listartodos", Disco.class);
        List<Disco> listaCantante = info.getResultList();
        return listaCantante;
    }

    @Override
    public Disco listarId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Disco nuevo) {
        System.out.println("Entro a la implementadion");
        this.conexion.createNativeQuery("INSERT INTO disquera.disco (nombre_disco, compania_productora, formato, ano_lanzamiento, id_artista_principal, cant_discos, precio)"
                + " VALUES (?,?,?,?,?,?,?)")
                .setParameter(1, nuevo.getNombre_disco())
                .setParameter(2, nuevo.getCompania_productora())
                .setParameter(3, nuevo.getFormato())
                .setParameter(4, nuevo.getAno_lanzamiento())
                .setParameter(5, nuevo.getCantante().getIdCantante())
                .setParameter(6, nuevo.getCantidad_discos())
                .setParameter(7, nuevo.getPrecio())
                .executeUpdate();
    }

    @Override
    public void actualizar(Disco actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disco> listarDiscosPorCante(String id_artista_principal) {
        int idCantante = ((Cantante)conexion.createNamedQuery("cantante.nick_name", Cantante.class).
                setParameter("nick_name", id_artista_principal).getSingleResult()).getIdCantante();
        TypedQuery<Disco> info = conexion.createNamedQuery("disco.listarporid", Disco.class)
                .setParameter(1, idCantante);
        List<Disco> listaCantante = info.getResultList();
        return listaCantante;
    }

    @Override
    public Disco existenciaDisco(String nombre_disco) {
        //nombre_disco
        return this.conexion.createNamedQuery("disco.discoExistente", Disco.class)
                .setParameter("nombre_disco", nombre_disco)
                .getSingleResult();
    }

   
    
}
