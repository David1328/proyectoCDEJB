/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.Cantante;
import co.edu.unicundi.proyectocdejb.repository.ICantanteRepo;
import co.edu.unicundi.proyectocdejb.service.ICantanteService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;

/**
 *
 * @author David
 */
@Stateless
public class CantanteServiceImpl implements ICantanteService {

    @EJB
    private ICantanteRepo repo;

    @Override
    public void agregar(Cantante nuevo) {
        try {
            HashMap<String, String> errores = new HashMap();
            List<Cantante> listCantantes = this.listarCantantes();

            for (ConstraintViolation error : nuevo.validar()) {
                errores.put(error.getPropertyPath().toString(), error.getMessage());
            }

            if (errores.size() > 0) {
                throw new IllegalArgumentException(errores.toString());//400
            } else {
                for (Cantante LC : listCantantes) {
                    if (LC.getIdCantante().equals(nuevo.getIdCantante())) {
                        throw new RuntimeException("Ya existe este id");//409 conflict
                    }
                }
                this.repo.agregar(nuevo);
            }
        } catch (Exception e) {
            throw e;
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
    public void elminarCantanteId(int idCantante) {
        try {

            if (idCantante < 0) {
                throw new IllegalArgumentException("no puede ingresar valores negativos");//400
            }

            this.repo.eliminar(idCantante);

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
                this.repo.actualizar(cntnt);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Cantante listarCantantePorId(int idCantante) {
        try {
            List<Cantante> listCantantes = this.listarCantantes();

            for (Cantante LC : listCantantes) {
                if (LC.getIdCantante().equals(idCantante)) {
                    return this.repo.listarId(idCantante);
                }
            }
            throw new NullPointerException("No existe este identificador");//404 not found
        } catch (NullPointerException e) {
            throw e;
        }
    }

}
