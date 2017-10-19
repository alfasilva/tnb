/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.auth;

import com.alphasilva.tnb.entities.Profile;
import java.util.Date;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

/**
 * Classe responsavel por manter a seguranca do request do usuário.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Provider
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        System.out.println("RequestFilter ----> Access Token");
        Profile user = new Profile(7, "Tiago Michel", "micheltiago@hotmail.com", new Date(), true);
        requestContext.setSecurityContext(new Security(user));
    }
}
