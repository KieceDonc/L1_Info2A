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
public class Locomotive {
    
    private String numIdentification;
    private double masseMax;

    public Locomotive(String numIdentification, double masseMax) {
        this.numIdentification = numIdentification;
        this.masseMax = masseMax;
    }

    public String getNumIdentification() {
        return numIdentification;
    }

    public double getMasseMax() {
        return masseMax;
    }

    @Override
    public String toString() {
        return "Locomotive{" + "numIdentification=" + numIdentification + ", masseMax=" + masseMax + '}';
    }
    
}
