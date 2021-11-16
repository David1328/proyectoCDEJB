/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.enity.Venta;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import co.edu.unicundi.proyectocdejb.repository.IVentaRepo;
import co.edu.unicundi.proyectocdejb.service.IVentaService;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;

/**
 *
 * @author asantibo
 */
@Stateless
public class VentaServiceImpl implements IVentaService {

    @EJB
    private IVentaRepo repo;

    @Override
    public void agregar(Venta nuevo) throws RecursoNoEncontrado {
        Cancion cancion = new Cancion();
        HashMap<String, String> errores = new HashMap();

        for (ConstraintViolation error : nuevo.validar()) {
            errores.put(error.getPropertyPath().toString(), error.getMessage());
        }
        if (errores.size() > 0) {
            throw new IllegalArgumentException(errores.toString());//400
        } else {
            //cancion
            if (nuevo.getTipo_venta() == 1) {
                cancion=this.repo.buscarCancion(nuevo.getIdTipo_venta());
                if (cancion != null) {
                    if (cancion.getCopias_fisicas() > 0) {
                        cancion.setCopias_fisicas(cancion.getCopias_fisicas()-1);
                        this.repo.venderActualizarCancion(cancion);
                        this.repo.agregar(nuevo);
                    }else{
                        System.out.println("No existe disponibilidad");
                        throw new RecursoNoEncontrado("No existe disponibilidad");//409 conflict
                    }

                } else {
                    System.out.println("No existe esta cancion");
                    throw new RecursoNoEncontrado("No existe esta cancion");//409 conflict
                }
                //disco
            } else{
                System.out.println("va a vender un disco");
            }
        }
    }

}
