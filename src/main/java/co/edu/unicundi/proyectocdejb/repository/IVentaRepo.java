/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.enity.Venta;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface IVentaRepo extends ICrud<Venta, Integer>{
    public Cancion buscarCancion(String IdTipo_venta);
    public int buscarAlbum(String IdTipo_venta);
    public void venderActualizarCancion(Cancion cancion);
    public Venta obtenerTarifa(int idTipoDeProducto,int idProducto);
}
