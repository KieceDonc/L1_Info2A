/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a.projet;

import javax.swing.ImageIcon;

/**
 *
 * @author Valentin
 */
public class Joueur {
    
    private String pseudo;
    private Reserve reserve;
    private int score =0;
    
    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        reserve = new Reserve();
    }

    public String getPseudo() {
        return pseudo;
    }

    public Reserve getReserve() {
        return reserve;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setReserve(Reserve reserve) {
        this.reserve = reserve;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Supprime tout les données de cette instance de Joueur permettant un nouveau tour
     */
    public void wipeData(){
        reserve = new Reserve();
        score = 0;
    }
    
    public boolean equals(Joueur j){
        return j.getPseudo().equals(this.pseudo);
    }

    @Override
    public String toString() {
        return this.getPseudo()+" : "+reserve.toString();
    }
    
    
    

    
    
}
