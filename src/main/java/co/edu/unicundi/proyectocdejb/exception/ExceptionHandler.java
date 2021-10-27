/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.exception;

import java.util.EmptyStackException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Andres Bernal, David Quintero
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ExceptionHandler implements ExceptionMapper<Exception> {
    @Context private UriInfo urlInfo;
    @Override
    public Response toResponse(Exception ex) {
        ex.printStackTrace();
        ExcepionWrraper wrraper;

        String[] error;
        if (ex instanceof NotAllowedException) {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.METHOD_NOT_ALLOWED.getStatusCode()), Response.Status.METHOD_NOT_ALLOWED.getReasonPhrase(), 
                    "Metodo no reconocido",this.urlInfo.getPath());
            return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(wrraper).build();
        } else if (ex instanceof EmptyStackException) {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.NO_CONTENT.getStatusCode()), Response.Status.NO_CONTENT.getReasonPhrase(), "No existe contenido",
                    this.urlInfo.getPath());
            return Response.status(Response.Status.NO_CONTENT).entity(wrraper).build();

        } else if (ex instanceof IllegalArgumentException) {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()), Response.Status.BAD_REQUEST.getReasonPhrase(), ex.getMessage(),
                    this.urlInfo.getPath());
            return Response.status(Response.Status.BAD_REQUEST).entity(wrraper).build();
        } else if (ex instanceof NullPointerException) {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()), Response.Status.NOT_FOUND.getReasonPhrase(), ex.getMessage(),
                    this.urlInfo.getPath());
            return Response.status(Response.Status.NOT_FOUND).entity(wrraper).build();
        } else if (ex instanceof RuntimeException) {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.CONFLICT.getStatusCode()), Response.Status.CONFLICT.getReasonPhrase(), ex.getMessage(),
                    this.urlInfo.getPath());
            return Response.status(Response.Status.CONFLICT).entity(wrraper).build();

        } else {
            wrraper = new ExcepionWrraper(String.valueOf(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(), "",
                    this.urlInfo.getPath());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(wrraper).build();
        }
    }
}
