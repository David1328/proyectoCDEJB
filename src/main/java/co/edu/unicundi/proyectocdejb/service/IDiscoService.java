/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.Disco;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface IDiscoService {
    public List<Disco> listarDiscos();
    public List<Disco> listarPorId(String id_artista_principal);
    public void agregarDisco(Disco discoNuevo) throws RecursoNoEncontrado;
    public void actualizarDisco(Disco discoAactualizar);
}
