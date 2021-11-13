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
public class CayThong {

    private String drawMode = "";
    private int xDinh, yDinh, chieuCao;
    private HinhTamGiacCan hinhTamGiacCan1, hinhTamGiacCan2, hinhTamGiacCan3;
    private HinhChuNhat hinhChuNhat;

    public CayThong(int xDinh, int yDinh, int chieuCao) {
        int a = xDinh % DoanThang.unitsize;
        this.xDinh = xDinh - a;
        a = yDinh % DoanThang.unitsize;
        this.yDinh = yDinh - a;
        this.chieuCao = chieuCao;

        int xA, yA, xB, yB, xC, yC, aH;

        xA = xDinh;
        yA = yDinh;
        xB = xDinh + chieuCao / 4;
        yB = yDinh + chieuCao / 4;

        hinhTamGiacCan1 = new HinhTamGiacCan(xA, yA, xB, yB);

        xA = xDinh;
        yA = yA + chieuCao / 8;
        xB = xDinh + this.chieuCao / 4;
        yB = yB + this.chieuCao / 4;

//        xC = xA  -xB;
//        yC = yB;
        hinhTamGiacCan2 = new HinhTamGiacCan(xA, yA, xB, yB);

        xA = xDinh;
        yA = yA + chieuCao / 4;
        xB = xDinh + this.chieuCao / 4;
        yB = yB + this.chieuCao / 4;

        hinhTamGiacCan3 = new HinhTamGiacCan(xA, yA, xB, yB);

        xC = hinhTamGiacCan3.getX3();
        yC = hinhTamGiacCan3.getY3();

        hinhChuNhat = new HinhChuNhat(xB + (xC - xB) / 2 + (xC - xB) / 8, yC + chieuCao / 4,
                xB + (xC - xB) / 2 - (xC - xB) / 8, yC
        );
    }

//    public CayThong() {
//        
//    }
//    public CayThong(CayThong ct1) {
//        this.chieuCao = ct1.getChieuCao();
//        this.setHinhChuNhat(ct1.getHinhChuNhat());
//        this.setHinhTamGiacCan1(ct1.getHinhTamGiacCan1());
//        this.setHinhTamGiacCan2(ct1.getHinhTamGiacCan2());
//        this.setHinhTamGiacCan3(ct1.getHinhTamGiacCan3());
//        this.setxDinh(ct1.getxDinh());
//        this.setyDinh(ct1.getyDinh());
//    }
    public void setDrawMode(String drawMode) {
        this.drawMode = drawMode;
    }

    public HinhChuNhat getHinhChuNhat() {
        return hinhChuNhat;
    }

    public void setHinhChuNhat(HinhChuNhat hinhChuNhat) {
        this.hinhChuNhat = hinhChuNhat;
    }

    public HinhTamGiacCan getHinhTamGiacCan1() {
        return hinhTamGiacCan1;
    }

    public void setHinhTamGiacCan1(HinhTamGiacCan hinhTamGiacCan1) {
        this.hinhTamGiacCan1 = hinhTamGiacCan1;
    }

    public HinhTamGiacCan getHinhTamGiacCan2() {
        return hinhTamGiacCan2;
    }

    public void setHinhTamGiacCan2(HinhTamGiacCan hinhTamGiacCan2) {
        this.hinhTamGiacCan2 = hinhTamGiacCan2;
    }

    public HinhTamGiacCan getHinhTamGiacCan3() {
        return hinhTamGiacCan3;
    }

    public void setHinhTamGiacCan3(HinhTamGiacCan hinhTamGiacCan3) {
        this.hinhTamGiacCan3 = hinhTamGiacCan3;
    }

    public int getxDinh() {
        return xDinh;
    }

    public void setxDinh(int xDinh) {
        int a = xDinh % DoanThang.unitsize;
        this.xDinh = xDinh - a;
    }

    public int getyDinh() {
        return yDinh;
    }

    public void setyDinh(int yDinh) {
        int a = yDinh % DoanThang.unitsize;
        this.yDinh = yDinh;
    }

    public int getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(int chieuCao) {
        this.chieuCao = chieuCao;
    }

    public void veCayThong(Graphics2D g) {
//        g.setColor(Color.RED);  //dat mau hinh ve la red
        //khai bao tọa độ các đỉnh

        int xA, yA, xB, yB, xC, yC, aH;
// hình 1
        xA = xDinh;
        yA = yDinh;
        xB = xDinh + chieuCao / 4;
        yB = yDinh + chieuCao / 4;

//        
//        xC = hinhTamGiacCan1.getX3();
//        yC = hinhTamGiacCan1.getY3();
        g.setColor(Color.green);
        g.fillPolygon(new int[]{hinhTamGiacCan1.getxDinh(), hinhTamGiacCan1.getX2(), hinhTamGiacCan1.getX3()},
                new int[]{hinhTamGiacCan1.getyDinh(), hinhTamGiacCan1.getY2(), hinhTamGiacCan1.getY3()}, 3);
        g.setColor(Color.BLACK);
        hinhTamGiacCan1.veHinhTamGiacCan(g);
// hình 2
        xA = xDinh;
        yA = yA + chieuCao / 8;
        xB = xDinh + this.chieuCao / 4;
        yB = yB + this.chieuCao / 4;

//        xC = xA  -xB;
//        yC = yB;
//       
//        hinhTamGiacCan2 = new HinhTamGiacCan(xA, yA, xB, yB);
//        
//        xC = hinhTamGiacCan2.getX3();
//        yC = hinhTamGiacCan2.getY3();
        g.setColor(Color.green);
        g.fillPolygon(new int[]{hinhTamGiacCan2.getxDinh(), hinhTamGiacCan2.getX2(), hinhTamGiacCan2.getX3()},
                new int[]{hinhTamGiacCan2.getyDinh(), hinhTamGiacCan2.getY2(), hinhTamGiacCan2.getY3()}, 3);
        g.setColor(Color.BLACK);
        hinhTamGiacCan2.veHinhTamGiacCan(g);
// hình 3
        xA = xDinh;
        yA = yA + chieuCao / 4;
        xB = xDinh + this.chieuCao / 4;
        yB = yB + this.chieuCao / 4;

//        hinhTamGiacCan3 = new HinhTamGiacCan(xA, yA, xB, yB);
//        
//        xC = hinhTamGiacCan3.getX3();
//        yC = hinhTamGiacCan3.getY3();
        g.setColor(Color.green);
        g.fillPolygon(new int[]{hinhTamGiacCan3.getxDinh(), hinhTamGiacCan3.getX2(), hinhTamGiacCan3.getX3()},
                new int[]{hinhTamGiacCan3.getyDinh(), hinhTamGiacCan3.getY2(), hinhTamGiacCan3.getY3()}, 3);
        g.setColor(Color.BLACK);

        hinhTamGiacCan3.veHinhTamGiacCan(g);
//hình chữ nhật

        g.setColor(new Color(164, 116, 73));
        g.fillPolygon(new int[]{hinhChuNhat.getX1(), hinhChuNhat.getX2(), hinhChuNhat.getX3(), hinhChuNhat.getX4()},
                new int[]{hinhChuNhat.getY1(), hinhChuNhat.getY2(), hinhChuNhat.getY3(), hinhChuNhat.getY4()}, 4);
        g.setColor(Color.black);
        hinhChuNhat.veHinhChuNhat(g);

    }

}
