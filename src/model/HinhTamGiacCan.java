/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tuanbuiquoc
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class HinhTamGiacCan {

    private int xDinh, yDinh, canh, x2, y2, x3, y3;
    private int aH, hB_hC;
    public HinhTamGiacCan(int xDinh, int yDinh, int x2, int y2) {

        int a = xDinh % DoanThang.unitsize;
        this.xDinh = xDinh - a;
        a = yDinh % DoanThang.unitsize;
        this.yDinh = yDinh - a;
        a = x2 % DoanThang.unitsize;
        this.x2 = x2 - a;
        a = y2 % DoanThang.unitsize;
        this.y2 = y2 - a;

        this.canh = (int) Math.sqrt((this.x2 - this.xDinh) * (this.x2 - this.xDinh) + (this.y2 - this.yDinh) * (this.y2 - this.yDinh));
        this.aH = (int) Math.abs(this.y2-this.yDinh);
        this.hB_hC = (int) Math.sqrt(this.canh*this.canh-aH*aH);
        if (this.xDinh > this.x2) {
                this.x3 = this.xDinh + this.hB_hC;
                this.x3 = this.x3 - this.x3%DoanThang.unitsize;
            } else {
                this.x3 = this.xDinh - this.hB_hC;
                this.x3 = this.x3 - this.x3%DoanThang.unitsize;
            }
        if (y2 > yDinh) {        

            this.y3 = this.y2;
            this.y3 = this.y3 - this.y3%DoanThang.unitsize;
        } else {
            
            this.y3 = this.y2;
            this.y3 = this.y3 - this.y3%DoanThang.unitsize;
        }
    }

    public int getaH() {
        return aH;
    }

    public int gethB_hC() {
        return hB_hC;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
//        int a = x3 %DoanThang.unitsize;
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
//        int a = y3%DoanThang.unitsize;
        this.y3 = y3;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
//        int a = x2 %DoanThang.unitsize;
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
//       int a = y2%DoanThang.unitsize;
        this.y2 = y2;
    }

    public int getxDinh() {
        return xDinh;
    }

    public void setxDinh(int xDinh) {
//        int a = xDinh %DoanThang.unitsize;
        this.xDinh = xDinh;
    }

    public int getyDinh() {
        return yDinh;
    }

    public void setyDinh(int yDinh) {
//        int a = yDinh%DoanThang.unitsize;
        this.yDinh = yDinh;
    }

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }

    public void veHinhTamGiacCan(Graphics2D g) {
        
        new DoanThang(xDinh, yDinh, x2, y2).veDoanThang(g);

        new DoanThang(xDinh, yDinh, x3, y3).veDoanThang(g);

        new DoanThang(x3, y3, x2, y2).veDoanThang(g);
    }

}
