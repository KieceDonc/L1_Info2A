/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
            Fraction f3 = new Fraction(-4,5);
            Fraction f4 = new Fraction(-3,4);
            Fraction result = f1.getMoins(f2);
            result = result.getFois(2);
            result = result.getMoins(f3);
            result = result.getFois(f4);
            System.out.println(result.toString());
        }catch(Exception e){
           System.out.println(e);
        }    }
    
}
