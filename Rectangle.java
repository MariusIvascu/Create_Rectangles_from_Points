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
public class Rectangle extends Shape {
    

	Line width;
	Line height;
	double perimeter;
	public Rectangle(Line width, Line height) throws Exception
	{     
                super("Rectange");
		this.width = width;
		this.height = height;
		setPerimeter(); 
                if ( this.width == null || this.height == null) {
                    throw new Exception("Null exception");
                }
	}
	 public void setWidth(Line width) throws Exception{
            this.height = width;
            if(this.width == null){          
                throw new Exception ("Null excepiton");
            }
        }
        public void setHeight(Line height) throws Exception{
            this.height = height;
            if(this.height == null){
            
            throw new Exception ("Null excepiton");}
        }
        public Line getWidth(){
            return this.width;
        }
        public Line getHeight(){
            return this.height;
        }
        @Override
	public  double setPerimeter()
	{
		this.perimeter = 2*(this.width.getLength() + this.height.getLength()) ;
		return this.perimeter;
	}
	
}
