/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface ICantanteService {
    
    public void agregar(Cantante nuevo);
    public void elminarCantanteId(int idCantante);
    public List<Cantante> listarCantantes();
    
}
