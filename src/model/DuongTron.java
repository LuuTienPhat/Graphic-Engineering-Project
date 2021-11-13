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
public class DuongTron {

    private int xO, yO, r;
    private String drawMode = "";

    public DuongTron(int xO, int yO, int r) {
        int a = xO % DoanThang.unitsize;
        this.xO = xO - a;
        a = yO % DoanThang.unitsize;
        this.yO = yO - a;
        this.r = r;
//        this.xO = xO;
//        this.yO = yO;
//        this.r = r;
    }

    public String getDrawMode() {
        return drawMode;
    }

    public void setxO(int xO) {
        int a = xO % DoanThang.unitsize;
        this.xO = xO - a;
    }

    public void setyO(int yO) {
        int a = yO % DoanThang.unitsize;
        this.yO = yO - a;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setDrawMode(String drawMode) {
        this.drawMode = drawMode;
    }

    public int getxO() {
        return xO;
    }

    public int getyO() {
        return yO;
    }

    public int getR() {
        return r;
    }

    public void veDuongTronNetLien(Graphics2D g) {
//        g.setColor(Color.red);  //dat mau hinh ve la red
        int x, y, p;
        g.fillRect(xO, yO, DoanThang.fillValue, DoanThang.fillValue);
//        g.drawString((xO - KTDH_Nhom8.graphWidth / 2) / KTDH_Nhom8.step + "," + (yO - KTDH_Nhom8.graphHeight / 2) / (-KTDH_Nhom8.step), xO + 3, yO + 3);
        p = 1-r;
        x = 0;
        y = r;
//        g.fillRect(x, y, 5, 5);
        g.fillRect(x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
        while (x < y) { //ve 1/8 duong tron
            x += DoanThang.unitsize;
           
            if (p < 0) {
                p += 2 * x + 3;
            } else {
                p += 2 * (x - y) + 5;
//                y--;
                y -= DoanThang.unitsize;
            } 
            g.fillRect(x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(-y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(-x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(-x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(-y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
            g.fillRect(x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
//            x++;

        }
//        g.fillRect(x + xO, y + yO, 3, 3);
//        g.fillRect(y + xO, x + yO, 3, 3);
//        g.fillRect(-y + xO, x + yO, 3, 3);
//        g.fillRect(-x + xO, y + yO, 3, 3);
//        g.fillRect(-x + xO, -y + yO, 3, 3);
//        g.fillRect(-y + xO, -x + yO, 3, 3);
//        g.fillRect(y + xO, -x + yO, 3, 3);
//        g.fillRect(x + xO, -y + yO, 3, 3);
    }

    public void veDuongTronNetDut(Graphics2D g) {

        g.setColor(Color.RED);  //dat mau hinh ve la red
        int dem = 0;
        g.fillRect(xO, yO, DoanThang.fillValue, DoanThang.fillValue);
//        g.drawString((xO - KTDH_Nhom8.graphWidth / 2) / KTDH_Nhom8.step + "," + (yO - KTDH_Nhom8.graphHeight / 2) / (-KTDH_Nhom8.step), xO + 3, yO + 3);
        int x, y, p;
        p = 1 - r;
        x = 0;
        y = r;
        g.fillRect(x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(-y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
        g.fillRect(x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
        while (x < y) { //ve 1/8 duong tron
            if (p < 0) {
                p += 2 * x + 3;
            } else {
                p += 2 * (x - y) + 5;
//                y--;
                y = y - DoanThang.unitsize;
            }
//            x++;
            x = x + DoanThang.unitsize;
            if (dem < 5) {
                g.fillRect(x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
                dem++;
            } else if (dem < 10) {
                dem++;
            } else {
                dem = 0;
                g.fillRect(x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-y + xO, x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-x + xO, y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(-y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(y + xO, -x + yO, DoanThang.fillValue, DoanThang.fillValue);
                g.fillRect(x + xO, -y + yO, DoanThang.fillValue, DoanThang.fillValue);
            }
        }
//        g.fillRect(x + xO, y + yO, 3, 3);
//        g.fillRect(y + xO, x + yO, 3, 3);
//        g.fillRect(-y + xO, x + yO, 3, 3);
//        g.fillRect(-x + xO, y + yO, 3, 3);
//        g.fillRect(-x + xO, -y + yO, 3, 3);
//        g.fillRect(-y + xO, -x + yO, 3, 3);
//        g.fillRect(y + xO, -x + yO, 3, 3);
//        g.fillRect(x + xO, -y + yO, 3, 3);
    }
}
//public void put8Pixels(int x, int y, int xC, int yC, Graphics2D g2d) {
//        // goc phan tu I
//        g2d.fillRect(x + xC - offset, y + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        g2d.fillRect(y + xC - offset, x + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        // goc phan tu II
//        g2d.fillRect(-x + xC - offset, y + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        g2d.fillRect(-y + xC - offset, x + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        // goc phan tu IV
//        g2d.fillRect(x + xC - offset, -y + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        g2d.fillRect(y + xC - offset, -x + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        // goc phan tu III
//        g2d.fillRect(-x + xC - offset, -y + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//        g2d.fillRect(-y + xC - offset, -x + yC - offset, MainFrame.PIXEL_SIZE, MainFrame.PIXEL_SIZE);
//    }
//    
//    public void draw(int virtualXC, int virtualYC, int virtualR, Graphics2D g2d) {
//        // Convert virtualX, virtualY to realX, realY
//        int xC = MainFrame.getRealX(virtualXC);
//        int yC = MainFrame.getRealY(virtualYC);
//        int r = MainFrame.getRealWH(virtualR);
//                
//        // Midpoint
//        int x = 0, y = r;
//        int f = 1 - r; // f = 5/4 - r vi 5/4 = 1
//
//        put8Pixels(x, y, xC, yC, g2d); // putpixel va tinh tien hinh tron tai (0, 0) sang (xC, yC) 
//
//        while (x < y) {
//            x += MainFrame.UNIT;
//            if (f < 0) f += 2 * x + 3;
//            else {
//                f += 2 * (x - y) + 5;
//                y -= MainFrame.UNIT;
//            }
//            put8Pixels(x, y, xC, yC, g2d);
//        }
//    }
