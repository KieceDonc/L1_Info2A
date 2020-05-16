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
public class Plateau {
    
    private Reserve reserve;
    private Detective detective;

    public Plateau() {
        reserve= new Reserve();
        detective = new Detective(this);
        
        for (String currentColor : Jeton.allColor) {
            // for each color
            for (int y = 0; y<Jeton.allType.length; y++) {
                // for each type of gangster
                switch (y) {
                    case 0:
                        {
                            // create and add boss jeton
                            Jeton boss = new Jeton(Jeton.allType[0], currentColor);
                            reserve.addJeton(boss);
                            break;
                        }
                    case 1:
                        {
                            // create and add 1 gangster 1 jeton
                            Jeton ganster_1 = new Jeton(Jeton.allType[1], currentColor);
                            reserve.addJeton(ganster_1);
                            break;
                        }
                    case 2:
                        {
                            // create and add 2 gangster 2 jeton
                            Jeton ganster_2_1 = new Jeton(Jeton.allType[2], currentColor);
                            Jeton ganster_2_2 = new Jeton(Jeton.allType[2], currentColor);
                            reserve.addJeton(ganster_2_1);
                            reserve.addJeton(ganster_2_2);
                            break;
                        }
                    case 3:
                        {
                            // create and add 1 gangster 3 jeton
                            Jeton ganster_3 = new Jeton(Jeton.allType[3], currentColor);
                            reserve.addJeton(ganster_3);
                            break;
                        }
                    case 4:
                        {
                            // create and add 1 PotDeVin jeton
                            Jeton potDeVin = new Jeton(Jeton.allType[4], currentColor);
                            reserve.addJeton(potDeVin);
                        }
                }
            }
        }
        
        reserve.melange();
    }
    
    public Reserve getReserve(){
        return reserve;
    }
    
    public Detective getDetective(){
        return detective;
    }
    
    public int jetonRestant(){
        return reserve.getSize();
    }
    
    public Jeton getJetonOnDetectivePosition(){
        return reserve.getJeton(detective.getPosition());
    }

    @Override
    public String toString() {
        String toReturn ="";
        for(int x=0;x<reserve.getSize();x++){
            Jeton current = reserve.getJeton(x);
            if(detective.hasEverMove()){
                if(x==detective.getPosition()){
                    if(x!=0){
                        toReturn+=" <> - ";
                    }else{
                        toReturn+="<> - ";
                    }
                    toReturn+=current.toString()+" -";
                }else{
                    if(x!=0){
                        toReturn+=" ";
                    }
                    toReturn+=current.toString()+" -";
                }
           }else{
                if(x==0){
                    toReturn+="<> - ";   
                }else{
                    toReturn+=" ";
                }
                toReturn+=current.toString()+" -";
            }
        }
        if(detective.getPosition()==reserve.getSize()){
            toReturn+=" <>";
        }
        return toReturn;
    }
    
    
    
}
