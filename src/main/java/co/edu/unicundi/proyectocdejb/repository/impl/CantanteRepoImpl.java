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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author David
 */
@Stateless
public class CantanteRepoImpl implements ICantanteRepo{
    
    
    @PersistenceContext(unitName = "co.edu.unicundi_proyectoCDEJB_ejb_1.0-SNAPSHOTPU")
    private EntityManager conexion;
    
    @Override
    public List<Cantante> listar() {
        //devuelve un typeqry
        /*Query query = conexion.createQuery( "Select e " + "from cantante e");
        List<Cantante> list=(List<Cantante>)query.getResultList( );
        System.out.println("as"+list.get(0).getNombre());
        return list;*/
        TypedQuery<Cantante> info =  conexion.createNamedQuery("cantante.listartodos",Cantante.class);
        List<Cantante> listaCantante = info.getResultList();
        return listaCantante;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cantante listarId(Integer id) {
        //this.conexion.createNamedQuery("Cantante.elimnar")
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(Cantante nuevo) {
        this.conexion.persist(nuevo);
    }

    @Override
    public void actualizar(Cantante actualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer eliminar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
