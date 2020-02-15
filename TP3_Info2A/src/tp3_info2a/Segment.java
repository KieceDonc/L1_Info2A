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
public class Segment {
   
    private Point p1;
    private Point p2;
    private double segmentLength;

    public Segment(Point p1, Point p2) {
        setP1(p1);
        setP2(p2);
        setSegmentLength(calculSegmentLength());
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

    private void setSegmentLength(double segmentLength) {
        this.segmentLength = segmentLength;
    }
    
    public double getSegmentLength(){
        return this.segmentLength;
    }
    
    private double calculSegmentLength(){
        return Math.sqrt(Math.pow((getP1().getX()-getP2().getX()), 2)+Math.pow((getP1().getY()-getP2().getY()), 2));
    }
    
    public Point getMiddle(){
        double newX = (p1.getX()-p2.getX())/2;
        double newY = (p1.getY()-p2.getY())/2;
        return new Point(newX,newY);
    }
    
    public String toString(){
        return "Segment :{"+getP1().toString()+","+getP2().toString()+"},"
                +"\nMilieu :"+getMiddle().toString()
                +"\nLongeur : "+getSegmentLength();
    }
}
