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
public class Disque {
    
    private Point center;
    private Segment rayon;
    private double area;

    public Disque(Point center,double rayon) {
        setCenter(center);
        setRayon();
        setArea(calculArea());
    }

    public Point getCenter() {
        return center;
    }

    private void setCenter(Point center) {
        this.center = center;
    }

    public Segment getRayon() {
        return rayon;
    }

    private void setRayon(Segment rayon) {
        this.rayon = rayon;
    }

    public double getArea() {
        return area;
    }

    private void setArea(double area) {
        this.area = area;
    }
    
    private double calculArea(){
        return Math.PI*Math.pow(rayon.getSegmentLength(), 2);
    }
    
    public boolean isInsideCircle(Point p){
        return new Segment(center,p).getSegmentLength()<=rayon.getSegmentLength();
    }
    
    public String toString(){
        return "Disque : {"+center.toString()+"}, "+rayon.getSegmentLength();
    }
    
}
