/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a.projet;

import java.util.ArrayList;

/**
 *
 * @author Valentin
 */
public class Prison {
    
    private final static String TAG = Prison.class.getName();
    
    private Reserve prison;

    public Prison() {
        prison = new Reserve();
    }
    
    public int getNbPrisonnier(){
        return prison.getSize();
    }
    
    public void addPrisonnier(Jeton j){
        if(j.isBoss()){
            prison.addJeton(j);
        }else{
           System.out.println(TAG+", trying to add jeton in prison but jeton isn't a boss");
        }
    }
    
    /**
     * Give the boss of the current jeton by color
     * @param jeton 
     * @return null is !founded else return boss
     */
    public Jeton getJetonBossByColor(Jeton jeton){
       String color = jeton.getColor();
       boolean founded = false;
       int cmpt=0;
       do{
           if(color.equals(prison.getJeton(cmpt))){
               founded=true;
           }else{
             cmpt++;    
           }
       }while(!founded&&cmpt<prison.getSize());
       if(founded){
           return prison.getJeton(cmpt);
       }else{
           return null;
       }
    }
    
}
