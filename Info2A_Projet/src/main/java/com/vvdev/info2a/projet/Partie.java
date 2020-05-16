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
        int nbJoueur = askNumberPlayer();
        for(int x=0;x<nbJoueur;x++){
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
            System.out.println("Entrer le nombre de joueurs ( minimum 2 ) :");
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
            System.out.println("Entrer le pseudu du joueur "+(indexPlayer+1)+" :");
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
        System.out.println("5 boss sont en prison ! Voici les résultats :\n");
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
        int tirage = De.tirage();
        showPartyStatus();
        showTirageResult(tirage);
        int userChoice = askCbmAvancerDetective(tirage);
        plateau.getDetective().avancer(userChoice);
        treatmentJeton();
    }
    
    private void showPartyStatus(){
        System.out.println("*************************************************\n"
                +
                plateau.toString()+"\n\n"
                +
                "Prison : "+prison.toString()+"\n\n"
                +
                lesJoueurs.toString()+"\n"
                +
                "C'est à "+currentPlayer.getPseudo()+" de jouer");
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
        plateau.getReserve().retireJeton(current);
        if(current.isBoss()){
            prison.addPrisonnier(current);
        }else{
            currentPlayer.getReserve().addJeton(current);
        }
    }

    private boolean shouldEndParty(){
        return prison.getNbPrisonnier()>=5;
    }
    
    private void calculPoints(){
        for(int x=0;x<lesJoueurs.getNbJoueurs();x++){
            Joueur currentJoueur = lesJoueurs.getJoueur(x);
            Reserve currentReserve = currentJoueur.getReserve();
            int currentPoint = 0;
            for(int y=0;y<currentReserve.getSize();y++){
                Jeton currentJeton = currentReserve.getJeton(y);
                boolean bossInPrison = false;
                if(prison.getJetonBossByColor(currentJeton)!=null){
                    bossInPrison = true;
                }
                if(currentJeton.isGangster1()){
                    if(bossInPrison){
                        currentPoint+=1;
                    }else{
                        currentPoint-=1;
                    }
                }else if(currentJeton.isGangster2()){
                    if(bossInPrison){
                        currentPoint+=2;
                    }else{
                        currentPoint-=2;
                    }                    
                }else if(currentJeton.isGangster3()){
                    if(bossInPrison){
                        currentPoint+=3;
                    }else{
                        currentPoint-=3;
                    }                    
                }else{
                    if(!bossInPrison){
                        currentPoint+=3;
                    }                    
                }
            }
            currentJoueur.setScore(currentPoint);
        }
    }
    
    private void showPointsAndWinner() {
        try {
            String toShow="";
            int scoreMax=0;
            LesJoueurs winners = new LesJoueurs();
            for(int x=0;x<lesJoueurs.getNbJoueurs();x++){
                Joueur currentJoueur = lesJoueurs.getJoueur(x);
                int currentScore = currentJoueur.getScore();
                if(currentScore>scoreMax){
                    scoreMax= currentScore;
                    winners = new LesJoueurs();
                    winners.ajouteJoueur(currentJoueur);
                }else if(currentScore == scoreMax){
                    winners.ajouteJoueur(currentJoueur);
                }
                toShow+=currentJoueur.getPseudo()+" score : "+currentScore+"\n";
            }
            toShow+="\n";
            if(winners.getNbJoueurs()==1){
                toShow+="Le vainqueur est :";
            }else{
                toShow+="Les vainqueurs sont :";
            }
            toShow+="\n";
            for(int x=0;x<winners.getNbJoueurs();x++){
                Joueur currentJoueur = winners.getJoueur(x);
                toShow+=currentJoueur.getPseudo()+"\n";
            }
            toShow+="\n";
            System.out.println(toShow);
        } catch (Exception ex) {
            Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
