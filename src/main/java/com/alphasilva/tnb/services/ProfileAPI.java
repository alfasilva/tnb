/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.services;

import com.alphasilva.tnb.dao.ProfileDao;
import com.alphasilva.tnb.entities.Profile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Profile Rest responsavel por retornar informacoes para o front-end.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Path("/profile")
public class ProfileAPI implements Serializable {

    /**
     * Retorna todos os objetos do banco.
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAll() {

        System.out.println("Profile TBN GET -> getALL");
        List<Profile> retorno = new ArrayList<Profile>();
        try {
            ProfileDao dao = new ProfileDao();
            List<Profile> all = dao.findAll();
            for (Profile profile : all) {
                profile.setPassword("xxx");
                profile.setEmail("xxx");
                retorno.add(profile);
            }
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }

    /**
     * Retorna objeto do banco de acordo com o ID informado.
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getById(@PathParam("id") Integer id) {

        System.out.println("Profile GET -> findById:" + id);
        Profile retorno = new Profile();
        try {
            ProfileDao dao = new ProfileDao();
            retorno = dao.find(id);
            retorno.setPassword("xxx");
            retorno.setEmail("xxx");
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }

        return retorno;
    }

    @GET
    @Path("/prestadores")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getPrestadores() {
        System.out.println("Prestadores GET -> getPrestadores");
        List<Profile> retorno = new ArrayList<>();
        try {
            ProfileDao dao = new ProfileDao();
            List<Profile> profiles = dao.findPrestadoresAtivos();
            for (Profile profile : profiles) {
                profile.setPassword("xxx");
                profile.setEmail("xxx");
                retorno.add(profile);
            }
        } catch (Exception e) {
            System.err.println(e);
            throw new BadRequestException();
        }
        return retorno;
    }
}
