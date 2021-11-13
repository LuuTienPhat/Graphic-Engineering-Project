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
public class Cuboid extends Shape3D {
    private Point3D startPoint;
    private int x, y, z;
    private int length, width, height;
    
    public Cuboid(Point3D startPoint, int length, int width, int height) {
        this.startPoint = startPoint;
        this.length = length;
        this.width = width;
        this.height = height;
        
        this.x = startPoint.x;
        this.y = startPoint.y;
        this.z = startPoint.z;
    }

    public Cuboid(int x, int y, int z, int length, int width, int height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = length;
        this.width = width;
        this.height = height;
        
        this.startPoint = new Point3D(x, y, z);
    }
    
    public Point3D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point3D startPoint) {
        this.startPoint = startPoint;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        //Các điểm đáy dưới {Toạ độ người dùng}
        Point3D a1 = new Point3D(startPoint.x, startPoint.y, startPoint.z);
        Point3D b1 = new Point3D(startPoint.x + length, startPoint.y, startPoint.z);
        Point3D c1 = new Point3D(startPoint.x + length, startPoint.y + width, startPoint.z);
        Point3D d1 = new Point3D(startPoint.x, startPoint.y + width,startPoint.z);
        

        //Các điểm đáy trên {Toạ độ người dùng}
        Point3D a = new Point3D(startPoint.x, startPoint.y, startPoint.z + height);
        Point3D b = new Point3D(startPoint.x + length, startPoint.y, startPoint.z + height);
        Point3D c = new Point3D(startPoint.x + length, startPoint.y + width, startPoint.z + height);
        Point3D d = new Point3D(startPoint.x, startPoint.y + width, startPoint.z + height);
        
        //Biến đổi Cavalier {Toạ độ máy}
        Point2D A1 = Projection.cavalier(a1.getX(), a1.getY(), a1.getZ());
        Point2D B1 = Projection.cavalier(b1.getX(), b1.getY(), b1.getZ());
        Point2D C1 = Projection.cavalier(c1.getX(), c1.getY(), c1.getZ());
        Point2D D1 = Projection.cavalier(d1.getX(), d1.getY(), d1.getZ());

        Point2D A = Projection.cavalier(a.getX(), a.getY(), a.getZ());
        Point2D B = Projection.cavalier(b.getX(), b.getY(), b.getZ());
        Point2D C = Projection.cavalier(c.getX(), c.getY(), c.getZ());
        Point2D D = Projection.cavalier(d.getX(), d.getY(), d.getZ());
        
        System.out.println(A1.toString());
        
        //Vẽ đáy dưới
        Line A1B1 = new Line(A1.getNewX(), A1.getNewY(), B1.getNewX(), B1.getNewY());
        A1B1.drawDashedBresenham(g2d);
        Line B1C1 = new Line(B1.getNewX(), B1.getNewY(), C1.getNewX(), C1.getNewY());
        B1C1.drawBresenham(g2d);
        Line D1C1 = new Line(D1.getNewX(), D1.getNewY(), C1.getNewX(), C1.getNewY());
        D1C1.drawBresenham(g2d);
        Line D1A1 = new Line(D1.getNewX(), D1.getNewY(), A1.getNewX(), A1.getNewY());
        D1A1.drawDashedBresenham(g2d);

        //Vẽ đáy trên
        Line A2B2 = new Line(A.getNewX(), A.getNewY(), B.getNewX(), B.getNewY());
        A2B2.drawBresenham(g2d);
        Line B2C2 = new Line(B.getNewX(), B.getNewY(), C.getNewX(), C.getNewY());
        B2C2.drawBresenham(g2d);
        Line D2C2 = new Line(D.getNewX(), D.getNewY(), C.getNewX(), C.getNewY());
        D2C2.drawBresenham(g2d);
        Line D2A2 = new Line(D.getNewX(), D.getNewY(), A.getNewX(), A.getNewY());
        D2A2.drawBresenham(g2d);

        //Vẽ các cạnh bên
        Line A1A2 = new Line(A1.getNewX(), A1.getNewY(), A.getNewX(), A.getNewY());
        A1A2.drawDashedBresenham(g2d);
        Line B1B2 = new Line(B1.getNewX(), B1.getNewY(), B.getNewX(), B.getNewY());
        B1B2.drawBresenham(g2d);
        Line C1C2 = new Line(C1.getNewX(), C1.getNewY(), C.getNewX(), C.getNewY());
        C1C2.drawBresenham(g2d);
        Line D1D2 = new Line(D1.getNewX(), D1.getNewY(), D.getNewX(), D.getNewY());
        D1D2.drawBresenham(g2d);
        
        g2d.setColor(new Color(253, 0, 84));
        //Vẽ các điểm trên hình hộp chữ nhật
        g.drawString("A", A.getNewX() - 3 * 5, A.getNewY() - 1 * 5);
        g.drawString("B", B.getNewX() + 3 * 5, B.getNewY() - 1 * 5);
        g.drawString("C", C.getNewX() - 3 * 5, C.getNewY() - 1 * 5);
        g.drawString("D", D.getNewX() - 3 * 5, D.getNewY() - 1 * 5);
        
        g.drawString("A'", A1.getNewX() - 4 * 5, A1.getNewY() - 1 * 5);
        g.drawString("B'", B1.getNewX() + 4 * 5, B1.getNewY() - 1 * 5);
        g.drawString("C'", C1.getNewX() - 4 * 5, C1.getNewY() - 1 * 5);
        g.drawString("D'", D1.getNewX() - 4 * 5, D1.getNewY() - 1 * 5);
        
        view.KTDH_Nhom8.title_3D.setText( "THÔNG TIN HÌNH HỘP");
        view.KTDH_Nhom8.a_3d.setText(a.toString());
        view.KTDH_Nhom8.b_3d.setText(b.toString());
        view.KTDH_Nhom8.c_3d.setText(c.toString());
        view.KTDH_Nhom8.d_3d.setText(d.toString());
        
        view.KTDH_Nhom8.a1_3d.setText(a1.toString());
        view.KTDH_Nhom8.b1_3d.setText(b1.toString());
        view.KTDH_Nhom8.c1_3d.setText(c1.toString());
        view.KTDH_Nhom8.d1_3d.setText(d1.toString());
        
        view.KTDH_Nhom8.h_3d.setText(""+ height);
        view.KTDH_Nhom8.l_3d.setText("" + length);
        view.KTDH_Nhom8.w_3d.setText("" + width);
        
//        String string = "";
//        string += "\tĐáy trên\n";
//        string += "\t\tA" + a.toString() + "\n";
//        string += "\t\tB" + b.toString() + "\n";
//        string += "\t\tC" + c.toString() + "\n";
//        string += "\t\tD" + d.toString() + "\n\n";
//        
//        string += "\tĐáy dưới\n";
//        string += "\t\tA'" + a1.toString() + "\n";
//        string += "\t\tB'" + b1.toString() + "\n";
//        string += "\t\tC'" + c1.toString() + "\n";
//        string += "\t\tD'" + d1.toString() + "\n\n";
//        
//        string += "\tKích thước \n";
//        string += "\t\tChiều dài: " + length + "\n";
//        string += "\t\tChiều rộng: " + width  + "\n";
//        string += "\t\tChiều cao: " + height + "\n";
        
        
    }
    
//    public static void main(String[] args) {
//        Cuboid c = new Cuboid(0, 0, 0, 20, 30, 10);
//        JTextArea detail = new JTextArea();
//        c.draw(KTDH_Nhom8.g, detail);
//    }
}
