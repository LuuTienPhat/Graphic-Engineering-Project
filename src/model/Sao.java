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
public class Sao {
    int xO, yO,r,  chieuDaiCanh;
    int xTrenDuongTron, yTrenDuongTron, xDuoiDuongTron, yDuoiDuongTron, xPhaiDuongTron
            , yPhaiDuongTron, xTraiDuongTron, yTraiDuongTron;
    int xTren, yTren, xDuoi, yDuoi, xPhai, yPhai, xTrai, yTrai;
    public Sao(int xO, int yO, int chieuDaiCanh){
        int a = xO%DoanThang.unitsize;
        this.xO = xO-a;
        a = yO%DoanThang.unitsize;
        this.yO = yO-a;
        this.chieuDaiCanh = chieuDaiCanh;
        
        this.r = this.chieuDaiCanh/2;
        
        this.xTren = this.xO;
        this.yTren = this.yO + this.chieuDaiCanh;
        
        this.xDuoi = this.xO;
        this.yDuoi = this.yO - this.chieuDaiCanh;
        
        this.xTrai = this.xO - this.chieuDaiCanh;
        this.yTrai = this.yO;
        
        this.xPhai = this.xO + this.chieuDaiCanh;
        this.yPhai = this.yO;
        
        //
        this.xTrenDuongTron = this.xO;
        this.yTrenDuongTron = this.yO + this.r;
        
        this.xDuoiDuongTron = this.xO;
        this.yDuoiDuongTron = this.yO - this.r;
        
        this.xTraiDuongTron = this.xO - this.r;
        this.yTraiDuongTron = this.yO;
        
        this.xPhaiDuongTron = this.xO + this.r;
        this.yPhaiDuongTron = this.yO;
        
        
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getxTrenDuongTron() {
        return xTrenDuongTron;
    }

    public void setxTrenDuongTron(int xTrenDuongTron) {
        this.xTrenDuongTron = xTrenDuongTron;
    }

    public int getyTrenDuongTron() {
        return yTrenDuongTron;
    }

    public void setyTrenDuongTron(int yTrenDuongTron) {
        this.yTrenDuongTron = yTrenDuongTron;
    }

    public int getxDuoiDuongTron() {
        return xDuoiDuongTron;
    }

    public void setxDuoiDuongTron(int xDuoiDuongTron) {
        this.xDuoiDuongTron = xDuoiDuongTron;
    }

    public int getyDuoiDuongTron() {
        return yDuoiDuongTron;
    }

    public void setyDuoiDuongTron(int yDuoiDuongTron) {
        this.yDuoiDuongTron = yDuoiDuongTron;
    }

    public int getxPhaiDuongTron() {
        return xPhaiDuongTron;
    }

    public void setxPhaiDuongTron(int xPhaiDuongTron) {
        this.xPhaiDuongTron = xPhaiDuongTron;
    }

    public int getyPhaiDuongTron() {
        return yPhaiDuongTron;
    }

    public void setyPhaiDuongTron(int yPhaiDuongTron) {
        this.yPhaiDuongTron = yPhaiDuongTron;
    }

    public int getxTraiDuongTron() {
        return xTraiDuongTron;
    }

    public void setxTraiDuongTron(int xTraiDuongTron) {
        this.xTraiDuongTron = xTraiDuongTron;
    }

    public int getyTraiDuongTron() {
        return yTraiDuongTron;
    }

    public void setyTraiDuongTron(int yTraiDuongTron) {
        this.yTraiDuongTron = yTraiDuongTron;
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

    public int getChieuDaiCanh() {
        return chieuDaiCanh;
    }

    public void setChieuDaiCanh(int chieuDaiCanh) {
        this.chieuDaiCanh = chieuDaiCanh;
    }

    public int getxTren() {
        return xTren;
    }

    public void setxTren(int xTren) {
        this.xTren = xTren;
    }

    public int getyTren() {
        return yTren;
    }

    public void setyTren(int yTren) {
        this.yTren = yTren;
    }

    public int getxDuoi() {
        return xDuoi;
    }

    public void setxDuoi(int xDuoi) {
        this.xDuoi = xDuoi;
    }

    public int getyDuoi() {
        return yDuoi;
    }

    public void setyDuoi(int yDuoi) {
        this.yDuoi = yDuoi;
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
    
    
    public void veSao(Graphics2D g){
        g.setColor(new Color(255,0,255));
        
        g.fillPolygon(new int[]{xDuoi, xPhaiDuongTron, xTren, xTraiDuongTron}, new int[]{yDuoi, yPhaiDuongTron, yTren, yTraiDuongTron}, 4);
        g.fillPolygon(new int[]{xTrai, xTrenDuongTron, xPhai, xDuoiDuongTron}, new int[]{yTrai, yTrenDuongTron, yPhai, yDuoiDuongTron}, 4);
        
//        g.setColor(new Color(139,0,139));
        g.setColor(new Color(255,128,255));
        
        new DuongTron(xO, yO, r).veDuongTronNetLien(g);
        
        new DoanThang(xTrai, yTrai, xTrenDuongTron, yTrenDuongTron).veDoanThang(g);
        new DoanThang(xTrai, yTrai, xDuoiDuongTron, yDuoiDuongTron).veDoanThang(g);
        
        new DoanThang(xPhai, yPhai, xTrenDuongTron, yTrenDuongTron).veDoanThang(g);
        new DoanThang(xPhai, yPhai, xDuoiDuongTron, yDuoiDuongTron).veDoanThang(g);
        
        new DoanThang(xTren, yTren, xTraiDuongTron, yTraiDuongTron).veDoanThang(g);
        new DoanThang(xTren, yTren, xPhaiDuongTron, yPhaiDuongTron).veDoanThang(g);
        
        new DoanThang(xDuoi, yDuoi, xTraiDuongTron, yTraiDuongTron).veDoanThang(g);
        new DoanThang(xDuoi, yDuoi, xPhaiDuongTron, yPhaiDuongTron).veDoanThang(g);
        
        
    }
}
