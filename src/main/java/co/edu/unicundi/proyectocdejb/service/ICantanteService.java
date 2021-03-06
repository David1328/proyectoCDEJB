/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface ICantanteService {
    
    public void agregar(Cantante cancanteNuevo) throws RecursoNoEncontrado;
    public void elminarCantanteId(int idCantante) throws RecursoNoEncontrado;
    public List<Cantante> listarCantantes();
    public Cantante listarCantantePorId(String nick_name);
    public void actualizarCantante(Cantante cantanteAActualizar);
    public List<AlbumCantante> listarAlbumCantantes();
    
}
