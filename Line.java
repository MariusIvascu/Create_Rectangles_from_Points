/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author FBC
 */
public class Line  {
    
    private Point first;
    private Point last;
    private double length;
    
    
    public Line(){}
    public Line(Point first,Point last)throws Exception{    
        if ( first == null || last == null) {
        throw new Exception("Null Exception");

    }
        this.first = first;
        this.last = last; setLength(first,last);
    
    }

    public void setFirst(Point first) throws Exception {this.first = first; if ( this.first == null) {
  throw new Exception("Null exception");

    } }
    public void setLast(Point last) throws Exception { this.last = last;  if ( this.last == null) {
  throw new Exception("Null exception");

    } }
    public void setLength(Point first, Point last) throws Exception {
        this.length =  Math.sqrt((this.last.getx()-this.first.getx())*(this.last.getx()-this.first.getx())+(this.last.gety()-this.first.gety())*(this.last.gety()-this.first.gety()));
    if (this.length == 0.0) {
  throw new Exception("Length is 0!!");

    }
    }     
    public Point getFisrt(){ return first;}
    public Point getLast(){return last;}
    public double getLength(){return length;}
    
    
  
}

    
    
    
    

