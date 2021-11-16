/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.enity.Cantante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface ICancionRepo extends ICrud<Cancion, Integer>{

    public int buscarNombreCancion_Artista(String nombre_cancion,String artista_principal, int id_album);
    public int buscarNombreCancion(String nombre);
    public List<Cancion> listarcanciones_segunArtista (String artista_productor);
    public List<Cancion> listarcanciones_segunNombre (String nombre);
    public int buscarAlbum(int id_album);
    public List<Cancion> listarCancionPorAlbum(int id_album);
    
}
