/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.repository;

import co.edu.unicundi.proyectocdejb.enity.Admin;
import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
import co.edu.unicundi.proyectocdejb.enity.AuditoriaToken;

/**
 *
 * @author asantibo
 */
public interface IAdminRepo extends ICrud<AlbumCantante, Integer>{
    public int validarUsuarioContra(Admin datosE);
    public void agregarAuditoria(Admin auditoria);
}
