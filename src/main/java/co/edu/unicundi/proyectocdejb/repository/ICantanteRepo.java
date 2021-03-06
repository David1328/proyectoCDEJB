/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
import co.edu.unicundi.proyectocdejb.enity.Cantante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface ICantanteRepo extends ICrud<Cantante, Integer>{

    public Cantante filtrarPorNick_name(String nick_name);
    public int buscarCantateNick_name(String nombre);
    public List<AlbumCantante> listarAlbumCantantes();
}
