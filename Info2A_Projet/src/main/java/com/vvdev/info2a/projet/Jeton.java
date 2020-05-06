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
public class Jeton {
    
    public final static String boss = "Boss";
    public final static String gangster1 = "gangster_1";
    public final static String gangster2 = "gangster_2";
    public final static String gangster3 = "gangster_3";
    public final static String potDeVin = "PotDeVin";
    public final static String[] allColor = new String[]{"rouge","bleu","vert","jaune","rose","orange","violet"};
    public final static String[] allType = new String[]{boss,gangster1,gangster2,gangster3,potDeVin};

    
    private String type="";
    private String color="";

    public Jeton(String type,String color) {
        setType(type);
        setColor(color);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isBoss(){
        return this.getType().equals(boss);
    }
    
    public boolean isGangster1(){
        return this.getType().equals(gangster1);
    }
    
    public boolean isGangster2(){
        return this.getType().equals(gangster2);
    }
    
    public boolean isGangster3(){
        return this.getType().equals(gangster3);
    }
    
    public boolean isPotDeVin(){
        return this.getType().equals(potDeVin);
    }

    @Override
    public String toString() {
        String gang = color.substring(0, 1).toUpperCase(); // get the first letter of the gang name. Ex rouge = R
        if(isBoss()){
            return "["+gang+"]";
        }else if(isGangster1()){
            return "1"+gang;
        }else if(isGangster2()){
            return "2"+gang;
        }else if(isGangster3()){
            return "3"+gang;
        }else{
            return "$"+gang;
        }
    }
    
    
   
    
    
    
    
    
}
