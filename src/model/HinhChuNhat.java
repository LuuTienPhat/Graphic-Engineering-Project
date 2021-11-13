/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tuanbuiquoc
 */
public class HinhChuNhat {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    private int x3;
    private int y3;
    private int x4;
    private int y4;
    
    
    public HinhChuNhat(int x1, int y1, int x3, int y3) {
        int a = x1%DoanThang.unitsize;
        this.x1 = x1-a;
        a = y1%DoanThang.unitsize;
        this.y1 = y1-a;
        a = x3%DoanThang.unitsize;
        this.x3 = x3-a;
        a = y3%DoanThang.unitsize;
        this.y3 = y3-a;
        
        
//        this.x1 = x1;
//        this.y1=y1;
//        this.x2 = x2;
//        this.y2 = y2;
        this.x2 = x3;
        this.y2 =  y1;
        this.x4 = x1;
        this.y4  = y3;
        
    }
     public HinhChuNhat(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int a = x1%DoanThang.unitsize;
        this.x1 = x1-a;
        a = y1%DoanThang.unitsize;
        this.y1 = y1-a;
        a = x2%DoanThang.unitsize;
        this.x2 = x2-a;
        a = y2%DoanThang.unitsize;
        this.y2 = y2-a;
        
        a = x3%DoanThang.unitsize;
        this.x3 = x3-a;
        a = y3%DoanThang.unitsize;
        this.y3 = y3-a;
        a = x4%DoanThang.unitsize;
        this.x4 = x4-a;
        a = y4%DoanThang.unitsize;
        this.y4 = y4-a;
     }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
//        int a = x3%DoanThang.unitsize;
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
//        int a = y3%DoanThang.unitsize;
        this.y3 = y3;
    }

    public int getX4() {
        return x4;
    }

    public void setX4(int x4) {
//        int a = x4%DoanThang.unitsize;
        this.x4 = x4;
    }

    public int getY4() {
        return y4;
    }

    public void setY4(int y4) {
//        int a = y4%DoanThang.unitsize;
        this.y4 = y4;
    }
     
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
//        int a = x1%DoanThang.unitsize;
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
//        int a = y1%DoanThang.unitsize;
        this.y1 = y1;

    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
//        int a = x2%DoanThang.unitsize;
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
//        int a = y2%DoanThang.unitsize;
        this.y2 = y2;
    }
    
    public void veHinhChuNhat(Graphics2D g) {
        new DoanThang(x1, y1, x2, y2).veDoanThang(g);
        
        new DoanThang(x1, y1, x4, y4).veDoanThang(g);
        
        new DoanThang(x2, y2, x3, y3).veDoanThang(g);
        
        new DoanThang(x3, y3, x4, y4).veDoanThang(g);
        
    }
    public void veHinhChuNhat4Diem(Graphics2D g){
        //        g.setColor(Color.red);
        int xUnit = DoanThang.unitsize, yUnit = DoanThang.unitsize; //Để xét x, y tăng hay giảm
        int x = x1;
        int y = y1;
        g.fillRect(x, y, DoanThang.fillValue, DoanThang.fillValue);
        if (x1 - x2 > 0) {
            xUnit = -xUnit;
        }
        if (y1 - y2 > 0) {
            yUnit = -yUnit;
        }
        while (x != x2) {
            g.fillRect(+ x,+ y1, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect( + x,+ y2, DoanThang.fillValue, DoanThang.fillValue);
            x = x + xUnit;
        }
        while (y != y2) {
            g.fillRect(+ x1, + y, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(+ x2, + y, DoanThang.fillValue, DoanThang.fillValue);
            y = y + yUnit;
        }
         g.fillRect(x, y, DoanThang.fillValue, DoanThang.fillValue);
    }
}
