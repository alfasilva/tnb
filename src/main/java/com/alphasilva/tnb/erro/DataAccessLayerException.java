/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.erro;

/**
 * Represents Exceptions thrown by the Data Access Layer.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class DataAccessLayerException extends RuntimeException {

    public DataAccessLayerException() {
    }

    /**
     * Default constructor SET Message of cause.
     *
     * @param message
     */
    public DataAccessLayerException(String message) {
        super("Business ERRO:"+message);
    }

    /**
     * Default constructor SET cause of Throwable.
     *
     * @param cause
     */
    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }

    /**
     * Default constructor SET cause of Message and Throwable.
     *
     * @param message
     * @param cause
     */
    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
