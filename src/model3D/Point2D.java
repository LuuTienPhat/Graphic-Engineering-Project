/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

import java.awt.Graphics;
import java.awt.Graphics2D;
import static model.DoanThang.unitsize;

/**
 *
 * @author Phat
 */
public class Point2D {

    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNewX() {
        int x1 = view.KTDH_Nhom8.graphWidth / 2 + x * view.KTDH_Nhom8.step;
        return x1;
    }

    public int getNewY() {
        int y1 = view.KTDH_Nhom8.graphHeight / 2 - y * view.KTDH_Nhom8.step;
        return y1;
    }

    @Override
    public String toString() {
        return "Point2D{" + "x=" + this.x + ", y=" + this.y + '}';
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int a = this.getNewY() % unitsize;
        int y1 = this.getNewY() - a - 1;
        
        a = this.getNewX() % unitsize;
        int x1 = this.getNewX() - a - 1;
        g2d.fillOval(x1, y1, 5, 5);
    }

    public static void main(String[] args) {
    }
}
