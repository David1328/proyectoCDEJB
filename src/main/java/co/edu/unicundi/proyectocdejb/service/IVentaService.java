/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.Venta;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface IVentaService{
    public void agregar(Venta nuevo) throws RecursoNoEncontrado;
    public Object obtenerTarifa(int idTipoDeProducto, int idProducto) throws RecursoNoEncontrado;
}
