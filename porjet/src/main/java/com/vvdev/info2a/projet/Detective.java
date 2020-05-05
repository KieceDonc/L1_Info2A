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
public class Detective {
    
    private Plateau plateau;
    
    private int position=0;
    private boolean hasEverMove = false;
    
    public Detective(Plateau plateau){
        this.plateau=plateau;
    }

    public int getPosition() {
        return position;
    }

    /**
     * Tell us if the detective has ever move or not
     * @return true = have ever move, false = haven't
     */
    public boolean hasEverMove() {
        return hasEverMove;
    }
    
    
    public void avancer(int nbCase){
        int max = plateau.getReserve().getSize();
        hasEverMove=true;
        nbCase-=1;
        position+=nbCase;
        if(position>=max){ // Ex position = 16, max = 16
            position-=max; // position = 16-16 = 0
        }
    }
    
}
