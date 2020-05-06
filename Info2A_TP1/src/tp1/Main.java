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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
        Fraction f1 = new Fraction(3,2);
        Fraction f2 = new Fraction(2,5);
        Fraction f3 = new Fraction(4,5);
        Fraction f4 = new Fraction(-3,4);
        Fraction result = f1.getMoins(f2);
        result.getFois(2);
        result.getMoins(f3);
        result.getFois(f4);
        System.out.println(result.getNumerateur()+" "+result.getDenominateur());
        }catch(Exception e){
           System.out.println(e);
        }
        
        
        Caisse c = new Caisse(2000.0);
        c.setMonnaie('$');
        c.montrerLeMontant();
        c.retrait(0.1);
        c.retrait(0.1);
        c.retrait(0.1);
        c.montrerListeOpérations();
        
    }
    
}
