/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a_tp7;

import java.util.ArrayList;

/**
 *
 * @author Valentin
 */
public class Ligne {
    
    private ArrayList<Gare> listGare;

    public Ligne(){
        listGare = new ArrayList<>();
    }
    
    public void addGare(Gare gare){
        listGare.add(gare);
    }
    
    
    
}
