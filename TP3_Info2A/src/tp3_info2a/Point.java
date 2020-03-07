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
public class Point extends ObjetPlan {
    
    private double x=0;
    private double y=0;

    public Point(double x, double y,String nomV) {
        super(nomV);
        setX(x);
        setY(y);
    }
        
    public Point(double x, double y) {
        super("");
        setX(x);
        setY(y);
    }
    
    public Point(Point p){
        super(p.getNom()+"'");
        x=p.x;
        y=p.y;        
    }
    
    public double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }
    
    public boolean equals(Point p){
        return getX()==p.getX()&&getY()==p.getY();
    }
    
    public String toString(){
        return "Point("+getX()+", "+getY()+")";
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
