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
public class WagonMarchandise extends Wagon {
    
    private double masseMaxTransport; // masse maximale qu'il peut transporter
    private double masseEffectif; //masse des marchandises
    private String descriptif;

    public WagonMarchandise(String numIdentification, double masse,double masseMaxTransport, double masseEffectif, String descriptif) {
        super(numIdentification, masse);
        this.masseMaxTransport = masseMaxTransport;
        this.masseEffectif = masseEffectif;
        this.descriptif = descriptif;
    }

    public double getMasseMaxTransport() {
        return masseMaxTransport;
    }

    public double getMasseEffectif() {
        return masseEffectif;
    }

    public String getDescriptif() {
        return descriptif;
    }
 
    public boolean equals(WagonMarchandise wm){
        return getMasse()==wm.getMasse()
                &&
                getNumIdentification().equals(wm.getNumIdentification())
                &&
                getMasseMaxTransport()==wm.getMasseMaxTransport()
                &&
                getMasseEffectif()==wm.getMasseEffectif()
                &&
                getDescriptif().equals(wm.getDescriptif());
    }

    @Override
    public String toString() {
        return "WagonMarchandise{" + "masseMaxTransport=" + masseMaxTransport + ", masseEffectif=" + masseEffectif + ", descriptif=" + descriptif + '}';
    }
        
}
