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
public class New_Oto {

    int xMuiXeDuoi, yMuiXeDuoi, xMuiXeGiua, yMuiXeGiua, xMuiXeTren, yMuiXeTren;
    int xNocXe1, yNocXe1, xNocXe2, yNocXe2, xNocXe3, yNocXe3;

    int xDuoiXe1, yDuoiXe1, xDuoiXe2, yDuoiXe2, xDuoiXe3, yDuoiXe3, xDuoiXe4, yDuoiXe4, xDuoiXe5, yDuoiXe5, xDuoiXeDuoi, yDuoiXeDuoi;

    int xBanhXeTruoc, yBanhXeTruoc, xBanhXeSau, yBanhXeSau, rBanhTruoc, rBanhSau;

    int chieuDai;

    int xKinh1, yKinh1, xKinh2, yKinh2, xKinh3, yKinh3, xKinh4, yKinh4, xKinh5, yKinh5, xKinh6, yKinh6, xKinh7, yKinh7, xKinh8, yKinh8, xKinh9, yKinh9;
    
    int xChiTiet1, yChiTiet1, xChiTiet2, yChiTiet2;
    
    public New_Oto(int xMuiXeDuoi, int yMuiXeDuoi, int xDuoiXe1, int yDuoiXe1) {
        this.xMuiXeDuoi = xMuiXeDuoi;
        this.yMuiXeDuoi = yMuiXeDuoi;
        this.xDuoiXe1 = xDuoiXe1;
        this.yDuoiXe1 = yDuoiXe1;

        this.chieuDai = (int) Math.sqrt((xDuoiXe1 - xMuiXeDuoi) * (xDuoiXe1 - xMuiXeDuoi) + (yDuoiXe1 - yMuiXeDuoi) * (yDuoiXe1 - yMuiXeDuoi));

        this.xMuiXeGiua = this.xMuiXeDuoi + chieuDai * 2 / 100;
        this.yMuiXeGiua = this.yMuiXeDuoi - chieuDai * 3 / 100;

        this.xMuiXeTren = this.xMuiXeDuoi;
        this.yMuiXeTren = this.yMuiXeDuoi - 7 * chieuDai / 100;

        this.xNocXe1 = this.xMuiXeDuoi + chieuDai * 9 / 100;
        this.yNocXe1 = this.yMuiXeDuoi - chieuDai * 12 / 100;

        this.xNocXe2 = this.xMuiXeDuoi + chieuDai * 40 / 100;
        this.yNocXe2 = this.yMuiXeDuoi - chieuDai * 20 / 100;

        this.xNocXe3 = this.xMuiXeDuoi + chieuDai * 63 / 100;
        this.yNocXe3 = this.yMuiXeDuoi - chieuDai * 20 / 100;

        this.xDuoiXe1 = this.xMuiXeDuoi + chieuDai;
        this.yDuoiXe1 = this.yMuiXeDuoi - chieuDai * 16 / 100;

        this.xDuoiXe2 = this.xMuiXeDuoi + chieuDai * 97 / 100;
        this.yDuoiXe2 = this.yMuiXeDuoi - chieuDai * 13 / 100;

        this.xDuoiXe3 = this.xMuiXeDuoi + chieuDai * 97 / 100;
        this.yDuoiXe3 = this.yMuiXeDuoi - chieuDai * 10 / 100;

        this.xDuoiXe4 = this.xMuiXeDuoi + chieuDai * 100 / 100;
        this.yDuoiXe4 = this.yMuiXeDuoi - chieuDai * 10 / 100;

        this.xDuoiXe5 = this.xMuiXeDuoi + chieuDai * 96 / 100;
        this.yDuoiXe5 = this.yMuiXeDuoi - chieuDai * 3 / 100;

        this.xDuoiXeDuoi = this.xMuiXeDuoi + chieuDai * 88 / 100;
        this.yDuoiXeDuoi = this.yMuiXeDuoi;

        this.xBanhXeTruoc = this.xMuiXeDuoi + chieuDai * 17 / 100;
        this.yBanhXeTruoc = this.yMuiXeDuoi - chieuDai * 4 / 100;
        this.rBanhTruoc = chieuDai * 7 / 100;

        this.xBanhXeTruoc = this.xMuiXeDuoi + chieuDai * 17 / 100;
        this.yBanhXeTruoc = this.yMuiXeDuoi - chieuDai * 4 / 100;
        this.rBanhTruoc = chieuDai * 7 / 100;

        this.xBanhXeSau = this.xMuiXeDuoi + chieuDai * 80 / 100;
        this.yBanhXeSau = this.yMuiXeDuoi - chieuDai * 5 / 100;
        this.rBanhSau = chieuDai * 8 / 100;
        
        this.xKinh1 = this.xMuiXeDuoi + chieuDai * 22 / 100;
        this.yKinh1 = this.yMuiXeDuoi - chieuDai * 13/ 100;
        
        this.xKinh2 = this.xMuiXeDuoi + chieuDai * 40 / 100;
        this.yKinh2 = this.yMuiXeDuoi - chieuDai * 18/ 100;  
        
        this.xKinh3 =this.xMuiXeDuoi + chieuDai * 52 / 100;
        this.yKinh3 =this.yMuiXeDuoi - chieuDai * 18/ 100;  

        this.xKinh4 = this.xMuiXeDuoi + chieuDai * 64 / 100;
        this.yKinh4 = this.yMuiXeDuoi - chieuDai * 18/ 100;  
        
        this.xKinh5 = this.xMuiXeDuoi + chieuDai * 67 / 100;
        this.yKinh5 = this.yMuiXeDuoi - chieuDai * 15/ 100;  
        
        this.xKinh6 = this.xMuiXeDuoi + chieuDai * 45 / 100;
        this.yKinh6 = this.yMuiXeDuoi - chieuDai * 12/ 100;  
        
        this.xKinh7 = this.xMuiXeDuoi + chieuDai * 66 / 100;
        this.yKinh7 = this.yMuiXeDuoi - chieuDai * 20/ 100;
        
        this.xKinh8 = this.xMuiXeDuoi + chieuDai * 71 / 100;
        this.yKinh8 = this.yMuiXeDuoi - chieuDai * 16/ 100;
        
        this.xKinh9 = this.xMuiXeDuoi + chieuDai * 80 / 100;
        this.yKinh9 = this.yMuiXeDuoi - chieuDai * 18/ 100;
        
        this.xChiTiet1 = this.xMuiXeDuoi + chieuDai * 70 / 100;
        this.yChiTiet1 = this.yMuiXeDuoi - chieuDai * 12 / 100;
        
         this.xChiTiet2 = this.xMuiXeDuoi + chieuDai * 63 / 100;
        this.yChiTiet2 = this.yMuiXeDuoi - chieuDai * 5 / 100;
    }

    public int getxChiTiet1() {
        return xChiTiet1;
    }

    public void setxChiTiet1(int xChiTiet1) {
        this.xChiTiet1 = xChiTiet1;
    }

    public int getyChiTiet1() {
        return yChiTiet1;
    }

    public void setyChiTiet1(int yChiTiet1) {
        this.yChiTiet1 = yChiTiet1;
    }

    public int getxChiTiet2() {
        return xChiTiet2;
    }

    public void setxChiTiet2(int xChiTiet2) {
        this.xChiTiet2 = xChiTiet2;
    }

    public int getyChiTiet2() {
        return yChiTiet2;
    }

    public void setyChiTiet2(int yChiTiet2) {
        this.yChiTiet2 = yChiTiet2;
    }

    public int getxMuiXeDuoi() {
        return xMuiXeDuoi;
    }

    public void setxMuiXeDuoi(int xMuiXeDuoi) {
        this.xMuiXeDuoi = xMuiXeDuoi;
    }

    public int getyMuiXeDuoi() {
        return yMuiXeDuoi;
    }

    public void setyMuiXeDuoi(int yMuiXeDuoi) {
        this.yMuiXeDuoi = yMuiXeDuoi;
    }

    public int getxMuiXeGiua() {
        return xMuiXeGiua;
    }

    public void setxMuiXeGiua(int xMuiXeGiua) {
        this.xMuiXeGiua = xMuiXeGiua;
    }

    public int getyMuiXeGiua() {
        return yMuiXeGiua;
    }

    public void setyMuiXeGiua(int yMuiXeGiua) {
        this.yMuiXeGiua = yMuiXeGiua;
    }

    public int getxMuiXeTren() {
        return xMuiXeTren;
    }

    public void setxMuiXeTren(int xMuiXeTren) {
        this.xMuiXeTren = xMuiXeTren;
    }

    public int getyMuiXeTren() {
        return yMuiXeTren;
    }

    public void setyMuiXeTren(int yMuiXeTren) {
        this.yMuiXeTren = yMuiXeTren;
    }

    public int getxNocXe1() {
        return xNocXe1;
    }

    public void setxNocXe1(int xNocXe1) {
        this.xNocXe1 = xNocXe1;
    }

    public int getyNocXe1() {
        return yNocXe1;
    }

    public void setyNocXe1(int yNocXe1) {
        this.yNocXe1 = yNocXe1;
    }

    public int getxNocXe2() {
        return xNocXe2;
    }

    public void setxNocXe2(int xNocXe2) {
        this.xNocXe2 = xNocXe2;
    }

    public int getyNocXe2() {
        return yNocXe2;
    }

    public void setyNocXe2(int yNocXe2) {
        this.yNocXe2 = yNocXe2;
    }

    public int getxNocXe3() {
        return xNocXe3;
    }

    public void setxNocXe3(int xNocXe3) {
        this.xNocXe3 = xNocXe3;
    }

    public int getyNocXe3() {
        return yNocXe3;
    }

    public void setyNocXe3(int yNocXe3) {
        this.yNocXe3 = yNocXe3;
    }

    public int getxDuoiXe1() {
        return xDuoiXe1;
    }

    public void setxDuoiXe1(int xDuoiXe1) {
        this.xDuoiXe1 = xDuoiXe1;
    }

    public int getyDuoiXe1() {
        return yDuoiXe1;
    }

    public void setyDuoiXe1(int yDuoiXe1) {
        this.yDuoiXe1 = yDuoiXe1;
    }

    public int getxDuoiXe2() {
        return xDuoiXe2;
    }

    public void setxDuoiXe2(int xDuoiXe2) {
        this.xDuoiXe2 = xDuoiXe2;
    }

    public int getyDuoiXe2() {
        return yDuoiXe2;
    }

    public void setyDuoiXe2(int yDuoiXe2) {
        this.yDuoiXe2 = yDuoiXe2;
    }

    public int getxDuoiXe3() {
        return xDuoiXe3;
    }

    public void setxDuoiXe3(int xDuoiXe3) {
        this.xDuoiXe3 = xDuoiXe3;
    }

    public int getyDuoiXe3() {
        return yDuoiXe3;
    }

    public void setyDuoiXe3(int yDuoiXe3) {
        this.yDuoiXe3 = yDuoiXe3;
    }

    public int getxDuoiXe4() {
        return xDuoiXe4;
    }

    public void setxDuoiXe4(int xDuoiXe4) {
        this.xDuoiXe4 = xDuoiXe4;
    }

    public int getyDuoiXe4() {
        return yDuoiXe4;
    }

    public void setyDuoiXe4(int yDuoiXe4) {
        this.yDuoiXe4 = yDuoiXe4;
    }

    public int getxDuoiXe5() {
        return xDuoiXe5;
    }

    public void setxDuoiXe5(int xDuoiXe5) {
        this.xDuoiXe5 = xDuoiXe5;
    }

    public int getyDuoiXe5() {
        return yDuoiXe5;
    }

    public void setyDuoiXe5(int yDuoiXe5) {
        this.yDuoiXe5 = yDuoiXe5;
    }

    public int getxDuoiXeDuoi() {
        return xDuoiXeDuoi;
    }

    public void setxDuoiXeDuoi(int xDuoiXeDuoi) {
        this.xDuoiXeDuoi = xDuoiXeDuoi;
    }

    public int getyDuoiXeDuoi() {
        return yDuoiXeDuoi;
    }

    public void setyDuoiXeDuoi(int yDuoiXeDuoi) {
        this.yDuoiXeDuoi = yDuoiXeDuoi;
    }

    public int getxBanhXeTruoc() {
        return xBanhXeTruoc;
    }

    public void setxBanhXeTruoc(int xBanhXeTruoc) {
        this.xBanhXeTruoc = xBanhXeTruoc;
    }

    public int getyBanhXeTruoc() {
        return yBanhXeTruoc;
    }

    public void setyBanhXeTruoc(int yBanhXeTruoc) {
        this.yBanhXeTruoc = yBanhXeTruoc;
    }

    public int getxBanhXeSau() {
        return xBanhXeSau;
    }

    public void setxBanhXeSau(int xBanhXeSau) {
        this.xBanhXeSau = xBanhXeSau;
    }

    public int getyBanhXeSau() {
        return yBanhXeSau;
    }

    public void setyBanhXeSau(int yBanhXeSau) {
        this.yBanhXeSau = yBanhXeSau;
    }

    public int getrBanhTruoc() {
        return rBanhTruoc;
    }

    public void setrBanhTruoc(int rBanhTruoc) {
        this.rBanhTruoc = rBanhTruoc;
    }

    public int getrBanhSau() {
        return rBanhSau;
    }

    public void setrBanhSau(int rBanhSau) {
        this.rBanhSau = rBanhSau;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public int getxKinh1() {
        return xKinh1;
    }

    public void setxKinh1(int xKinh1) {
        this.xKinh1 = xKinh1;
    }

    public int getyKinh1() {
        return yKinh1;
    }

    public void setyKinh1(int yKinh1) {
        this.yKinh1 = yKinh1;
    }

    public int getxKinh2() {
        return xKinh2;
    }

    public void setxKinh2(int xKinh2) {
        this.xKinh2 = xKinh2;
    }

    public int getyKinh2() {
        return yKinh2;
    }

    public void setyKinh2(int yKinh2) {
        this.yKinh2 = yKinh2;
    }

    public int getxKinh3() {
        return xKinh3;
    }

    public void setxKinh3(int xKinh3) {
        this.xKinh3 = xKinh3;
    }

    public int getyKinh3() {
        return yKinh3;
    }

    public void setyKinh3(int yKinh3) {
        this.yKinh3 = yKinh3;
    }

    public int getxKinh4() {
        return xKinh4;
    }

    public void setxKinh4(int xKinh4) {
        this.xKinh4 = xKinh4;
    }

    public int getyKinh4() {
        return yKinh4;
    }

    public void setyKinh4(int yKinh4) {
        this.yKinh4 = yKinh4;
    }

    public int getxKinh5() {
        return xKinh5;
    }

    public void setxKinh5(int xKinh5) {
        this.xKinh5 = xKinh5;
    }

    public int getyKinh5() {
        return yKinh5;
    }

    public void setyKinh5(int yKinh5) {
        this.yKinh5 = yKinh5;
    }

    public int getxKinh6() {
        return xKinh6;
    }

    public void setxKinh6(int xKinh6) {
        this.xKinh6 = xKinh6;
    }

    public int getyKinh6() {
        return yKinh6;
    }

    public void setyKinh6(int yKinh6) {
        this.yKinh6 = yKinh6;
    }

    public int getxKinh7() {
        return xKinh7;
    }

    public void setxKinh7(int xKinh7) {
        this.xKinh7 = xKinh7;
    }

    public int getyKinh7() {
        return yKinh7;
    }

    public void setyKinh7(int yKinh7) {
        this.yKinh7 = yKinh7;
    }

    public int getxKinh8() {
        return xKinh8;
    }

    public void setxKinh8(int xKinh8) {
        this.xKinh8 = xKinh8;
    }

    public int getyKinh8() {
        return yKinh8;
    }

    public void setyKinh8(int yKinh8) {
        this.yKinh8 = yKinh8;
    }

    public int getxKinh9() {
        return xKinh9;
    }

    public void setxKinh9(int xKinh9) {
        this.xKinh9 = xKinh9;
    }

    public int getyKinh9() {
        return yKinh9;
    }

    public void setyKinh9(int yKinh9) {
        this.yKinh9 = yKinh9;
    }

    public void veNewOto(Graphics2D g) {
        g.setColor(Color.black);
        g.fillPolygon(new int[]{xMuiXeDuoi, xMuiXeGiua, xMuiXeTren, xNocXe1, xNocXe2, xNocXe3, xDuoiXe1, xDuoiXe2, xDuoiXe3, xDuoiXe4, xDuoiXe5, xDuoiXeDuoi},
                 new int[]{yMuiXeDuoi, yMuiXeGiua, yMuiXeTren, yNocXe1, yNocXe2, yNocXe3, yDuoiXe1, yDuoiXe2, yDuoiXe3, yDuoiXe4, yDuoiXe5, yDuoiXeDuoi}, 12);
        g.setColor(Color.red);
        //khung
        new DoanThang(xMuiXeDuoi, yMuiXeDuoi, xMuiXeGiua, yMuiXeGiua).veDoanThang(g);
        new DoanThang(xMuiXeTren, yMuiXeTren, xMuiXeGiua, yMuiXeGiua).veDoanThang(g);

        new DoanThang(xMuiXeTren, yMuiXeTren, xNocXe1, yNocXe1).veDoanThang(g);
        new DoanThang(xNocXe2, yNocXe2, xNocXe1, yNocXe1).veDoanThang(g);
        new DoanThang(xNocXe2, yNocXe2, xNocXe3, yNocXe3).veDoanThang(g);
//        
        new DoanThang(xDuoiXe1, yDuoiXe1, xNocXe3, yNocXe3).veDoanThang(g);
        new DoanThang(xDuoiXe1, yDuoiXe1, xDuoiXe2, yDuoiXe2).veDoanThang(g);
        new DoanThang(xDuoiXe3, yDuoiXe3, xDuoiXe2, yDuoiXe2).veDoanThang(g);
        new DoanThang(xDuoiXe3, yDuoiXe3, xDuoiXe4, yDuoiXe4).veDoanThang(g);
        new DoanThang(xDuoiXe5, yDuoiXe5, xDuoiXe4, yDuoiXe4).veDoanThang(g);
//        
        new DoanThang(xDuoiXe5, yDuoiXe5, xDuoiXeDuoi, yDuoiXeDuoi).veDoanThang(g);
        new DoanThang(xMuiXeDuoi, yMuiXeDuoi, xDuoiXeDuoi, yDuoiXeDuoi).veDoanThang(g); 
        //kinh
        new DoanThang(xKinh1, yKinh1, xKinh2, yKinh2).veDoanThang(g);
        new DoanThang(xKinh4, yKinh4, xKinh2, yKinh2).veDoanThang(g);
        new DoanThang(xKinh4, yKinh4, xKinh5, yKinh5).veDoanThang(g);
        new DoanThang(xKinh6, yKinh6, xKinh5, yKinh5).veDoanThang(g);
        new DoanThang(xKinh6, yKinh6, xKinh1, yKinh1).veDoanThang(g);
        new DoanThang(xKinh6, yKinh6, xKinh3, yKinh3).veDoanThang(g);
        
        new DoanThang(xKinh7, yKinh7, xKinh8, yKinh8).veDoanThang(g);
        new DoanThang(xKinh9, yKinh9, xKinh8, yKinh8).veDoanThang(g);
        //
        new DoanThang(xChiTiet1, yChiTiet1, xBanhXeSau, yBanhXeSau).veDoanThang(g);
        new DoanThang(xChiTiet1, yChiTiet1, xChiTiet2, yChiTiet2).veDoanThang(g);
         new DoanThang(xBanhXeTruoc, yBanhXeTruoc, xChiTiet2, yChiTiet2).veDoanThang(g);
        //
        g.setColor(Color.DARK_GRAY);
        g.fillOval(xBanhXeTruoc - rBanhTruoc, yBanhXeTruoc - rBanhTruoc, rBanhTruoc * 2, rBanhTruoc * 2);
        g.setColor(Color.black);
        g.fillOval(xBanhXeTruoc - rBanhTruoc * 3 / 5, yBanhXeTruoc - rBanhTruoc * 3 / 5, (rBanhTruoc * 3 / 5) * 2, (rBanhTruoc * 3 / 5) * 2);
        g.setColor(Color.red);
        new DuongTron(xBanhXeTruoc, yBanhXeTruoc, rBanhTruoc).veDuongTronNetLien(g);
        new DuongTron(xBanhXeTruoc, yBanhXeTruoc, rBanhTruoc * 3 / 5).veDuongTronNetLien(g);

        g.setColor(Color.DARK_GRAY);
        g.fillOval(xBanhXeSau - rBanhSau, yBanhXeSau - rBanhSau, rBanhSau * 2, rBanhSau * 2);
        g.setColor(Color.black);
        g.fillOval(xBanhXeSau - rBanhSau * 3 / 5, yBanhXeSau - rBanhSau * 3 / 5, (rBanhSau * 3 / 5) * 2, (rBanhSau * 3 / 5) * 2);
        g.setColor(Color.red);
        new DuongTron(xBanhXeSau, yBanhXeSau, rBanhSau).veDuongTronNetLien(g);
        new DuongTron(xBanhXeSau, yBanhXeSau, rBanhSau * 3 / 5).veDuongTronNetLien(g);
    }
}
