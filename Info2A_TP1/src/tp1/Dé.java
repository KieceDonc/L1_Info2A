package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vv224843
 */
public class Dé {
    
    public int nbrFaces=0;
    private int dernierResultat=0;
        
    public void setNbrFaces(int nbrFace){
        if(nbrFace>1){
            this.nbrFaces=nbrFace;
        }else{
            this.nbrFaces=6;
        }
    }
    public Dé(){
        nbrFaces = 6;
    }
    
    public Dé(int nbrFaces){
        setNbrFaces(nbrFaces);
    }
    
    public int lance(){
        dernierResultat=(int) Math.floor(Math.random()*(7-1)+1);
        return dernierResultat;
    }
    
    public int getResultat(){
        if(dernierResultat==0){
            lance();
        }
        return dernierResultat;
    }
}
