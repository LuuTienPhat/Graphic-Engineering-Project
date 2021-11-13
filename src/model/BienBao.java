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
public class BienBao {

    private int xTamBienBao, yTamBienBao, chieuCaoTinhTuTam;
    private HinhChuNhat hinhChuNhatChanBienBao;
    private String drawMode = "";
    private HinhChuNhat hinhChuNhat;

    public HinhChuNhat getHinhChuNhatChanBienBao() {
        return hinhChuNhatChanBienBao;
    }

    public void setHinhChuNhatChanBienBao(HinhChuNhat hinhChuNhatChanBienBao) {
        this.hinhChuNhatChanBienBao = hinhChuNhatChanBienBao;
    }

    public String getDrawMode() {
        return drawMode;
    }

    public void setDrawMode(String drawMode) {
        this.drawMode = drawMode;
    }

    public int getxTamBienBao() {
        return xTamBienBao;
    }

    public void setxTamBienBao(int xTamBienBao) {
        int a = xTamBienBao % DoanThang.unitsize;
        this.xTamBienBao = xTamBienBao - a;
    }

    public int getyTamBienBao() {
        return yTamBienBao;
    }

    public void setyTamBienBao(int yTamBienBao) {
        int a = yTamBienBao % DoanThang.unitsize;
        this.yTamBienBao = yTamBienBao - a;
    }

    public BienBao(int xTamBienBao, int yTamBienBao, int chieuCao, String drawMode) {
        int a = xTamBienBao % DoanThang.unitsize;
        this.xTamBienBao = xTamBienBao - a;
        a = yTamBienBao % DoanThang.unitsize;
        this.yTamBienBao = yTamBienBao - a;
        this.chieuCaoTinhTuTam = chieuCao;
        this.drawMode = drawMode;
        int r = 0;
        if (this.drawMode.equals("BienBao")) {
            r = this.chieuCaoTinhTuTam;
            this.hinhChuNhat = new HinhChuNhat(this.xTamBienBao - r * 2 / 3, this.yTamBienBao - r / 10, this.xTamBienBao + r * 2 / 3, this.yTamBienBao + r / 10);
        } else {
            r = chieuCaoTinhTuTam / 4;
            this.hinhChuNhat = new HinhChuNhat(this.xTamBienBao - r * 3 / 4, this.yTamBienBao - r / 7, this.xTamBienBao + r * 3 / 4, this.yTamBienBao + r / 7);

            this.hinhChuNhatChanBienBao = new HinhChuNhat(this.xTamBienBao - r / 10, this.yTamBienBao, this.xTamBienBao + r / 10, this.yTamBienBao + chieuCaoTinhTuTam);
        }

    }

    public int getChieuCaoTinhTuTam() {
        return chieuCaoTinhTuTam;
    }

    public void setChieuCaoTinhTuTam(int chieuCaoTinhTuTam) {
        this.chieuCaoTinhTuTam = chieuCaoTinhTuTam;
    }

    public HinhChuNhat getHinhChuNhat() {
        return hinhChuNhat;
    }

    public void setHinhChuNhat(HinhChuNhat hinhChuNhat) {
        this.hinhChuNhat = hinhChuNhat;
    }

    public void veBienBao(Graphics2D g) {
        if (drawMode.equals("BienBao")) {
            int r = chieuCaoTinhTuTam;
            g.setColor(Color.red);
            g.fillOval(xTamBienBao - r, yTamBienBao - r, r * 2, r * 2);
            g.setColor(Color.black);
            new DuongTron(xTamBienBao, yTamBienBao, r).veDuongTronNetLien(g);

            g.setColor(Color.white);
            g.fillPolygon(new int[]{hinhChuNhat.getX1(), hinhChuNhat.getX2(), hinhChuNhat.getX3(), hinhChuNhat.getX4()},
                    new int[]{hinhChuNhat.getY1(), hinhChuNhat.getY2(), hinhChuNhat.getY3(), hinhChuNhat.getY4()}, 4);
            g.setColor(Color.black);
            this.hinhChuNhat.veHinhChuNhat(g);
        } else { // dùng trong animation
            g.setColor(Color.lightGray);

            g.fillPolygon(new int[]{hinhChuNhatChanBienBao.getX1(), hinhChuNhatChanBienBao.getX2(), hinhChuNhatChanBienBao.getX3(), hinhChuNhatChanBienBao.getX4()},
                    new int[]{hinhChuNhatChanBienBao.getY1(), hinhChuNhatChanBienBao.getY2(), hinhChuNhatChanBienBao.getY3(), hinhChuNhatChanBienBao.getY4()}, 4);
            g.setColor(Color.black);
            hinhChuNhatChanBienBao.veHinhChuNhat(g);

            int r = chieuCaoTinhTuTam / 3;
            g.setColor(Color.red);
            g.fillOval(xTamBienBao - r, yTamBienBao - r, r * 2, r * 2);
            g.setColor(Color.black);
            new DuongTron(xTamBienBao, yTamBienBao, r).veDuongTronNetLien(g);

            g.setColor(Color.white);
            g.fillPolygon(new int[]{hinhChuNhat.getX1(), hinhChuNhat.getX2(), hinhChuNhat.getX3(), hinhChuNhat.getX4()},
                    new int[]{hinhChuNhat.getY1(), hinhChuNhat.getY2(), hinhChuNhat.getY3(), hinhChuNhat.getY4()}, 4);
            g.setColor(Color.black);
            hinhChuNhat.veHinhChuNhat(g);
        }

    }
}
