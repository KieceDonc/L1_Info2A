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
public class Triangle {
    
    private Point Point1,Point2,Point3;
    private Segment Segment1,Segment2,Segment3;
    private double area;

    public Triangle(Point P1, Point P2, Point P3) {
        setPoint1(P1);
        setPoint2(P2);
        setPoint3(P3);
        setSegment1(new Segment(getPoint1(),getPoint2()));
        setSegment2(new Segment(getPoint2(),getPoint3()));
        setSegment3(new Segment(getPoint3(),getPoint1()));
        setArea(calculArea());
    }
    
    public Point getPoint1() {
        return Point1;
    }

    private void setPoint1(Point P1) {
        this.Point1 = P1;
    }

    public Point getPoint2() {
        return Point2;
    }

    private void setPoint2(Point P2) {
        this.Point2 = P2;
    }

    public Point getPoint3() {
        return Point3;
    }

    private void setPoint3(Point P3) {
        this.Point3 = P3;
    }

    public Segment getSegment1() {
        return Segment1;
    }

    private void setSegment1(Segment Segment1) {
        this.Segment1 = Segment1;
    }

    public Segment getSegment2() {
        return Segment2;
    }

    private void setSegment2(Segment Segment2) {
        this.Segment2 = Segment2;
    }

    public Segment getSegment3() {
        return Segment3;
    }

    private void setSegment3(Segment Segment3) {
        this.Segment3 = Segment3;
    }

    public double getArea() {
        return this.area;
    }

    private void setArea(double Area) {
        this.area = Area;
    }
    
    public double getPerimeter(){
        return getSegment1().getSegmentLength()+getSegment2().getSegmentLength()+getSegment3().getSegmentLength();
    }
    
    private double calculArea(){
        double S1L = getSegment1().getSegmentLength();
        double S2L = getSegment2().getSegmentLength();
        double S3L = getSegment3().getSegmentLength();
        
        Segment hypothenuse = S1L >= S3L ? (S1L >= S2L ? getSegment1():getSegment2()):getSegment3();
        Segment Height;
        if(!hypothenuse.getP1().equals(getPoint1())){
            Height = new Segment(hypothenuse.getMiddle(),getPoint1());
        }else if(!hypothenuse.getP2().equals(getPoint2())){
            Height = new Segment(hypothenuse.getMiddle(),getPoint2());
        }else{
            Height = new Segment(hypothenuse.getMiddle(),getPoint3());            
        }
        return (hypothenuse.getSegmentLength()*Height.getSegmentLength())/2;
    }
    
    public String toString(){
        return "Triangle :{"+getPoint1().toString()+", "+getPoint2().toString()+", "+getPoint3().toString()+"}"+
                "\nPérimètre :"+getPerimeter()+
                "\nAire"+getArea();
    }
    
}
