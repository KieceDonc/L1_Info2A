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
public class Voiture extends Wagon {
    
    private ArrayList<Reservation> listReservation;
    
    private int classeType; // 1 = première classe, 2 = deuxième classe, 3= ....
    private int nbPlaces;
    
    public Voiture(String numIdentification, double masse, int classeType,int nbPlaces) {
        super(numIdentification, masse);
        this.classeType = classeType;
        this.nbPlaces = nbPlaces;
        initListReservation();
    }
    
    private void initListReservation(){
        listReservation = new ArrayList<>();
        for(int x=0;x<nbPlaces;x++){
            Reservation currentReservation = new Reservation(x);
            listReservation.add(currentReservation);
        }
    }

    public int getClasseType() {
        return classeType;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }
            
    public void makeAReservation(String nom,String prenom, String numIdenficitationPassager, int wantedPlace){
        if(wantedPlace>0&&wantedPlace<=nbPlaces){
            if(!placeAlreadyTaken(wantedPlace)){
                getReservationAt(wantedPlace).makeAReservation(nom, prenom, numIdenficitationPassager);
            }
        }
    }
    
    public void deliverAReservation(int oldPlace){
        if(oldPlace<=nbPlaces){
            getReservationAt(oldPlace).deliverAReservation();
        }
    }
    
    public boolean placeAlreadyTaken(int wantedPlace){
        if(wantedPlace<=nbPlaces){
            return getReservationAt(wantedPlace).isReserved();
        }
        return true;
    }
    
    public Reservation getReservationAt(int index){
        if(index<=nbPlaces){
            return listReservation.get(index);
        }
        return null;
    }
    
    public boolean equals(Voiture v){
        return getMasse()==v.getMasse()
                &&
                getNumIdentification().equals(v.getNumIdentification())
                &&
                getClasseType()==v.getClasseType()
                &&
                getNbPlaces()==v.getNbPlaces();
    }
    
    public String toString(){
        String toReturn="Voiture:{\nnumIndenfication = "+getNumIdentification()+", masse = "+getMasse()+"classeType = "+classeType+", nbPlaces = "+nbPlaces+"";
        for(int x=0;x<nbPlaces;x++){
            toReturn+="\n"+listReservation.get(x).toString();
        }
        toReturn+="\n}";
        return toReturn;
    }
    
    
    
}
