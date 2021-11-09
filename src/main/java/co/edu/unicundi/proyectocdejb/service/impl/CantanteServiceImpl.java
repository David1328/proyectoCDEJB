/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.AlbumCantante;
import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import co.edu.unicundi.proyectocdejb.repository.IAlbumCantante;
import co.edu.unicundi.proyectocdejb.repository.ICantanteRepo;
import co.edu.unicundi.proyectocdejb.service.ICantanteService;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;

/**
 *
 * @author David
 */
@Stateless
public class CantanteServiceImpl implements ICantanteService {

    @EJB
    private ICantanteRepo repo;
    private IAlbumCantante repoalb;
    

    @Override
    public void agregar(Cantante nuevo) throws RecursoNoEncontrado{
        HashMap<String, String> errores = new HashMap();

        for (ConstraintViolation error : nuevo.validar()) {
            errores.put(error.getPropertyPath().toString(), error.getMessage());
        }
        if (errores.size() > 0) {
            throw new IllegalArgumentException(errores.toString());//400
        } else {
            if ((this.repo.buscarCantateNick_name(nuevo.getNick_name().toLowerCase()) > 0)) {
                System.out.println("Ya existe");
                throw new RecursoNoEncontrado("Ya existe este cantante");//409 conflict
            } else {
                nuevo.setNick_name(nuevo.getNick_name().toLowerCase());
                this.repo.agregar(nuevo);
            }
        }
    }

    @Override
    public List<Cantante> listarCantantes() {
        try {
            return this.repo.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void elminarCantanteId(int idCantante) throws RecursoNoEncontrado {
        try {

            if (idCantante < 0) {
                throw new IllegalArgumentException("no puede ingresar valores negativos");//400
            }
            if(this.repo.listarId(idCantante) != null){
             this.repo.eliminar(idCantante);   
            }else{
                throw new RecursoNoEncontrado("No existe el cantante");//409 conflict
            }

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void actualizarCantante(Cantante cntnt) {

        try {
            HashMap<String, String> errores = new HashMap();

            for (ConstraintViolation error : cntnt.validar()) {
                errores.put(error.getPropertyPath().toString(), error.getMessage());
            }

            if (errores.size() > 0) {
                throw new IllegalArgumentException(errores.toString());//400
            } else {
                if(this.repo.buscarCantateNick_name(cntnt.getNick_name()) == 0){
                    this.repo.actualizar(cntnt);
                }else{
                    throw new RuntimeException("Ya existe este cantante");//409 conflict
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Cantante listarCantantePorId(String nick_name) {
        try {

            if(this.repo.filtrarPorNick_name(nick_name) != null){
                return this.repo.filtrarPorNick_name(nick_name);
            }
            throw new NullPointerException("No existe este Cantante");//404 not found
        } catch (NullPointerException e) {
            throw e;
        }
    }

    @Override
    public List<AlbumCantante> listarAlbumCantantes() {
        return this.repo.listarAlbumCantantes();
    }


}
