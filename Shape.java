/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;

/**
 *
 * @author FBC
 */ public abstract class Shape extends Line {//bunu inherit edibce tanımı vermek zorundayız!!

    private String id;

    public Shape (String s){
        
        this.id = s; 
        
    }
    public abstract double setPerimeter();
    
    public String getId(){return id;}
    @Override
    public String toString(){return "Shape[id="+id+"]";}
}
