/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_info2a;

/**
 *
 * @author vv224843
 */
public abstract class ObjetPlan extends ObjetGeom{
    public ObjetPlan(String nom){
        super(nom);
    }
    
    
    public abstract double getPerimetre();
    public abstract double getAire();

}