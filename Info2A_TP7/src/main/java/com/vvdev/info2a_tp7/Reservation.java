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
public class Reservation {
    
    private String nom;
    private String prenom;
    private String numIdentificationPassager;
    private int num;
    private boolean reserved = false;

    public Reservation(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void makeAReservation(String nom,String prenom,String numIdentificationPassager) {
        this.nom = nom;
        this.prenom = prenom;
        this.numIdentificationPassager=numIdentificationPassager;
        this.reserved = true;
    }
    
    public void deliverAReservation(){
        this.nom = null;
        this.prenom = null;
        this.numIdentificationPassager=null;
        this.reserved = true;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumIdentificationPassager() {
        return numIdentificationPassager;
    }

    @Override
    public String toString() {
        return "Reservation{, num=" + num + "nom=" + nom + ", prenom=" + prenom + ", numIdentificationPassager=" + numIdentificationPassager +", reserved=" + reserved + '}';
    }
    
    
    
    
    
}
