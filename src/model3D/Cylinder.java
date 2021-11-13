/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JTextArea;

/**
 *
 * @author Phat
 */
public class Cylinder extends Shape3D{
    int x, y, z;
    Point3D o1;
    int radius, height;

    public Cylinder(int x, int y, int z, int radius, int height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.radius = radius;
        this.height = height;
        
        this.o1 = new Point3D(x, y, z);
    }
    
    public Cylinder(Point3D bottomPoint, int radius, int height) {
        this.x = bottomPoint.x;
        this.y = bottomPoint.y;
        this.z = bottomPoint.z;
        this.radius = radius;
        this.height = height;
        
        this.o1 = bottomPoint;
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

    public Point3D getBottomPoint() {
        return o1;
    }

    public void setBottomPoint(Point3D bottomPoint) {
        this.o1 = bottomPoint;
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
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
//        g.setColor(new Color(57, 62, 70));
        
        //Toạ đồ người dùng
        Point3D o2 = new Point3D(x, y, z + height); //Tâm đáy trên
        Point3D a2 = new Point3D(x - radius, y, z + height);
        Point3D b2 = new Point3D(x + radius, y, z + height);
        
        Point3D a1 = new Point3D(x - radius, y, z);
        Point3D b1 = new Point3D(x + radius, y, z);
        
        //Biến đổi cabinet {Toạ độ người dùng}
        Point2D O1 = Projection.cabinet(x, y, z);
        Point2D A1 = Projection.cabinet(a1.x, a1.y, a1.z);
        Point2D B1 = Projection.cabinet(b1.x, b1.y, b1.z);
        
        Point2D O2 = Projection.cabinet(o2.x, o2.y, o2.z);
        Point2D A2 = Projection.cabinet(a2.x, a2.y, a2.z);
        Point2D B2 = Projection.cabinet(b2.x, b2.y, b2.z);
        
        
        //Đáy dưới
        Ellipse e1 = new Ellipse(O1.getNewX(), O1.getNewY(), radius, (int) (radius * Math.sqrt(2) / 4));
        //Đáy trên
        Ellipse e2 = new Ellipse(O2.getNewX(), O2.getNewY(), radius, (int) (radius * Math.sqrt(2) / 4)); 
        Line A1A2 = new Line(A1.getNewX(), A1.getNewY(), A2.getNewX(), A2.getNewY());// nét liền
        Line B1B2 = new Line(B1.getNewX(), B1.getNewY(), B2.getNewX(), B2.getNewY());// nét liền
        Line O1O2 = new Line(O1.getNewX(), O1.getNewY(), O2.getNewX(), O2.getNewY());//nét đứt
        Line O1B1 = new Line(O1.getNewX(), O1.getNewY(), B1.getNewX(), B1.getNewY());//nét đứt
        

        e1.drawHalfDashedBresenham(g2d);
        e2.drawBresenham(g2d);
        A1A2.drawBresenham(g2d);
        B1B2.drawBresenham(g2d);
        O1O2.drawDashedBresenham(g2d);
        O1B1.drawDashedBresenham(g2d);
        
        g2d.setColor(new Color(253, 0, 84));
        g.drawString("O", O2.getNewX() - 4 * 5, O2.getNewY() - 2 * 5);
        g.drawString("O'", O1.getNewX() - 4 * 5, O1.getNewY() - 2 * 5);
        g.drawString("h", O1.getNewX() - 4 * 5, O1.getNewY() - (height * 5) / 2);
        g.drawString("r", O1.getNewX() + (radius * 5) / 2, O1.getNewY() - 2 * 5);
        
        view.KTDH_Nhom8.title_3D.setText("THÔNG TIN HÌNH TRỤ");
        view.KTDH_Nhom8.o_3d.setText(o1.toString());
        view.KTDH_Nhom8.o1_3d.setText(o2.toString());
        view.KTDH_Nhom8.r_3d.setText("" + radius);
        view.KTDH_Nhom8.h_3d.setText("" + height);
        
//        String string = "\tTHÔNG TIN HÌNH TRỤ\n\n";
//        
//        string += "\tO" + o2.toString() + "\n";
//        string += "\tO'" + o1.toString() + "\n\n";
//        
//        string += "\tKích thước\n";
//        string += "\tBán kính: " + radius + "\n";
//        string += "\tChiều cao: " + height  + "\n";
        
        
    }
}
