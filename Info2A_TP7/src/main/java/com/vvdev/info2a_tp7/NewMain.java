/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvdev.info2a_tp7;

import java.util.Date;

/**
 *
 * @author Valentin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Locomotive locomotive1 = new Locomotive("LocomotiveDuTurfu#1530",500);
        Train t1 = new Train("TrainDuTurfu#510",new Date(),locomotive1);
        t1.addVoiture(new Voiture("VoitureDuTurfu#8510",50,1,42));
        /*t1.addVoiture(new Voiture("VoitureDuTurfu#8511",50,2,68));
        t1.addVoiture(new Voiture("VoitureDuTurfu#8512",50,1,42));
        t1.addVoiture(new Voiture("VoitureDuTurfu#8513",50,2,68));*/
        t1.getVoiture(0).makeAReservation("Verstracte", "Valentin", "PassagerDuTurfu#156444553", 5);
        t1.getVoiture(0).makeAReservation("Emmanuel", "Macron", "PassagerDuTurfu#156444554", 6);
        t1.getVoiture(0).deliverAReservation(5);
        t1.addWagonMarchandise(new WagonMarchandise("WagonMarchandiseDuTurfu#15564",5,50,25,"descriptifDuTurfu"));
        System.out.println(t1.toString());
                        
        
    }
    
}
