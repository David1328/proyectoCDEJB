/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service;

import co.edu.unicundi.proyectocdejb.enity.Admin;
import co.edu.unicundi.proyectocdejb.exception.ExceptionNoAutorizado;
import javax.ejb.Local;

/**
 *
 * @author asantibo
 */
@Local
public interface IAdminService {
    public String login(Admin datosE) throws ExceptionNoAutorizado;
}
