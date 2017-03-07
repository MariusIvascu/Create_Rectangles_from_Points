/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
 *
 * @author FBC
 */
public class Point {
 
    private double x;
    private double y;
    ///////////////CONSTRUCUT///////////////
    public Point(){}
    public Point(double x,double y)throws Exception{
          this.x= x;  this.y = y;
        if ( this.x < 0 || this.y<0 ) {
  throw new Exception("Negative number  entered");
       
    }}
    ///////////////SETS///////////////
    public  void setx(double x) throws Exception{
           this.x= x;
        if ( x < 0) {
  throw new Exception("Negative number entered");

    }
    }
    public  void sety(double y) throws Exception{
    this.y = y; 
    if ( y < 0) {
  throw new Exception("Negative number entered");

    }
    }
    ///////////////GETS///////////////
    public double getx(){return this.x;}
    public double gety(){return this.y;}
    
}
