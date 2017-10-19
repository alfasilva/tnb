/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alphasilva.tnb.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cosntantes do sistema.
 *
 * @see Alpha-Silva
 * @author Tiago Michel <micheltiago@hotmail.com>
 * @Phone 51-992331335
 */
public class Constants implements Serializable {

    public static final String PU = "tnb_PU";

    /**
     * Retorna todos os UF
     *
     * @return
     */
    public static List<String> ufs() {
        List<String> ufs = new ArrayList<String>();
        ufs.add("AC");
        ufs.add("AL");
        ufs.add("AP");
        ufs.add("AM");
        ufs.add("BA");
        ufs.add("CE");
        ufs.add("DF");
        ufs.add("ES");
        ufs.add("GO");
        ufs.add("MA");
        ufs.add("MT");
        ufs.add("MS");
        ufs.add("MG");
        ufs.add("PA");
        ufs.add("PB");
        ufs.add("PR");
        ufs.add("PE");
        ufs.add("PI");
        ufs.add("RJ");
        ufs.add("RN");
        ufs.add("RS");
        ufs.add("RO");
        ufs.add("RR");
        ufs.add("SC");
        ufs.add("SP");
        ufs.add("SE");
        ufs.add("TO");
        return ufs;
    }
}
