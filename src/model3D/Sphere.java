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
public class Sphere extends Shape3D {

    int xO, yO, zO, r;
    Point3D O;

    public Sphere(Point3D O, int r) {
        this.O = O;
        this.r = r;

        this.xO = O.x;
        this.yO = O.y;
        this.zO = O.z;
    }

    public Sphere(int xO, int yO, int zO, int r) {
        this.xO = xO;
        this.yO = yO;
        this.zO = zO;
        this.r = r;

        this.O = new Point3D(xO, yO, zO);
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

    public int getzO() {
        return zO;
    }

    public void setzO(int zO) {
        this.zO = zO;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Point3D getO() {
        return O;
    }

    public void setO(Point3D O) {
        this.O = O;
    }

    @Override
    public String toString() {
        return "Sphere{" + "xO=" + xO + ", yO=" + yO + ", zO=" + zO + ", r=" + r + '}';
    }

    @Override
    public void draw(Graphics g) {
        
        Graphics2D g2d = (Graphics2D)g;
        Point3D A = new Point3D(O.x + r, O.y, O.z);

        Point2D o = Projection.cabinet(O.x, O.y, O.z);
        Point2D a = Projection.cabinet(A.x, A.y, A.z);

        Ellipse ellipse = new Ellipse(o.getNewX(), o.getNewY(), r, (int) (r * Math.sqrt(2) / 4));
        ellipse.drawHalfDashedBresenham(g2d);
        Circle c = new Circle(o.getNewX(), o.getNewY(), r);
        c.draw(g2d);
        Line dashedLine = new Line(o.getNewX(), o.getNewY(), a.getNewX(), a.getNewY());
        dashedLine.drawDashedBresenham(g2d);
        

        //Vẽ các điểm trên hình cầu
        g2d.setColor(new Color(253, 0, 84));
        g2d.drawString("O", o.getNewX() - 3 * 5, o.getNewY() - 2 * 5);
        g2d.drawString("r", new Point2D(o.x + r / 2, o.y).getNewX() - 3 * 5, o.getNewY() - 2 * 5);
        
        view.KTDH_Nhom8.title_3D.setText("THÔNG TIN HÌNH CẦU");
        view.KTDH_Nhom8.o_3d.setText(O.toString());
        view.KTDH_Nhom8.r_3d.setText("" + r);

//        String string = "\tTHÔNG TIN HÌNH CẦU\n\n";
//        string += "\tO" + O.toString() + "\n\n";
//
//        string += "\tKích thước\n";
//        string += "\tBán kính: " + r;
//
//        detail.setText(string);
    }
}
