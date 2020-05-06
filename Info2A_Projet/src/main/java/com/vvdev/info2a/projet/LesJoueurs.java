/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a.projet;

import java.util.ArrayList;

/**
 *
 * @author vv224843
 */
public class LesJoueurs {
    
    private ArrayList<Joueur> listJ;
    
    public LesJoueurs(){
        listJ = new ArrayList();
    }
    
    public Joueur getJoueur(int i){
        return listJ.get(i);
    }
    
    public int getIndiceJoueur(Joueur j){
        if(getNbJoueurs()==0){
            return -1;
        }
        int toReturn = -1;
        int cmpt=0;
        boolean notFound = true;
        do{
            Joueur toParse = getJoueur(cmpt);
            if(toParse.getPseudo().equals(j.getPseudo())){
                toReturn = cmpt;
                notFound=false;
            }
            cmpt++;
        }while(cmpt<getNbJoueurs()&&notFound);
        return toReturn;    
        
    }
    
    public int getNbJoueurs(){
        return listJ.size();
    }
    
    public void ajouteJoueur(Joueur j) throws Exception{
        if(rechJoueur(j.getPseudo())==null){ // si le joueur n'est déjà pas présent dans la liste
            listJ.add(j);
        }else{
            throw new Exception("Player already added");
        }
    }
    
    public void ajouteJoueurs(LesJoueurs toAdd) throws Exception{
        if(toAdd.getNbJoueurs()>0){
            boolean playersCanBeAdd = true;
            int cmpt=0;
            do{
                if(getIndiceJoueur(toAdd.getJoueur(cmpt))!=-1){
                    playersCanBeAdd = false;
                    throw new Exception("One player is already in the list");
                }
                cmpt++;
            }while(cmpt<toAdd.getNbJoueurs()&&playersCanBeAdd);

            for(int x=0;x<toAdd.getNbJoueurs();x++){
                this.ajouteJoueur(toAdd.getJoueur(x));
            }
        }
    }    
    
    public Joueur rechJoueur(String playerName){
        if(getNbJoueurs()==0){
            return null;
        }
        Joueur toReturn = null;
        int cmpt=0;
        boolean notFound = true;
        do{
            Joueur toParse = getJoueur(cmpt);
            if(toParse.getPseudo().equals(playerName)){
                toReturn = toParse;
                notFound=false;
            }
            cmpt++;
        }while(cmpt<getNbJoueurs()&&notFound);
        return toReturn;
    }
    
    public void supprimeJoueur(Joueur j) throws Exception{
        int indPlayer = getIndiceJoueur(j);
        if(indPlayer!=-1){
            listJ.remove(indPlayer);
        }else{
            throw new Exception("Trying to delete a player who's not in the list");
        }
    }
    
    /**
     * Supprime toutes les données des joueurs pour permettre un nouveau tour
     */
    public void wipeDataForEveryPlayer(){
        for(int x=0;x<listJ.size();x++){
            listJ.get(x).wipeData();
        }
    }
    
    @Override
    public String toString(){
        String toReturn ="";
        for(int x=0;x<listJ.size();x++){
            toReturn+=listJ.get(x).toString()+"\n";
        }
        return toReturn;
    }
    
}
