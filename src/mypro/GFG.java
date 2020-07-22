package mypro;
//package mypro;
//
//import java.awt.*;  
//import java.applet.*;  
//public class Plan extends Applet {  
//  
//  Image picture;  
//  
//  public void init() {  
//   // picture =getImage(getCodeBase(),"giphy.gif");  
//	  String str = "He";
//  }  
//    
//  public void paint(Graphics g) {  
// for(int i=0;i<500;i++){  
//	 for(int j=0;j<300;j++)
////     g.drawImage(picture, i,30, this);  
//	  g.drawString("str",i,j); 
//      try{Thread.sleep(100);}catch(Exception e){}  
//    }  
//  }  
//}

import java.awt.*; 
import java.applet.*; 
  
public class GFG extends Applet implements Runnable { 
    private String display; 
    private int x, y, flag; 
    Thread t; 
  
    // initializing 
    // called when the applet is 
    // started. 
    public void init() 
    { 
        display = "All is well"; 
        x = 100; 
        y = 100; 
        flag = 1; 
  
        // creating thread 
        t = new Thread(this, "MyThread"); 
  
        // start thread 
        t.start(); 
    } 
  
    // update the x co-ordinate 
    public void update() 
    { 
  
        x = x + 10 * flag; 
        if (x > 300) 
            flag = -1; 
        if (x < 100) 
            flag = 1; 
    } 
  
    // run 
    public void run() 
    { 
  
        while (true) { 
  
            // Repainting the screen 
            // calls the paint function 
            repaint(); 
  
            update(); 
            try { 
  
                // creating a pause of 1 second 
                // so that the movement is recognizable 
                Thread.sleep(1000); 
            } 
            catch (InterruptedException ie) { 
                System.out.println(ie); 
            } 
        } 
    } 
  
    // drawString 
    public void paint(Graphics g) 
    { 
        g.drawString(display, x, y); 
    } 
} 