/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a_tp7;

/**
 *
 * @author Valentin
 */
public class Wagon {
    
    private String numIdentification;
    private double masse;

    public Wagon(String numIdentification,double masse) {
        this.numIdentification = numIdentification;
        this.masse = masse;
    }

    public String getNumIdentification() {
        return numIdentification;
    }

    public double getMasse() {
        return masse;
    }
     
}
