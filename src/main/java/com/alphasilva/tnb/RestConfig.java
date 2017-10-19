/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb;

import java.io.Serializable;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Classe utilizada para configurar o contexto Path da aplicacao.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
@ApplicationPath("/")
public class RestConfig extends Application implements Serializable {
}
