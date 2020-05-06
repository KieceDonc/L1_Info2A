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
public class ObjetGeom {
    
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public ObjetGeom(String nom){
        setNom(nom);
    }
    
}
