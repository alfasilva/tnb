/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.dao;

import com.alphasilva.tnb.AbstractDao;
import com.alphasilva.tnb.entities.Endereco;
import com.alphasilva.tnb.entities.Profile;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Endereco no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class EnderecoDao extends AbstractDao implements Serializable {

    public EnderecoDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param endereco
     * @return
     */
    public Endereco create(Endereco endereco) {
        return (Endereco) super.create(endereco, Endereco.class);
    }

    /**
     * Delete a detached Endereco from the database.
     *
     * @param endereco
     */
    public void delete(Endereco endereco) {
        super.delete(endereco);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Endereco find(Integer id) {
        return (Endereco) super.find(Endereco.class, id);
    }

    /**
     * Updates the state of a detached Endereco.
     *
     * @param endereco
     */
    public void update(Endereco endereco) {
        super.update(endereco);
    }

    /**
     * Finds all Endereco in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(Endereco.class);
    }
    /**
     * Find an Endereco by its profile.
     *
     * @param profile
     * @return 
     */
    public Endereco findByProfile(Profile profile) {
        return (Endereco) super.findByParam(Endereco.class, "Profile", profile);
    }
}
