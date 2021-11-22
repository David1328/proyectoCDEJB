/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.service.impl;

import co.edu.unicundi.proyectocdejb.dto.TokenDto;
import co.edu.unicundi.proyectocdejb.enity.Admin;
import co.edu.unicundi.proyectocdejb.enity.AuditoriaToken;
import co.edu.unicundi.proyectocdejb.exception.ExceptionNoAutorizado;
import co.edu.unicundi.proyectocdejb.repository.IAdminRepo;
import co.edu.unicundi.proyectocdejb.service.IAdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;

/**
 *
 * @author asantibo
 */
@Stateless
public class AdminServiceImpl implements IAdminService {

    @EJB
    private IAdminRepo repo;

    @Override
    public String login(Admin datosE) throws ExceptionNoAutorizado {
        HashMap<String, String> errores = new HashMap();

        for (ConstraintViolation error : datosE.validar()) {
            errores.put(error.getPropertyPath().toString(), error.getMessage());
        }
        if (errores.size() > 0) {
            throw new IllegalArgumentException(errores.toString());//400
        } else {
            //cifrar contra
            String contrasena = datosE.getContrasena();
            datosE.setContrasena(Base64.getEncoder().encodeToString(contrasena.getBytes()));

            if ((this.repo.validarUsuarioContra(datosE)) > 0) {
                String key = "qiq*nFdWbvd9Wd6F";
                long tiempo = System.currentTimeMillis();

                Map<String, Object> permisos = new HashMap();
                permisos.put("1", "Admin");//clave valor de la base de datos

                String jwt = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS512, key)
                        .setSubject(datosE.getUsuario())
                        .setIssuedAt(new Date(tiempo))
                        .setExpiration(new Date(tiempo + 900000))
                        .claim("permisos", permisos)
                        .compact();
                TokenDto token = new TokenDto();
                token.setToken(jwt);
                AuditoriaToken auditoria = new AuditoriaToken();
                auditoria.setToken(jwt);
//                this.repo.agregarAuditoria(auditoria);
                return token.getToken();
            } else {
                //401 No autorizado
                throw new ExceptionNoAutorizado("Usuario u/o contrasena incorrecta");
            }

        }
    }

}
