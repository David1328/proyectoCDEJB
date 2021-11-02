/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.Disco;
import javax.ejb.Local;

/**
 *
 * @author David
 */
@Local
public interface IDiscoRepo extends ICrud<Disco, Integer>{
    
}
