/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

import java.awt.Graphics;

/**
 *
 * @author Phat
 */
public class Circle {

    Point2D O;
    int xO, yO, r;

    public Circle() {

    }

    public Circle(int xO, int yO, int r) {
        this.xO = xO;
        this.yO = yO;
        this.r = r * 5;
    }

    public Circle(Point2D O, int r) {
        this.r = r;
        this.O = O;
        this.xO = O.x;
        this.yO = O.y;
    }

    public int getX() {
        return xO;
    }

    public void setX(int x) {
        this.xO = x;
    }

    public int getY() {
        return yO;
    }

    public void setY(int y) {
        this.yO = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Point2D getO() {
        return O;
    }

    public void setO(Point2D O) {
        this.O = O;
    }

    public void draw8Points(int x, int y, Graphics g) {
        g.fillRect(x + xO, y + yO, 5, 5);
        g.fillRect(y + xO, x + yO, 5, 5);
        g.fillRect(y + xO, -x + yO, 5, 5);
        g.fillRect(x + xO, -y + yO, 5, 5);
        g.fillRect(-x + xO, -y + yO, 5, 5);
        g.fillRect(-y + xO, -x + yO, 5, 5);
        g.fillRect(-y + xO, x + yO, 5, 5);
        g.fillRect(-x + xO, y + yO, 5, 5);
    }

    public void draw(Graphics g) {
        //bresenham
        int x = 0;
        int y = r;
        int p = 3 - 2 * r;

        while (x <= y) {
            draw8Points(x, y, g);
            if (p < 0) {
                p += 4 * x + 6;
            } else {
                p += 4 * (x - y) + 10;
                y -= 5;
            }
            x += 5;
        }
    }

    public void drawMidPoint(Graphics g) {
        //midpoint
        int x = 0;
        int y = r;
        int p = 1 - r;
        while (x <= y) {
            draw8Points(x, y, g);
            if (p < 0) {
                p += 2 * x + 3;
            } else {
                p += 2 * (x - y) + 5;
                y -= 5;
            }
            x += 5;
        }
    }

}
