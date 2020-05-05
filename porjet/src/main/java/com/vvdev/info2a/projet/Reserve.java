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
public class Reserve {
    
    private ArrayList<Jeton> lstJeton;

    public Reserve() {
        lstJeton = new ArrayList();
    }
    
    public void addJeton(Jeton j){
        lstJeton.add(j);
    }
    
    public void deleteJeton(int index){
        if(index>=0&&index<getSize()){
            this.lstJeton.remove(index);
        }
    }
    
    public int getSize(){
        return lstJeton.size();
    }
    
    public Jeton getJeton(int i){
        if (i>=0 && i<this.lstJeton.size())
             return this.lstJeton.get(i);
        else return null;
    }
    
    public void retireJeton(Jeton j){ 
        int i=0; 
        boolean trouve = false;
        while(i<getSize() && !trouve){
          if (getJeton(i).equals(j)){
              this.lstJeton.remove(i);  
              trouve = true;
          }
          else i++;
        }      
    }
    
    public void addJetonsFromReverse(Reserve r){
        for(int x=0;x<r.getSize();x++){
            this.addJeton(r.getJeton(x));
        }
    }

    @Override
    public String toString() {
        String toReturn ="";
        for(int x=0;x<lstJeton.size();x++){
            Jeton current = lstJeton.get(x);
            if(x!=0){
                toReturn+=" ";
            }
            toReturn+=current.toString();
            toReturn+=" -";
        }
        return toReturn;
    }
    
    
    
    
    
    
}
