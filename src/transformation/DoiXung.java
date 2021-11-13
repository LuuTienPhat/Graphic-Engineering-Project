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
public class DoiXung {
    Diem2D diem2d;
    private String mode="";
    public DoiXung(Diem2D diem2D,String mode){
        this.mode = mode;
        this.diem2d = diem2D;

    }
    
    public Diem2D doiXungDiem(){
        int newX, newY;
        if(mode.equals("Ox")){//String text = "(" +(() + ", " + ((y-KTDH_Nhom8.graphHeight/2)/-KTDH_Nhom8.step) + ")";
            newX = (diem2d.getX()-KTDH_Nhom8.graphWidth/2)/KTDH_Nhom8.step;
            newY = - (diem2d.getY()-KTDH_Nhom8.graphHeight/2)/-KTDH_Nhom8.step;
            return new Diem2D(KTDH_Nhom8.graphWidth/2 + newX*KTDH_Nhom8.step,KTDH_Nhom8.graphHeight/2-newY*KTDH_Nhom8.step );
        }
        if(mode.equals("Oy")){
            newX = -(diem2d.getX()-KTDH_Nhom8.graphWidth/2)/KTDH_Nhom8.step;
            newY = (diem2d.getY()-KTDH_Nhom8.graphHeight/2)/-KTDH_Nhom8.step;
            return new Diem2D(KTDH_Nhom8.graphWidth/2 + newX*KTDH_Nhom8.step,KTDH_Nhom8.graphHeight/2-newY*KTDH_Nhom8.step );
        }
        return diem2d;
    }
}
