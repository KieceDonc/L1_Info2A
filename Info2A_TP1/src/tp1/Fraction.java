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
public class Fraction {
    
    public int den;
    public int num;
    
    public int getDenominateur(){
        return den;
    }
    
    public void setDenominateur(int den) throws Exception{
        if(den<=0){
            throw new Exception("PAS DE DISION PAR 0 OU MOINS");
        }else{
            this.den=den;
        }
    }
    
    public int getNumerateur(){
        return num;
    }
    
    public void setNumerateur(int num){
        this.num=num;
    }
    
    public Fraction(int den, int num) throws Exception{
        setDenominateur(den);
        setNumerateur(num);
    }
    
    public Fraction(int num) throws Exception{
        this(1,num);
    }
    
    public Fraction(Fraction receive) throws Exception{
        this(receive.getDenominateur(),receive.getNumerateur());
    }
    
    public double getValeur(){
        if(this.den!=0){
            return this.num/(double)this.den;
        }else{
            System.out.println("Error, trying to divide "+this.num+" with 0");
            return 0;
        }
    }
    
    public Fraction getFois(int facteur){
        setNumerateur(getNumerateur()*facteur);
        return this;
    }
   
    public Fraction getFois(Fraction receive) throws Exception{
        return new Fraction(this.getNumerateur()*receive.getNumerateur(),this.getDenominateur()*receive.getDenominateur());
    }
    
    public Fraction getMoins(Fraction receive) throws Exception{
        return new Fraction(this.getNumerateur()*receive.getDenominateur()-receive.getNumerateur()*this.getDenominateur(),this.getDenominateur()*receive.getDenominateur());
    }
    
    public Fraction getPlus(Fraction receive) throws Exception{
        return new Fraction(this.getNumerateur()*receive.getDenominateur()+receive.getNumerateur()*this.getDenominateur(),this.getDenominateur()*receive.getDenominateur());
    }
    
    public Fraction getSur(Fraction receive) throws Exception{
        return new Fraction(this.getNumerateur()*receive.getDenominateur(),this.getDenominateur()*receive.getNumerateur());
    }
    
    private int t=0;
    private int r=0;
    private int pgcd(int a , int b){
        if(b>a){
            t = a;
            a = b;
            b = t;
        }
        do {
            r = a % b;
            a = b;
            b = r;
        } while(r !=0);
        return a ;
    }
    
    
    public Fraction getSimplificiation() throws Exception{
        t=0;
        r=0;
        int pgcd = pgcd(this.getNumerateur(),this.getDenominateur());
        return new Fraction(this.getNumerateur()/pgcd,this.getDenominateur()/pgcd);
    }
    
}
