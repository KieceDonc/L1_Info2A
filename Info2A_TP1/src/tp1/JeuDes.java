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
public class JeuDes {
    
    private int nbrDes = 0;
    private int nbrFaces = 0;
    
    public void setNbrDes(int nbrDes){
        if(nbrDes>0){
            this.nbrDes=nbrDes;
        }
    }
    
    public void setNbrFaces(int nbrFace){
        if(nbrFace>0){
            this.nbrFaces=nbrFace;
        }
    }
    
    public JeuDes(int nbrDes, int nbrFaces){
        setNbrDes(nbrDes);
        setNbrFaces(nbrFaces);
    }
    
    public void lance(){
        if(nbrDes>0&&nbrFaces>0){
             for(int x=0;x<nbrDes;x++){
                 System.out.println("Dé n°"+x+" ="+new Dé(nbrFaces).lance());
             }
        }
    }
    
}
