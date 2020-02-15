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
public class Point {
    
    private double x=0;
    private double y=0;

    public Point(double x, double y) {
        setX(x);
        setY(y);
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
    
}
