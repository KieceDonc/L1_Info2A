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
        try {
            Disque d1 = new Disque(new Point(3.5,2.5),0.5);
            System.out.println(d1.toString());
            
            Segment s1 = new Segment(new Point(1,2),new Point(3.5,2.5));
            System.out.println(s1.toString());
            
            Triangle t1 = new Triangle(new Point(1,2),new Point(3.5,2.5),new Point(3,0.5));
            System.out.println(t1.toString());
        } catch (Exception ex) {
            Logger.getLogger(TP3_Info2A.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
