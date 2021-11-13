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
public class Oto {

    private int xMuiXe, yMuiXe, chieuDai;

    public Oto(int xMuiXe, int yMuiXe, int chieuDai) {
        int a = xMuiXe%DoanThang.unitsize;
        this.xMuiXe = xMuiXe-a;
        a = yMuiXe%DoanThang.unitsize;
        this.yMuiXe = yMuiXe-a;
        this.chieuDai = chieuDai;
    }

    public void veOto(Graphics2D g) {
        this.veNen(g);
        this.veKhungOto(g);
        
        this.veBanhXe(g);
        this.veChiTiet(g);
    }

    public int getxMuiXe() {
        return xMuiXe;
    }

    public void setxMuiXe(int xMuiXe) {
        int a = xMuiXe%DoanThang.unitsize;
        this.xMuiXe = xMuiXe-a;
    }

    public int getyMuiXe() {
        return yMuiXe;
    }

    public void setyMuiXe(int yMuiXe) {
        int a = yMuiXe%DoanThang.unitsize;
        this.yMuiXe = yMuiXe-a;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public void veNen(Graphics2D g) {
        g.setColor(Color.black);
        g.fillRect(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 10 / 100, chieuDai * 48 / 100, chieuDai * 10 / 100);
        g.fillRect(xMuiXe + chieuDai * 23 / 100, yMuiXe - chieuDai * 15 / 100, chieuDai * 50 / 100, chieuDai * 10 / 100);
        g.fillRect(xMuiXe + chieuDai * 38 / 100, yMuiXe - chieuDai * 19 / 100, chieuDai * 40 / 100, chieuDai * 10 / 100);
        g.fillRect(xMuiXe + chieuDai * 75 / 100, yMuiXe - chieuDai * 17 / 100, chieuDai * 15 / 100, chieuDai * 10 / 100);
//        g.fillRect(xMuiXe + chieuDai * 75 / 100, yMuiXe - chieuDai * 17 / 100, chieuDai * 15 / 100, chieuDai * 10 / 100);

        new DoanThang(xMuiXe, yMuiXe - chieuDai * 1 / 100, xMuiXe + chieuDai * 11 / 100, yMuiXe - chieuDai * 1 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 1 / 100, xMuiXe + chieuDai * 73 / 100, yMuiXe - chieuDai * 1 / 100).veDoanThang(g);

        new DoanThang(xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 2 / 100, xMuiXe + chieuDai * 9 / 100, yMuiXe - chieuDai * 2 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 2 / 100, xMuiXe + chieuDai * 72 / 100, yMuiXe - chieuDai * 2 / 100).veDoanThang(g);

        new DoanThang(xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 9 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);

        new DoanThang(xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 4 / 100, xMuiXe + chieuDai * 9 / 100, yMuiXe - chieuDai * 4 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 4 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 4 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 4 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 4 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 5 / 100, xMuiXe + chieuDai * 15 / 100, yMuiXe - chieuDai * 5 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 5 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 5 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 5 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 5 / 100).veDoanThang(g);
        
         new DoanThang(xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 6/ 100, xMuiXe + chieuDai * 15 / 100, yMuiXe - chieuDai * 6 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 6 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 6 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 6 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 6 / 100).veDoanThang(g);
        
         new DoanThang(xMuiXe + chieuDai * 3 / 100, yMuiXe - chieuDai * 7 / 100, xMuiXe + chieuDai * 15 / 100, yMuiXe - chieuDai * 7 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 7 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 7 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 7 / 100, xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 7 / 100).veDoanThang(g);
        
         new DoanThang(xMuiXe + chieuDai * 3 / 100, yMuiXe - chieuDai * 8 / 100, xMuiXe + chieuDai * 15 / 100, yMuiXe - chieuDai * 8 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 8 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 8 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 8 / 100, xMuiXe + chieuDai * 98 / 100, yMuiXe - chieuDai * 8 / 100).veDoanThang(g);
        
         new DoanThang(xMuiXe + chieuDai * 6 / 100, yMuiXe - chieuDai * 9 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 9 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 9 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 9 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 9 / 100, xMuiXe + chieuDai * 99 / 100, yMuiXe - chieuDai * 9 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai * 7 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai * 7 / 100, yMuiXe - chieuDai * 11 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 11 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 11 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 11 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 11 / 100, xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 11 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai * 10 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai * 12 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
//        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
//        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 94 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);

        new DoanThang(xMuiXe + chieuDai * 16 / 100, yMuiXe - chieuDai * 14 / 100, xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 14 / 100).veDoanThang(g);
//        new DoanThang(xMuiXe + chieuDai * 24 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
//        new DoanThang(xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 94 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);

        new DoanThang(xMuiXe + chieuDai * 19 / 100, yMuiXe - chieuDai * 15 / 100, xMuiXe + chieuDai * 98 / 100, yMuiXe - chieuDai * 15 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai *24 / 100, yMuiXe - chieuDai * 16 / 100, xMuiXe + chieuDai * 98 / 100, yMuiXe - chieuDai * 16 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai *26 / 100, yMuiXe - chieuDai * 17 / 100, xMuiXe + chieuDai * 98 / 100, yMuiXe - chieuDai * 17 / 100).veDoanThang(g);
        
        new DoanThang(xMuiXe + chieuDai *32 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 70 / 100, yMuiXe - chieuDai * 18 / 100).veDoanThang(g);
        
//        new DoanThang(xMuiXe + chieuDai *27 / 100, yMuiXe - chieuDai * 17 / 100, xMuiXe + chieuDai * 90 / 100, yMuiXe - chieuDai * 17 / 100).veDoanThang(g);
        

        g.setColor(Color.darkGray);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 7 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 6 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 5 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 4 / 100).veDuongTronNetLien(g);
        g.setColor(Color.gray);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 3 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 2 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 1 / 100).veDuongTronNetLien(g);
        g.setColor(Color.darkGray);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 8 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 7 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 6 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 5 / 100).veDuongTronNetLien(g);
        g.setColor(Color.gray);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 4 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 3 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 2 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 1 / 100).veDuongTronNetLien(g);
    }

    public void veKhungOto(Graphics2D g) {
        g.setColor(Color.red);
        new DoanThang(xMuiXe, yMuiXe, xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe, yMuiXe - 7 * chieuDai / 100, xMuiXe + chieuDai * 2 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 9 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe, yMuiXe - 7 * chieuDai / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 40 / 100, yMuiXe - chieuDai * 20 / 100, xMuiXe + chieuDai * 9 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 63 / 100, yMuiXe - chieuDai * 20 / 100, xMuiXe + chieuDai * 40 / 100, yMuiXe - chieuDai * 20 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 16 / 100, xMuiXe + chieuDai * 63 / 100, yMuiXe - chieuDai * 20 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 16 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 96 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 88 / 100, yMuiXe - chieuDai * 2 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 97 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 100 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 74 / 100, yMuiXe, xMuiXe + chieuDai * 23 / 100, yMuiXe).veDoanThang(g);
        new DoanThang(xMuiXe, yMuiXe, xMuiXe + chieuDai * 10 / 100, yMuiXe).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 40 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 22 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 40 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 64 / 100, yMuiXe - chieuDai * 18 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 45 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe + chieuDai * 22 / 100, yMuiXe - chieuDai * 13 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 45 / 100, yMuiXe - chieuDai * 12 / 100, xMuiXe + chieuDai * 67 / 100, yMuiXe - chieuDai * 15 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 64 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 67 / 100, yMuiXe - chieuDai * 15 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 52 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 49 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 66 / 100, yMuiXe - chieuDai * 20 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 16 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 18 / 100, xMuiXe + chieuDai * 71 / 100, yMuiXe - chieuDai * 16 / 100).veDoanThang(g);
    }

    public void veBanhXe(Graphics2D g) {
        g.setColor(Color.red);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 7 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 17 / 100, yMuiXe - chieuDai * 4 / 100, chieuDai * 4 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 8 / 100).veDuongTronNetLien(g);
        new DuongTron(xMuiXe + chieuDai * 80 / 100, yMuiXe - chieuDai * 5 / 100, chieuDai * 5 / 100).veDuongTronNetLien(g);
    }


    public void veChiTiet(Graphics2D g) {
        g.setColor(Color.red);
        new DoanThang(xMuiXe + chieuDai * 28 / 100, yMuiXe - chieuDai * 13 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 26 / 100, yMuiXe - chieuDai * 3 / 100, xMuiXe + chieuDai * 25 / 100, yMuiXe - chieuDai * 10 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 28 / 100, yMuiXe - chieuDai * 0 / 100, xMuiXe + chieuDai * 26 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 63 / 100, yMuiXe - chieuDai * 5 / 100, xMuiXe + chieuDai * 26 / 100, yMuiXe - chieuDai * 3 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 63 / 100, yMuiXe - chieuDai * 5 / 100, xMuiXe + chieuDai * 70 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);
        new DoanThang(xMuiXe + chieuDai * 73 / 100, yMuiXe - chieuDai * 10 / 100, xMuiXe + chieuDai * 70 / 100, yMuiXe - chieuDai * 12 / 100).veDoanThang(g);

    }
}
