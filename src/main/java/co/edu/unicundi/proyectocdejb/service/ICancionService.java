/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface ICancionService {
    public void agregar(Cancion cancanteNuevo) throws RecursoNoEncontrado;
    public List<Cancion> listarCancionPorArtistaAutor(String artista_productor)throws RecursoNoEncontrado;
    public List<Cancion> listarCancionPorNombre(String nombre)throws RecursoNoEncontrado;
    public List<Cancion> listarCancionPorAlbum(int id_album)throws RecursoNoEncontrado;
}
