/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a.projet;

/**
 *
 * @author Valentin
 */
public class De {
    
    private static int[] faces = new int[]{2,3,4};

    public static int tirage(){
        return faces[(int)(Math.random()*3)];
    }
}
