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
public class Triangle extends ObjetPlan {

    private double area;
    
    private Point[] lstPoint;
    private Segment[] lstSegment = new Segment[3];

    public Triangle(Point P1, Point P2, Point P3,String nomV) {
        super(nomV);
        setLstPoint(P1,P2,P3);
        setLstSegment();
        setArea();
    }
        
    public Triangle(Point P1, Point P2, Point P3) {
        super(P1.getNom()+"_"+P2.getNom()+"_"+P3.getNom());
        setLstPoint(P1,P2,P3);
        setLstSegment();
        setArea();
    }
    
    public Triangle(Triangle t) {
        super(t.getNom());
        lstPoint=t.getLstPoint();
        lstSegment=t.getLstSegment();
        area=t.getAire();
    }

    public Point[] getLstPoint() {
        return lstPoint;
    }

    public void setLstPoint(Point p1, Point p2, Point p3) {
        this.lstPoint = new Point[]{p1,p2,p3};
    }

    public Segment[] getLstSegment() {
        return lstSegment;
    }

    public void setLstSegment() {
        for(int x=0;x<lstPoint.length-1;x++){
            lstSegment[x]=new Segment(lstPoint[x],lstPoint[x+1]);
        }
    }
    
    private void setArea(){
        double longestSegmentLength=0;
        double Height=0;
        for(int x=0;x<lstSegment.length;x++){ // on cherche le plus grand segment
            double currentSegmentLength = lstSegment[x].getSegmentLength();
            if(longestSegmentLength < currentSegmentLength){
                longestSegmentLength = currentSegmentLength;
                Point HeightStart = lstSegment[x].getMiddle(); // utilisé pour calculer la hauteur
                for(int y=0;y<lstPoint.length;y++){ // on cherche le point qui n'est pas sur le segment de l'hypothénuse
                    if(!lstPoint[y].equals(lstSegment[x].getP1())){
                        if(!lstPoint[y].equals(lstSegment[x].getP2())){
                            Height = new Segment(HeightStart,lstPoint[y]).getSegmentLength(); // une fois trouver on calcul la hauteur
                        }
                    }
                }
            }
        }
        this.area =(longestSegmentLength*Height)/2;
    }
    
    public String toString(){
        String toReturn="";
        toReturn+="Triangle :{";
        for(int x=0;x<lstPoint.length;x++){
            toReturn+=lstPoint[x].toString();
            if(x!=lstPoint.length-1){
                toReturn+=", ";
            }else{
                toReturn+="}";
            }
        }
        toReturn+="\n Périmètre : "+getPerimetre()+"\n Aire : "+getAire();
        return toReturn;
    }
    
    public boolean equals(Triangle t){
        int cmpt=0;
        for(int x=0;x<lstSegment.length;x++){
            Segment[] toWorkWith = t.getLstSegment();
            for(int y=0;y<toWorkWith.length;y++){
                if(lstSegment[x].equals(toWorkWith[y])){
                    cmpt++;
                }
            }
            if(cmpt==lstSegment.length){
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPerimetre() {
        return getLstSegment()[0].getSegmentLength()+getLstSegment()[1].getSegmentLength()+getLstSegment()[2].getSegmentLength();
    }

    @Override
    public double getAire() {
        return this.area;
    }
    
}
