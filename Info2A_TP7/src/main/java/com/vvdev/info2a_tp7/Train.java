/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a_tp7;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Valentin
 */
public class Train {
    
    private static final String TAG = Train.class.getName();
    
    private String numIdentification;
    private Date dateDepart;
    private Locomotive locomotive;
    private ArrayList<Voiture> voitures;
    private ArrayList<WagonMarchandise> wagonsMarchandises;

    public Train(String numIdentification, Date dateDepart, Locomotive locomotive) {
        this.numIdentification = numIdentification;
        this.dateDepart = dateDepart;
        this.locomotive = locomotive;
        this.voitures = new ArrayList<>();
        this.wagonsMarchandises = new ArrayList<>();
    }

    public String getNumIdentification() {
        return numIdentification;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public ArrayList<Voiture> getVoitures() {
        return voitures;
    }
    
    public Voiture getVoiture(int index){
        return voitures.get(index);
    }
    
    public WagonMarchandise getWagonMarchandise(int index){
        return wagonsMarchandises.get(index);
    }

    public ArrayList<WagonMarchandise> getWagonsMarchandises() {
        return wagonsMarchandises;
    }
    
    public void addVoiture(Voiture voiture){
        if(canWagonBeAdded(voiture.getMasse())){
            voitures.add(voiture); 
        }else{
            System.out.println(TAG+": "+voiture.toString()+" couldn't be added cuz total mass < this voiture mass + the other wagons mass");
        }
    }
    
    public void addWagonMarchandise(WagonMarchandise wm){
        if(wm.getMasseEffectif()<=wm.getMasseMaxTransport()&&canWagonBeAdded(wm.getMasse()+wm.getMasseEffectif())){
            wagonsMarchandises.add(wm);
        }else{
            System.out.println(TAG+": "+wm.toString()+" couldn't be added cuz total mass < this wagon marchandise mass + the other wagons mass");
        }
        
    }
    
    public void deleteVoiture(int index){
        voitures.remove(index);
    }
    
    public void deleteWagonMarchandise(int index){
        wagonsMarchandises.remove(index);
    }
    
    public void deleteVoiture(Voiture v){
        if(voitures.size()>0){
            boolean founded=false;
            int index = -1;
            do{
                index++;
                if(voitures.get(index).equals(v)){
                    founded=true;
                }
            }while(index<voitures.size()&&!founded);   
            deleteVoiture(index);
        }
    }
    
    public void deleteWagonMarchandise(WagonMarchandise wm){
        if(wagonsMarchandises.size()>0){
            boolean founded=false;
            int index = -1;
            do{
                index++;
                if(wagonsMarchandises.get(index).equals(wm)){
                    founded=true;
                }
            }while(index<voitures.size()&&!founded);   
            deleteVoiture(index);
        }
    }
    
    public double masseTotalTrain(){
        double masseTotal = 0;
        for(int x=0;x<voitures.size();x++){
            masseTotal+=voitures.get(x).getMasse();
        }
        for(int x=0;x<wagonsMarchandises.size();x++){
            WagonMarchandise wm = wagonsMarchandises.get(x);
            masseTotal+=wm.getMasse();
            masseTotal+=wm.getMasseEffectif();            
        }
        return masseTotal;
    }
    
    public boolean canWagonBeAdded(double masseTotalToAdd){
        return masseTotalToAdd+masseTotalTrain()<locomotive.getMasseMax();
    }

    @Override
    public String toString() {
        String toReturn = "Train{\n" + "numIdentification=" + numIdentification + "\ndateDepart=" + dateDepart.toString() + "\nlocomotive=" + locomotive.toString();
        for(int x=0;x<voitures.size();x++){
            toReturn+="\n"+voitures.get(x).toString();
        }
        for(int x=0;x<wagonsMarchandises.size();x++){
            toReturn+="\n"+wagonsMarchandises.get(x).toString();
        }
        toReturn+="\n}";
        return toReturn;
    }
    
    
    
    
    
    
    
    
}
