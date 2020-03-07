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
public class Disque extends ObjetPlan {
    
    private Point center;
    private double rayon;
    private double area;
    private double perimeter;
    
    public Disque(Point center,double rayon,String nomV) {
        super(nomV);
        setCenter(center);
        setRayon(rayon);
        setArea();
        setPerimeter();
    }
    
    public Disque(Point center,double rayon) {
        super("Default");
        setCenter(center);
        setRayon(rayon);
        setArea();
        setPerimeter();
    }

    public Point getCenter() {
        return center;
    }

    private void setCenter(Point center) {
        this.center = center;
    }

    public double getRayon() {
        return rayon;
    }

    private void setRayon(double rayon) {
        this.rayon = rayon;
    }

    private void setArea() {
        this.area = Math.PI*Math.pow(rayon, 2);;
    }
    
    private void setPerimeter(){
        this.perimeter=Math.PI*rayon*2;
    }
    
    public boolean isInsideCircle(Point p){
        return new Segment(center,p).getSegmentLength()<=rayon;
    }
     
    @Override
    public String toString(){
        return super.toString()+" : {"+center.toString()+"}, "+rayon
                +"\n Périmètre : "+perimeter
                +"\n Aire : "+area;
    }
    
    public boolean equals(Disque d){
        return center.equals(d.getCenter())&&rayon==d.getRayon();
    }

    @Override
    public double getPerimetre() {
        return perimeter;
    }

    @Override
    public double getAire() {
        return area;
    }
    
}
