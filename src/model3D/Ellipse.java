/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Phat
 */
public class Ellipse {

    private int xO, yO;
    int a, b;

    public Ellipse() {

    }

    public Ellipse(int xO, int yO, int a, int b) {
        this.xO = xO;
        this.yO = yO;
        this.a = a * 5;
        this.b = b * 5;
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Ellipse{" + "xO=" + xO + ", yO=" + yO + ", a=" + a + ", b=" + b + '}';
    }

    public void drawHalfDashed(Graphics g) {
        //khai bao cac bien cua thuat toan Midpoint
        int dem = 0;
        int dx, dy, p0, q0, x, y;
        x = 0;
        y = b;

        //Khai bao cac bien vung I
        p0 = (int) ((b * b) - (a * a * b) + (0.25 * a * a));
        dx = 2 * b * b * x;
        dy = 2 * a * a * y;

        //Ve vung I
        while (dx < dy) {
            // Ve diem dua tren doi xung
            if (dem < 5) {
                g.fillOval(x + xO, -y + yO, 5, 5);
                g.fillOval(-x + xO, -y + yO, 5, 5);
                dem++;
            } else if (dem < 10) {
                dem++;
            } else {
                dem = 0;
                g.fillOval(x + xO, -y + yO, 5, 5);
                g.fillOval(-x + xO, -y + yO, 5, 5);
            }
            g.fillOval(x + xO, y + yO, 5, 5);
            g.fillOval(-x + xO, y + yO, 5, 5);

            // Kiem tra va cap nhat cac gia tri
            if (p0 < 0) {
                x += 5;
                dx = dx + (2 * b * b);
                p0 = p0 + dx + (b * b);
            } else {
                x += 5;
                y -= 5;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                p0 = p0 + dx - dy + (b * b);
            }
        }
        // Ve vung II
        q0 = (int) (((b * b) * ((x + 0.5) * (x + 0.5))) + ((a * a) * ((y - 1) * (y - 1))) - (a * a * b * b));
        while (y >= 0) {

            // Ve 4 diem
            if (dem < 5) {
                g.fillOval(x + xO, -y + yO, 5, 5);
                g.fillOval(-x + xO, -y + yO, 5, 5);
                dem++;
            } else if (dem < 10) {
                dem += 5;
            } else {
                dem = 0;
                g.fillOval(x + xO, -y + yO, 5, 5);
                g.fillOval(-x + xO, -y + yO, 5, 5);
            }
            g.fillOval(x + xO, y + yO, 5, 5);
            g.fillOval(-x + xO, y + yO, 5, 5);

            // Kiem tra va cap nhat cac gia tri
            if (q0 > 0) {
                y -= 5;
                dy = dy - (2 * a * a);
                q0 = q0 + (a * a) - dy;
            } else {
                y -= 5;
                x += 5;
                dx = dx + (2 * b * b);
                dy = dy - (2 * a * a);
                q0 = q0 + dx - dy + (a * a);
            }
        }
    }

    public void drawHalfDashedBresenham(Graphics2D g) {
        //bresenham
        int x = 0;
        int y = b;
        int dem = 0;

        float x0 = (float) (a * a / Math.sqrt(a * a + b * b));
        float P = a * a * (1 - 2 * b) + b * b;
        draw4Point(g, x, y);

        //Vẽ vùng I
        while (x <= x0) {
            if (P < 0) {
                P += (2 * b * b) * (2 * x + 3);
            } else {
                P += (2 * b * b) * (2 * x + 3) + 4 * a * a * (1 - y);
                y -= 5;
            }
            x += 5;
            if (dem < 3) {
                g.fillRect(x + xO, -y + yO, 5, 5);
                g.fillRect(-x + xO, -y + yO, 5, 5);
                dem++;
            } else if (dem < 5) {
                dem++;
            } else {
                dem = 0;
            }
            g.fillRect(x + xO, y + yO, 5, 5);
            g.fillRect(-x + xO, y + yO, 5, 5);

        }

        //Vẽ vùng II
        x = a;
        y = 0;

        P = b * b * (1 - 2 * a) + a * a;
        draw4Point(g, x, y);
        while (x > x0) {
            if (P < 0) {
                P += (2 * a * a) * (2 * y + 3);
            } else {
                P += (2 * a * a) * (2 * y + 3) + 4 * b * b * (1 - x);

                x -= 5;
            }
            y += 5;
            if (dem < 3) {
                g.fillRect(x + xO, -y + yO, 5, 5);
                g.fillRect(-x + xO, -y + yO, 5, 5);
                dem++;
            } else if (dem < 5) {
                dem++;
            } else {
                dem = 0;
            }
            g.fillRect(x + xO, y + yO, 5, 5);
            g.fillRect(-x + xO, y + yO, 5, 5);
        }
    }

    public void drawBresenham(Graphics2D g) {
        //bresenham
        int x = 0;
        int y = b;
        int dem = 0;

        float x0 = (float) (a * a / Math.sqrt(a * a + b * b));
        float P = a * a * (1 - 2 * b) + b * b;
        draw4Point(g, x, y);

        //Vẽ vùng I
        while (x <= x0) {
            if (P < 0) {
                P += (2 * b * b) * (2 * x + 3);
            } else {
                P += (2 * b * b) * (2 * x + 3) + 4 * a * a * (1 - y);
                y -= 5;
            }
            x += 5;
            draw4Point(g, x, y);
        }

        //Vẽ vùng II
        x = a;
        y = 0;

        P = b * b * (1 - 2 * a) + a * a;
        draw4Point(g, x, y);
        while (x > x0) {
            if (P < 0) {
                P += (2 * a * a) * (2 * y + 3);
            } else {
                P += (2 * a * a) * (2 * y + 3) + 4 * b * b * (1 - x);

                x -= 5;
            }
            y += 5;
            draw4Point(g, x, y);
        }
    }
    
    public void draw4Point(Graphics g, int x, int y) {
        g.fillRect(x + xO, y + yO, 5, 5);
        g.fillRect(x + xO, -y + yO, 5, 5);
        g.fillRect(-x + xO, -y + yO, 5, 5);
        g.fillRect(-x + xO, y + yO, 5, 5);
    }
}
