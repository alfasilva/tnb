/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb;

import com.alphasilva.tnb.erro.DataAccessLayerException;
import com.alphasilva.tnb.utils.Constants;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Classe abstrata para acesso as entidades
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@Transactional
public abstract class AbstractDao implements Serializable {

    private static EntityManagerFactory entityManagerFactory = build();
    private static EntityManager entityManager;

    public AbstractDao() {
        entityManager = getEntityManager();
    }

    protected void delete(Object entity) {

        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
            throw new DataAccessLayerException(e.getMessage());
        }
    }

    protected Object find(Class clazz, Integer id) {

        Object obj = null;

        try {

            obj = entityManager.find(clazz, id);

        } catch (Exception e) {
            throw new DataAccessLayerException(e.getMessage());
        }

        return obj;
    }

    /**
     *
     * @param clazz
     * @param operation
     * @param parameters
     * @return
     */
    protected List findByParamList(Class clazz, String operation, Map<String, Object> parameters) {
        try {
            Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findBy" + operation);
            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                q.setParameter(entry.getKey().toLowerCase(), entry.getValue());
            }
            return q.getResultList();
        } catch (Exception e) {
            System.err.println("Erro " + e);
        }
        return null;
    }

    /**
     *
     * @param clazz
     * @return
     */
    protected List findAll(Class clazz) {

        Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findAll");

        return q.getResultList();
    }

    /**
     * Localiza varios registros de acordo com o parametro passado.
     *
     * @param clazz
     * @param operation
     * @param value
     * @return Object
     */
    protected List findAllByString(Class clazz, String operation, String value) {
        try {
            Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findBy" + operation);
            q.setParameter(operation.toLowerCase(), value);
            return q.getResultList();
        } catch (Exception e) {
            //Nao e um erro :)
        }
        return null;
    }

    /**
     *
     * @param clazz
     * @param id
     * @return
     */
    protected Object findById(Class clazz, Integer id) {

        Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findById");
        q.setParameter("id", id);

        return !q.getResultList().isEmpty() && q.getResultList().size() > 0 ? q.getResultList().get(0) : null;
    }

    protected List<Class> nativeFind(String sql, Class clazz) {

        List objects = null;

        try {

            Query q = entityManager.createNativeQuery(sql, clazz);
            objects = q.getResultList();

        } catch (EntityNotFoundException e) {
            throw new DataAccessLayerException(e.getMessage());
        } catch (RuntimeException e) {
            throw new DataAccessLayerException(e.getMessage());
        }
        return objects;
    }

    /**
     *
     * @param clazz
     * @param operation
     * @param value
     * @return Object
     */
    protected Object findByParam(Class clazz, String operation, String value) {

        Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findBy" + operation);
        q.setParameter(operation.toLowerCase(), value);

        return !q.getResultList().isEmpty() && q.getResultList().size() > 0 ? q.getResultList().get(0) : null;
    }

    /**
     * Localiza de um registro acordo com o objeto passado.
     *
     * @param clazz
     * @param operation
     * @param objeto
     * @return Object
     */
    protected Object findByParam(Class clazz, String operation, Object objeto) {
        try {
            Query q = entityManager.createNamedQuery(clazz.getSimpleName() + ".findBy" + operation);
            q.setParameter(operation.toLowerCase(), objeto);
            return q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }
        return null;
    }

    protected Object create(Object entity, Class clazz) throws RuntimeException {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        }
        return entity;
    }

    protected Object update(Object entity) {

        Object novo = null;

        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        }

        return novo;
    }

    /**
     * Localiza Entidade pela chave primaria usando NamedQuery.
     *
     * @param clazz
     * @param namedQuery
     * @return
     */
    protected List findByNamedQuery(Class clazz, String namedQuery) {
        try {
            Query q = entityManager.createNamedQuery(clazz.getSimpleName() + "." + namedQuery);
            return q.getResultList();
        } catch (Exception e) {
            //Nao e um erro :)
        }
        return null;
    }

    protected static EntityManagerFactory build() {
        entityManagerFactory = Persistence.createEntityManagerFactory(Constants.PU);
        return entityManagerFactory;
    }

    protected static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
