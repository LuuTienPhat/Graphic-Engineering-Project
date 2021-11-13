/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformation;

import model.Diem2D;
import view.KTDH_Nhom8;

/**
 *
 * @author tuanbuiquoc
 */
///////////////////
public class Quay {
    private int x1, y1;
    private double gocQuay;
    private Diem2D diem2D;
    public Quay(Diem2D diem2D,int x1,int y1, double gocQuay){
        this.diem2D = diem2D;
        this.x1= x1;
        this.y1 = y1;
        this.gocQuay = gocQuay;
    }
    public Quay(Diem2D diem2D,double gocQuay){
        this.diem2D = diem2D;
        this.gocQuay = gocQuay;
    }
    public Diem2D quayTheoTamO(){
        int newX, newY;
        newX = (diem2D.getX()-KTDH_Nhom8.graphWidth/2)/KTDH_Nhom8.step;
        newY = (diem2D.getY()-KTDH_Nhom8.graphHeight/2)/-KTDH_Nhom8.step;
        
        gocQuay = Math.toRadians(gocQuay);
        
        
        int newXX = (int) (newX*Math.cos(gocQuay)- newY*Math.sin(gocQuay));
        int newYY = (int) (newX*Math.sin(gocQuay)+ newY*Math.cos(gocQuay));
                 
        return new Diem2D(KTDH_Nhom8.graphWidth/2 + newXX*KTDH_Nhom8.step,KTDH_Nhom8.graphHeight/2-newYY*KTDH_Nhom8.step );
    }

    
}
