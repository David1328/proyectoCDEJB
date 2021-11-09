/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.Disco;
import co.edu.unicundi.proyectocdejb.repository.ICantanteRepo;
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
    private IDiscoService repo;
    
    @Override
    public List<Disco> listarDiscos() {
        return this.repo.listarDiscos();
    }

    @Override
    public void agregarDisco(Disco discoNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarDisco(Disco discoAactualizar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
