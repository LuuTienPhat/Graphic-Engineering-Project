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
public class Line {
    int x1, y1, x2, y2;
    Point2D A, B;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
        this.A = new Point2D(x1, y1);
        this.B = new Point2D(x2, y2);
    }

    public Line(Point2D A, Point2D B) {
        this.A = A;
        this.B = B;
        
        this.x1 = A.x;
        this.y1 = A.y;
        this.x2 = B.x;
        this.y2 = B.y;
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    public void drawBresenham(Graphics2D g) {
        
        //bresenham
        int x, y, Dx, Dy, p;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);

        x = x1;
        y = y1;
        int x_unit = 5, y_unit = 5; //bước nhảy cho x, y
        
        g.fillRect(x , y, 5, 5); //Dung toa do may, ve diem pixel dau tien
        
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                g.fillRect(x ,y, 5, 5);
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                  g.fillRect(x, y, 5, 5);
            }
        }
        
        
    }

    public void drawDashedBresenham(Graphics2D g) {
        
        //bresenham
        int x, y, Dx, Dy, p, dem = 0;
        Dx = Math.abs(x2 - x1);
        Dy = Math.abs(y2 - y1);

        x = x1;
        y = y1;
        int x_unit = 5, y_unit = 5; //bước nhảy cho x, y
        
        g.fillRect(x , y, 5, 5); //Dung toa do may, ve diem pixel dau tien
        
        //xét trường hợp để cho y_unit và x_unit để vẽ tăng lên hay giảm xuống
        if (x2 - x1 < 0) {
            x_unit = -x_unit;
        }
        if (y2 - y1 < 0) {
            y_unit = -y_unit;
        }
        if (Dx >= Dy) {
            p = 2 * Dy - Dx;

            while (x != x2) {
                if (p < 0) {
                    p += 2 * Dy;
                } else {
                    p += 2 * (Dy - Dx);
                    y += y_unit;
                }
                x += x_unit;
                if(dem < 3) {
                    g.fillRect(x ,y, 5, 5);
                    dem++;
                }
                else if(dem < 5){
                    dem++;
                }
                else {
                    dem = 0;
                }
                
            }
        } else {
            p = 2 * Dx - Dy;

            while (y != y2) {
                if (p < 0) {
                    p += 2 * Dx;
                } else {
                    p += 2 * (Dx - Dy);
                    x += x_unit;
                }
                y += y_unit;
                if(dem < 3) {
                    g.fillRect(x ,y, 5, 5);
                    dem++;
                }
                else if(dem < 5){
                    dem++;
                }
                else {
                    dem = 0;
                }
            }
        }
        
        
    }
}
