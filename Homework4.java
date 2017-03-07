/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.sqrt;
/**
 *
 * @author FBC
 */
    /**
     * @param args the command line arguments
    */
/////////////!!!! EXCEPTION CONTROLS ARE AT THE END OF THE PAGE .THEY ARE COMMENTED.!!!!///////////////
public class Homework4 {
    
    public static boolean collinear(Point a, Point b, Point c){
       return (a.gety() - b.gety()) * (a.getx() - c.getx()) == (a.gety() - c.gety()) * (a.getx() - b.getx());
    }
	
   
    public static boolean isRectangle(Point a,Point b,Point c,Point d) {
            
        double xort = 0.0;
        double yort= 0.0;
        xort =(a.getx()+b.getx()+c.getx()+d.getx())/4;
        yort =(a.gety()+b.gety()+c.gety()+d.gety())/4;
        double k = Math.sqrt((xort-a.getx())*(xort-a.getx())+(yort-a.gety())*(yort-a.gety()));
        double l = Math.sqrt((xort-b.getx())*(xort-b.getx())+(yort-b.gety())*(yort-b.gety()));
        double m = Math.sqrt((xort-c.getx())*(xort-c.getx())+(yort-c.gety())*(yort-c.gety()));
        double n =  Math.sqrt((xort-d.getx())*(xort-d.getx())+(yort-d.gety())*(yort-d.gety()));
       if((k == l)&&(l ==m) && (m ==n)){
           return true;
       }
      

        else 
            return false;

        
       //FOR THE RECTANGLES THAT ARE PARALLEL TO THE COORDINATE SYSTEM but it doesnt work for all rectangles on the system,that is why I commented it.
      // if(((a.getx() == b.getx()) && (a.gety() ==  c.gety())&&( c.getx() == d.getx()) &&( d.gety()==b.gety()))||((a.getx() == c.getx()) && (a.gety() ==  b.gety())&&( b.getx() == d.getx()) &&( c.gety()== d.gety())))/* && isRectangle2(a.getx(),a.gety(),b.getx(),b.gety(),c.getx(),c.gety(),d.getx(),d.gety())*/{
     //     return true;
    //  }
   // else 
  //      return false;

}
    /////////////////////////////////WRITE TO A FILE///////////////////////////////// 
    public static void write (String filename, Rectangle[]x,int line) throws IOException{
   PrintWriter  writer= null;
       try {
        writer = new PrintWriter (new FileWriter(filename));
        writer.println("Rectangles");
            for (int j = 0; j < line; j++) {
                if(x[j]!= null){
                  writer.printf(j+1 + ", %.2f",x[j].setPerimeter());
                  writer.println();
                }
              }
           writer.println();
        }
    catch (IOException e) {
        e.printStackTrace();
    }  
       writer.flush();
       writer.close();
       

} 
    /////////////////////////////////MAIN FUNCTION///////////////////////////////// 

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception{
        
        String line ;
        int lineNumber = 0 ;
       /////////////////////////////////NUMBER OF LINES THAT ALSO GIVES US THE NUMBER OF POINTS/////////////////////////////////
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\FBC\\Documents\\NetBeansProjects\\Homework4\\src\\homework4\\input_2.txt"));
        line = in.readLine();
        while (line!=null){
            if(line.length()>0){
                lineNumber++;
            }
            line = in.readLine();
        }    
             
        System.out.println("Number of points: "+lineNumber);
        System.out.println("Points: ");

        in.close();
        /////////////////////////////////READ POINT FROM THE FILE/////////////////////////////////    
        Point [] array = new Point[lineNumber];
        int r = 0;
        BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\FBC\\Documents\\NetBeansProjects\\Homework4\\src\\homework4\\input_2.txt"));
        while((line = in2.readLine())!= null && r< lineNumber ){
            String[] seperated =line.split(", ");
            array[r]= new Point((Double.parseDouble(seperated[0])),Double.parseDouble(seperated[1]));
            
            System.out.println(array[r].getx()+", "+array[r].gety());
            //System.out.println(seperated[0]+", "+seperated[1]);
            
            r++;
               
        }
        /////////////////////////////////CREATE RECTAN IF POSSIBLE///////////////////////////////// 
        System.out.println("Rectangles");
        Rectangle []rectangle = new Rectangle[20];
        int j;  int i; int k;int m;
        
        
        int  t = 0;
        for(i=0; i < lineNumber; i++){
            Point a = array[i];
            for(j=i+1; j < lineNumber; j++){
		Point b = array[j];
                    for(k=j+1; k < lineNumber; k++){
                        Point c = array[k]; 
                        for(m = k+1; m<lineNumber ;m++){
                            Point d = array[m];

                                                                  
                    ///Rectangle olabilmesi içi gereken durumlar kontrol edilecek
                    if(isRectangle(a,b,c,d) && (!collinear(a,b,c) ||!collinear(b,c,d) || !collinear(a,c,d) ||!collinear(a,d,b))){
                            rectangle[t]=new Rectangle(new Line(a,b), new Line(a,c));
                            System.out.printf(t+1+", %.2f\n",rectangle[t].setPerimeter());
                                    t++;                                                                    
                                 }
                        }
                    }
            }
        }
        ////////Check Length is zero exception///////
        /*Point p = new Point(0,0);
        Point n = new Point(0,0);
        Line line2 = new Line(p,n);
        System.out.println(line2.getLength());
       */
        
        //////////Negative Number Exception//////////
        /*Point p = new Point(-1,1);
        Point n = new Point(-2,-3);
        Line line2 = new Line(p,n);
        System.out.println(line2.getLength());
        */
        ///////////When points are null,Line arguments also will be null/////////
       /* Point p = null;
        Point n = null;
        Line line2 = new Line(p,n);
        */
      
                
        //WRITE TO FILE FUNCTION
write("C:\\Users\\FBC\\Documents\\NetBeansProjects\\Homework4\\src\\homework4\\output_2.txt",rectangle,rectangle.length);
    
}
}
    


