/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.proyectocdejb.dto;

/**
 *
 * @author asantibo
 */
public class TokenDto {

    private String token;

    public TokenDto(String token) {
        this.token = token;
    }
    
    public TokenDto() {
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    
    
    
}
