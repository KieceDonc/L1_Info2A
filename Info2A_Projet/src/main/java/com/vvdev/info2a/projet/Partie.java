/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a.projet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class Partie {
    
    private Plateau plateau;
    private LesJoueurs lesJoueurs;
    private Prison prison;
    private De de;
    private Joueur currentPlayer;
    
    
    public Partie(){
        settingsUpParty();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public LesJoueurs getLesJoueurs() {
        return lesJoueurs;
    }

    public Prison getPrison() {
        return prison;
    }

    public Joueur getCurrentPlayer() {
        return currentPlayer;
    }  
    
    /**
     * Settings up the party
     */
    private void settingsUpParty(){
        lesJoueurs = new LesJoueurs();
        prison = new Prison();
        plateau = new Plateau();
        de = new De(this);
        for(int x=0;x<askNumberPlayer();x++){
            createJoueur(x);
        }
        play();
    }
    
    /**
     * Ask to user how much player are going to play
     * @return number of user 
     */
    private int askNumberPlayer(){
        int number=0;
        do{
            System.out.println("Entrer le nombre de joueurs ( minimum 2 ) :\n");
            number=Lire.i();
        }while(number<2);
        return number;
    }
    
    /**
     * Ask to user the pseudo for the current player and add it to database
     * @param indexPlayer 
     */
    private void createJoueur(int indexPlayer){
        boolean allowToContinue = false;
        do{
            System.out.println("Entrer le pseudu du joueur "+indexPlayer+" :\n");
            String pseudo=Lire.S();
            if(pseudo.length()>0){
                try {
                    lesJoueurs.ajouteJoueur(new Joueur(pseudo));
                    allowToContinue=true;
                } catch (Exception ex) {
                    System.out.println("Pseudo déjà prit ! Choisissez-en un autre");
                    allowToContinue=false;
                }
            }
        }while(!allowToContinue);
    }
    
    private void play(){
        do{
            makeATurn();
        }while(!shouldEndParty());
        calculPoints();
        showPointsAndWinner();
    }
    
    private void makeATurn(){
        int indexJoueur = 0;
        do{
            currentPlayer = lesJoueurs.getJoueur(indexJoueur);
            makeAPlayerTurn();
            indexJoueur++;
        }while(indexJoueur<lesJoueurs.getNbJoueurs()&&!shouldEndParty());
    }
    
    private void makeAPlayerTurn(){
        int tirage = de.tirage();
        showPartyStatus();
        showWhoMustPlay();
        showTirageResult(tirage);
        int userChoice = askCbmAvancerDetective(tirage);
        plateau.getDetective().avancer(userChoice);
        treatmentJeton();
    }
    
    private void showPartyStatus(){
        System.out.println("*************************************************\n\n"
                +
                plateau.toString()+"\n\n"
                +
                lesJoueurs.toString()+"\n"
                +
                "C'est à "+currentPlayer.getPseudo()+" de jouer");
    }
    
    private void showWhoMustPlay(){
        System.out.println("C'est à "+currentPlayer.getPseudo()+" de jouer !");
    }
    
    private void showTirageResult(int tirage){
        System.out.println("Résultat du dé : "+tirage+", que jouez-vous ? : ");
    }
    
    /**
     * Ask player how much the detective must move
     * @param deResult
     * @return 
     */
    private int askCbmAvancerDetective(int deResult){
        int number=0;
        boolean alreadyAskedOne = false;
        do{
            if(alreadyAskedOne){
                 System.out.println("Entrer un nombre entre 1 et "+deResult);
            }
            number=Lire.i();
            alreadyAskedOne = true;
        }while(number>deResult||number<1);
        return number;
    }
    
    /**
     * Detective has moved, we treat what happened 
     */
    private void treatmentJeton(){
        Jeton current = plateau.getJetonOnDetectivePosition();
        if(current.isBoss()){
            plateau.getReserve().retireJeton(current);
            prison.addPrisonnier(current);
        }else{
            plateau.getReserve().retireJeton(current);
            currentPlayer.getReserve().addJeton(current);
        }
    }
    
    /**
     * ask to user if he want to take pot de vin
     * @param j
     * @return 
     */
    /*private boolean playerTakePotDeVin(Jeton j){
        boolean playerTakePotDeVin = false;
        boolean allowToContinue = false;
        do{
            System.out.println("Voulez-vous récupérer le pot de vin "+j.getColor()+" ? oui/non o/n");
            String userInput=Lire.S();
            switch(userInput){
                case "oui":{
                    allowToContinue=true;
                    playerTakePotDeVin=true;
                    break;
                }
                case "o":{
                    allowToContinue=true;
                    playerTakePotDeVin=true;
                    break;
                }
                case "non":{
                    allowToContinue=true;
                    break;
                }
                case "n":{
                    allowToContinue=true;
                    break;
                }
                default :{
                    System.out.println("Veuillez entrer oui ou non");
                }
            }
        }while(!allowToContinue);
        return playerTakePotDeVin;
    }*/
    
    private boolean shouldEndParty(){
        return prison.getNbPrisonnier()>=5;
    }
    
    private void calculPoints(){
        for(int x=0;x<lesJoueurs.getNbJoueurs();x++){
            Joueur currentJoueur = lesJoueurs.getJoueur(x);
            Reserve currentReserve = currentJoueur.getReserve();
            int currentPoint = 0;
            for(int y=0;y<currentReserve.getSize();x++){
                Jeton currentJeton = currentReserve.getJeton(y);
                boolean bossInPrison = false;
                if(prison.getJetonBossByColor(currentJeton)!=null){
                    bossInPrison = true;
                }
                switch(currentJeton.getType()){
                    case Jeton.gangster1:{
                        if(bossInPrison){
                            currentPoint+=1;
                        }else{
                            currentPoint-=1;
                        }
                        break;
                    }
                    case Jeton.gangster2:{
                        if(bossInPrison){
                            currentPoint+=2;
                        }else{
                            currentPoint-=2;
                        }
                        break;
                    }
                    case Jeton.gangster3:{
                        if(bossInPrison){
                            currentPoint+=3;
                        }else{
                            currentPoint-=3;
                        }
                        break;
                    }
                    case Jeton.potDeVin:{
                        if(!bossInPrison){
                            currentPoint+=3;
                        }
                    }
                }
            }
            currentPlayer.setScore(currentPoint);
        }
    }
    
    private void showPointsAndWinner(){
        
    }
   
}
