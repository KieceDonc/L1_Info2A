/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

/**
 *
 * @author vv224843
 */
public class Caisse {
    
    private String listeDesOperations="";
    private double solde=0;
    private char monnaie=' ';
    
    private void setSolde(double init){
        if(init>=0){
            solde=init;
        }else{
            System.out.println("Impossible d'avoir une caisse négative, elle sera initialisé à 0");
        }
    }
    
    public void setMonnaie(char monnaie){
        this.monnaie=monnaie;
    }
    
    public Caisse(){
    }
    
    public Caisse(double init){
        setSolde(init);
    }
    
    public void depot(double depot){
        if(depot>0){
            this.solde+=depot;
            listeDesOperations+="\nDépôt de : "+depot+monnaie+". Nouveau solde : "+solde+monnaie;
            montrerLeMontant();
        }else{
            System.out.println("Vous ne pouvez pas faire un dépôt négatif, soyez plus intelligent :( !");
        }
    }
    
    public void retrait(double retrait){
        if((solde-retrait)>0){
           solde=(solde*100-retrait*100)/100;
           listeDesOperations+="\nRetrait de : "+retrait+monnaie+". Nouveau solde : "+solde+monnaie;
           montrerLeMontant();
        }else{
            System.out.println("Impossible de retiré autant d'argent, vous n'êtes pas assez riche :(");
        }
    }
    
    public void montrerLeMontant(){
        System.out.println("Le montant de la caisse est de "+solde+monnaie);
    }
    
    public void montrerListeOpérations(){
        System.out.println("Liste des opérations :"+listeDesOperations);
    }
    
    public boolean isVide(){
        return solde == 0;
    }
    
    public void vide(){
        solde=0;
    }
}
