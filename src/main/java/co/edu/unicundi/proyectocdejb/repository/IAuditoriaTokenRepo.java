/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.AuditoriaToken;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface IAuditoriaTokenRepo extends ICrud<AuditoriaToken, Integer>{
    
}
