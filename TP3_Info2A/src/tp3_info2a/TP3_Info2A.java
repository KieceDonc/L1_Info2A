/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_info2a;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vv224843
 */
public class TP3_Info2A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fraction F;
        try {
            F = new Fraction(3,2);
            System.out.println(F.toString());
        } catch (Exception ex) {
            Logger.getLogger(TP3_Info2A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
