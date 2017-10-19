/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.dao;

import com.alphasilva.tnb.AbstractDao;
import com.alphasilva.tnb.entities.Feedback;
import com.alphasilva.tnb.entities.Profile;
import java.io.Serializable;
import java.util.List;

/**
 * Classe responsavel por manipular os dados referente a Feedback no banco.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class FeedBackDao extends AbstractDao implements Serializable {

    public FeedBackDao() {}

    /**
     * Insert a new Service into the database.
     *
     * @param feedback
     * @return
     */
    public Feedback create(Feedback feedback) {
        return (Feedback) super.create(feedback, Feedback.class);
    }

    /**
     * Delete a detached Feedback from the database.
     *
     * @param feedback
     */
    public void delete(Feedback feedback) {
        super.delete(feedback);
    }

    /**
     * Find an Service by its primary key.
     *
     * @param id
     * @return
     */
    public Feedback find(Integer id) {
        return (Feedback) super.find(Feedback.class, id);
    }

    /**
     * Updates the state of a detached Feedback.
     *
     * @param feedback
     */
    public void update(Feedback feedback) {
        super.update(feedback);
    }

    /**
     * Finds all Feedback in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(Feedback.class);
    }
    /**
     * Find an Feedback by its profile.
     *
     * @param profile
     * @return 
     */
    public Feedback findByProfile(Profile profile) {
        return (Feedback) super.findByParam(Feedback.class, "Profile", profile);
    }
}
