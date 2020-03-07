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
public class Segment extends ObjetPlan {
   
    private Point p1;
    private Point p2;
    private double segmentLength;

    public Segment(Point p1, Point p2,String nomV) {
        super(nomV);
        setP1(p1);
        setP2(p2);
        setSegmentLength();
    }
        
    public Segment(Point p1, Point p2) {
        super(p1.getNom()+"_"+p2.getNom());
        setP1(p1);
        setP2(p2);
        setSegmentLength();
    }
    
    public Segment(Segment s){
        super(s.getNom());
        p1=s.p1;
        p2=s.p2;
        segmentLength=s.getSegmentLength();
    }
    
    public Point getP1() {
        return p1;
    }

    private void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    private void setP2(Point p2) {
        this.p2 = p2;
    }

    private void setSegmentLength() {
        this.segmentLength = Math.sqrt(Math.pow((getP1().getX()-getP2().getX()), 2)+Math.pow((getP1().getY()-getP2().getY()), 2));
    }
    
    public double getSegmentLength(){
        return this.segmentLength;
    }
    
    public Point getMiddle(){
        double newX;
        if(p2.getX()>p1.getX()){
            newX = (p2.getX()+p1.getX())/2;
        }else{
            newX = (p1.getX()+p2.getX())/2;
        }
        
        double newY;
        if(p2.getY()>p1.getY()){
            newY = (p2.getY()+p1.getY())/2;
        }else{
            newY = (p1.getY()+p2.getY())/2;
        }
        return new Point(newX,newY);
    }
    
    public String toString(){
        return "Segment :{"+getP1().toString()+","+getP2().toString()+"},"
                +"\n Milieu : "+getMiddle().toString()
                +"\n Longeur : "+getSegmentLength();
    }
    
    public boolean equals(Segment se){
        return (getP1().equals(se.p1)&&getP2().equals(se.p2))||(getP1().equals(se.p2)&&getP2().equals(se.p1));
    }

    @Override
    public double getPerimetre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
