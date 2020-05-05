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
    
    private Partie partie;

    public De(Partie partie) {
        this.partie=partie;
    }
    
    public int tirage(){
        int max = partie.getPlateau().jetonRestant()>=6 ? 6 : partie.getPlateau().jetonRestant();
        return (int)(Math.random()*(max+1))+1;
    }
}
