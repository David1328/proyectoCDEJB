/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import java.util.List;

/**
 *
 * @author David
 */
public interface ICrud<T,ID> {
    
    public List<T> listar();
    
    public T listarId(ID id);
    
    public void agregar(T nuevo);
    
    public void actualizar(T actualizar);
    
    public void eliminar(ID eliminar);
    
}
