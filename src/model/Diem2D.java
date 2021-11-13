/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;
import view.KTDH_Nhom8;

/**
 *
 * @author tuanbuiquoc
 */
public class Diem2D {
    private int x, y;

    public Diem2D() {
    }

    public Diem2D(int x, int y) {
        int a = x%DoanThang.unitsize;
        this.x = x-a;
        a= y%DoanThang.unitsize;
        this.y = y-a;

    }
     public int getX() {
        return x;
    }

    public void setX(int x) {
        int a = x%DoanThang.unitsize;
        this.x = x-a;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        int a = y%DoanThang.unitsize;
        this.y = y-a;
    }
    public void veDiem2D(Graphics2D g) {

        g.setColor(Color.RED);  //dat mau hinh ve la red
        String text = "(" +((x-KTDH_Nhom8.graphWidth/2)/KTDH_Nhom8.step) + ", " + ((y-KTDH_Nhom8.graphHeight/2)/-KTDH_Nhom8.step) + ")";
        g.drawString(text,  x-5 , y  - 5);
        g.fillRect(x , y , DoanThang.fillValue, DoanThang.fillValue);
//        System.out.println(text);
    }
}
