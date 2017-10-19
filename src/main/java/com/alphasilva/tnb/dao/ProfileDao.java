/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.dao;

import com.alphasilva.tnb.AbstractDao;
import com.alphasilva.tnb.entities.Profile;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por manipular os dados referente a Profile no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class ProfileDao extends AbstractDao implements Serializable {

    /**
     * Insert a new Service into the database.
     *
     * @param profile
     * @return
     */
    public Profile create(Profile profile) {
        return (Profile) super.create(profile, Profile.class);
    }

    /**
     * Delete a detached Profile from the database.
     *
     * @param profile
     */
    public void delete(Profile profile) {
        super.delete(profile);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Profile find(Integer id) {
        return (Profile) super.find(Profile.class, id);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param email
     * @return
     */
    public Profile findByEmail(String email) {
        return (Profile) super.findByParam(Profile.class, "Email", email);
    }

    /**
     * Find an Profile by its name.
     *
     * @param nome
     * @return
     */
    public List findByNome(String nome) {
        return super.findAllByString(Profile.class, "Nome", nome);
    }

    /**
     * Updates the state of a detached Profile.
     *
     * @param profile
     */
    public void update(Profile profile) {
        super.update(profile);
    }

    /**
     * Finds all Services in the database.
     *
     * @return
     */
    public List<Profile> findAll() {
        return super.findAll(Profile.class);
    }

    /**
     * Autentica usuario na base de dados do Grimpeiro valida e-mail senha e se
     * o usuario esta ativo.
     *
     * @param email
     * @param senha
     * @return
     */
    public Profile authenticar(String email, String senha) {
        Map<String, Object> mapa = new HashMap<String, Object>();
        mapa.put("Email", email);
        mapa.put("Password", senha);
        List<Profile> l = super.findByParamList(Profile.class, "Authenticacao", mapa);
        if (!l.isEmpty() && l.size() <= 0) {
            return null;
        } else {
            return l.get(0);
        }
    }

    /**
     * Localiza na base todos os prestadores ativos.
     *
     * @return
     */
    public List<Profile> findPrestadoresAtivos() {
        return super.findByNamedQuery(Profile.class, "findByPrestadorAtivo");
    }   
}
