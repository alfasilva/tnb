/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.auth;

import com.alphasilva.tnb.entities.Profile;
import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 * Classe responsavel guardar dados do objeto do usuario e implementar as
 * propriedadas da classe de seguranca.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class Security implements SecurityContext {

    private final Profile user;

    public Security(Profile user) {
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return (Principal) this.user;
    }

    @Override
    public boolean isUserInRole(String s) {
        return true;
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getAuthenticationScheme() {
        return "BANANINHA";
    }
}
