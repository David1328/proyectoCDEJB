/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.enity.Cancion;
import co.edu.unicundi.proyectocdejb.exception.RecursoNoEncontrado;
import co.edu.unicundi.proyectocdejb.repository.ICancionRepo;
import co.edu.unicundi.proyectocdejb.service.ICancionService;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;

/**
 *
 * @author asantibo
 */
@Stateless
public class CancionServiceImpl implements ICancionService {

    @EJB
    private ICancionRepo repo;

    @Override
    public void agregar(Cancion nuevo) throws RecursoNoEncontrado {
        HashMap<String, String> errores = new HashMap();

        for (ConstraintViolation error : nuevo.validar()) {
            errores.put(error.getPropertyPath().toString(), error.getMessage());
        }
        if (errores.size() > 0) {
            throw new IllegalArgumentException(errores.toString());//400
        } else {
            if ((this.repo.buscarNombreCancion_Artista(nuevo.getNombre(), nuevo.getArtista_productor(), nuevo.getId_album()) > 0)) {
                System.out.println("Ya existe esta cancion respecto al este cantante, en este album");
                throw new RecursoNoEncontrado("este cantante ya tiene registrada esa cancion en este album");//409 conflict
            } else {
                nuevo.setArtista_productor(nuevo.getArtista_productor().toLowerCase());
                nuevo.setArtistas_secundarios(nuevo.getArtistas_secundarios().toLowerCase());
                nuevo.setNombre(nuevo.getNombre().toLowerCase());
                this.repo.agregar(nuevo);
            }
        }
    }

    @Override
    public List<Cancion> listarCancionPorArtistaAutor(String artista_productor) throws RecursoNoEncontrado {
        try {

            if ((this.repo.listarcanciones_segunArtista(artista_productor)) != null) {
                return this.repo.listarcanciones_segunArtista(artista_productor);
            } else {
                throw new RecursoNoEncontrado("no se encuentra este cantante");//409 conflict
            }
        } catch (RecursoNoEncontrado e) {
            throw e;
        }
    }

    @Override
    public List<Cancion> listarCancionPorNombre(String nombre) throws RecursoNoEncontrado {
        try {
            if (this.repo.buscarNombreCancion(nombre) > 0) {
                return this.repo.listarcanciones_segunNombre(nombre);
            } else {
                throw new RecursoNoEncontrado("no se encuentra esta cancion");//409 conflict
            }
        } catch (RecursoNoEncontrado e) {
            throw e;
        }
    }

    @Override
    public List<Cancion> listarCancionPorAlbum(int id_album) throws RecursoNoEncontrado {
        try {
            if (this.repo.buscarAlbum(id_album) > 0) {
                return this.repo.listarCancionPorAlbum(id_album);
            } else {
                throw new RecursoNoEncontrado("no se encuentra esta cancion");//409 conflict
            }
        } catch (RecursoNoEncontrado e) {
            throw e;
        }
    }

    @Override
    public List<Cancion> listarCanciones() throws RecursoNoEncontrado {
        if(this.repo.listar().isEmpty()){
            throw new NullPointerException("No existe este Cantante");//404 not found
        }else{
            return this.repo.listar();
        }
    }
}
