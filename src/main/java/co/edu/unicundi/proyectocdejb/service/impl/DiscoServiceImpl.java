/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.Disco;
import co.edu.unicundi.proyectocdejb.repository.IDiscoRepo;
import co.edu.unicundi.proyectocdejb.service.IDiscoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author David
 */
@Stateless
public class DiscoServiceImpl implements IDiscoService{

    @EJB
    private IDiscoRepo repo;
    
    @Override
    public List<Disco> listarDiscos() {
        return this.repo.listar();
        //return null;
    }

    @Override
    public void agregarDisco(Disco discoNuevo) {
        System.out.println("entro a el service");
        this.repo.agregar(discoNuevo);
    }

    @Override
    public void actualizarDisco(Disco discoAactualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Disco> listarPorId(String id_artista) {
        System.out.println("cantidad "+this.repo.listarDiscosPorCante(id_artista).size());
        if(this.repo.listarDiscosPorCante(id_artista).isEmpty()){
            throw new NullPointerException("No existe este Cantante");//404 not found
        }else{
            return this.repo.listarDiscosPorCante(id_artista);
        }
    }
    
}
