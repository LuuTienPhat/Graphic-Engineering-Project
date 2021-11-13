/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Graphics2D;

/**
 *
 * @author tuanbuiquoc
 */
public class May {
    private int xO, yO, r;
    int xTrai, yTrai, xPhai, yPhai;
    int rTrai, rPhai;
    private String drawMode = "";
    public May(int xO, int yO, int r, String drawMode){     
        this.xO = xO;
        this.yO = yO ;
        this.r = r;
        this.drawMode = drawMode;
        if(this.drawMode.equals("May1")){
            this.xTrai = this.xO - 45;
            this.yTrai = this.yO+5;
            this.rTrai = this.r -5;
            this.xPhai = this.xO +25;
            this.yPhai = this.yO-5;
            this.rPhai = this.r -15;
        }
        if(this.drawMode.equals("May2")){
            this.xTrai = this.xO - 10;
            this.yTrai = this.yO+10;
            this.rTrai = this.r;
            this.xPhai = this.xO +3;
            this.yPhai = this.yO+8;
            this.rPhai = this.r -2;
        }
        if(this.drawMode.equals("May3")){
            this.xTrai = this.xO - 45;
            this.yTrai = this.yO+5;
            this.rTrai = this.r -5;
            this.xPhai = this.xO +20;
            this.yPhai = this.yO;
            this.rPhai = this.r -10;
        }
        if(this.drawMode.equals("May4")){
            this.xTrai = this.xO - 45;
            this.yTrai = this.yO+5;
            this.rTrai = this.r -5;
            this.xPhai = this.xO +20;
            this.yPhai = this.yO;
            this.rPhai = this.r -10;
        }
        if(this.drawMode.equals("May5")){
            this.xTrai = this.xO - 10;
            this.yTrai = this.yO+10;
            this.rTrai = this.r;
            this.xPhai = this.xO +3;
            this.yPhai = this.yO+8;
            this.rPhai = this.r -2;
        }
        if(this.drawMode.equals("May6")){
            this.xTrai = this.xO - 5;
            this.yTrai = this.yO+5;
            this.rTrai = this.r-5;
            this.xPhai = this.xO -5;
            this.yPhai = this.yO;
            this.rPhai = this.r -10;
        }
    }

    public int getxO() {
        return xO;
    }

    public void setxO(int xO) {
        this.xO = xO;
    }

    public int getyO() {
        return yO;
    }

    public void setyO(int yO) {
        this.yO = yO;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getxTrai() {
        return xTrai;
    }

    public void setxTrai(int xTrai) {
        this.xTrai = xTrai;
    }

    public int getyTrai() {
        return yTrai;
    }

    public void setyTrai(int yTrai) {
        this.yTrai = yTrai;
    }

    public int getxPhai() {
        return xPhai;
    }

    public void setxPhai(int xPhai) {
        this.xPhai = xPhai;
    }

    public int getyPhai() {
        return yPhai;
    }

    public void setyPhai(int yPhai) {
        this.yPhai = yPhai;
    }

    public int getrTrai() {
        return rTrai;
    }

    public void setrTrai(int rTrai) {
        this.rTrai = rTrai;
    }

    public int getrPhai() {
        return rPhai;
    }

    public void setrPhai(int rPhai) {
        this.rPhai = rPhai;
    }

    public String getDrawMode() {
        return drawMode;
    }

    public void setDrawMode(String drawMode) {
        this.drawMode = drawMode;
    }
    
    public void veMay(Graphics2D g){
            new DuongTron(xO, yO, r).veDuongTronNetLien(g);
            new DuongTron(xTrai, yTrai, rTrai).veDuongTronNetLien(g);
            new DuongTron(xPhai, yPhai, rPhai).veDuongTronNetLien(g);
            
            g.fillOval(xO-r, yO-r, r*2, r*2);
            g.fillOval(xTrai-rTrai, yTrai-rTrai, rTrai*2, rTrai*2);
            g.fillOval(xPhai-rPhai, yPhai-rPhai, rPhai*2, rPhai*2);
    }
}
