/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Phat
 */
public class Cone extends Shape3D{
    int x, y, z;
    Point3D o1;
    int radius, height;

    public Cone(int x, int y, int z, int radius, int height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.height = height;
        
        this.o1 = new Point3D(x, y, z);
    }

    public Cone(Point3D o1, int radius, int height) {
        this.o1 = o1;
        this.x = o1.x;
        this.y = o1.y;
        this.z = o1.z;
        this.radius = radius;
        this.height = height;
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Point3D getO1() {
        return o1;
    }

    public void setO1(Point3D o1) {
        this.o1 = o1;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public void draw(Graphics g) {
//        g.setColor(new Color(57, 62, 70));
        Graphics2D g2d = (Graphics2D)g;
        Point3D s = new Point3D(x, y, z + height); //Đỉnh hình chóp
        
        Point3D a1 = new Point3D(x - radius, y, z);
        Point3D b1 = new Point3D(x + radius, y, z);
        
        //Biến đổi cabinet
        Point2D O1 = Projection.cabinet(o1.x, o1.y, o1.z);
        Point2D A1 = Projection.cabinet(a1.x, a1.y, a1.z);
        Point2D B1 = Projection.cabinet(b1.x, b1.y, b1.z);
        
        Point2D S = Projection.cabinet(s.x, s.y, s.z);
        
        //
        Ellipse e2 = new Ellipse(O1.getNewX(), O1.getNewY() , radius, (int) (radius * Math.sqrt(2) / 4)); 
        Line SA1 = new Line(S.getNewX(),S.getNewY(), A1.getNewX(), A1.getNewY());
        Line SB1 = new Line(S.getNewX(), S.getNewY(), B1.getNewX(), B1.getNewY());
        Line SO1 = new Line(S.getNewX(), S.getNewY(), O1.getNewX(), O1.getNewY());
        Line O1B1 = new Line(O1.getNewX(), O1.getNewY(), B1.getNewX(), B1.getNewY());
        
        e2.drawHalfDashedBresenham(g2d);
        SA1.drawBresenham(g2d);
        SB1.drawBresenham(g2d);
        SO1.drawDashedBresenham(g2d);
        O1B1.drawDashedBresenham(g2d);
        
        g2d.setColor(new Color(253, 0, 84));
        g2d.drawString("S", S.getNewX() - 4 * 5, S.getNewY() - 2 * 5);
        g2d.drawString("O", O1.getNewX() - 4 * 5, O1.getNewY() - 2 * 5);
        g2d.drawString("h", O1.getNewX() - 4 * 5, O1.getNewY() - (height * 5) / 2);
        g2d.drawString("r", O1.getNewX() + (radius * 5) / 2, O1.getNewY() - 2 * 5);
        
        view.KTDH_Nhom8.title_3D.setText("THÔNG TIN HÌNH NÓN");
        view.KTDH_Nhom8.r_3d.setText("" + radius);
        view.KTDH_Nhom8.h_3d.setText("" + height);
        
        view.KTDH_Nhom8.o_3d.setText(""+o1.toString());
//        String string = "THÔNG TIN HÌNH NÓN\n\n";
//        string += "\tS" + s.toString() + "\t\t\tO" + o1.toString() + "\n\n";
//        
//        string += "\tKích thước\n";
//        string += "\tBán kính: " + radius + "\n";
//        string += "\tChiều cao: " + height  + "\n";
//        
//        detail.setText(string);
        
    }
}
