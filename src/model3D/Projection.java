/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

/**
 *
 * @author LuuTienPhat
 */
public class Projection {

    int x, y, z;
    Point3D a;

    public Projection(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Projection(Point3D a) {
        this.x = a.x;
        this.y = a.y;
        this.z = a.z;

        this.a = a;
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

    public Point3D getA() {
        return a;
    }

    public void setA(Point3D a) {
        this.a = a;
    }

    public static Point2D cavalier(int x, int y, int z) {
        int x1 = (int) (x - (y * Math.sqrt(2) / 2));
        int y1 = (int) (z - (y * Math.sqrt(2) / 2));
        return new Point2D(x1, y1);
        
    }

    public static Point2D cabinet(int x, int y, int z) {
        int x1 = (int) (x - (y * (Math.sqrt(2)) / 4));
        int y1 = (int )(z - (y * (Math.sqrt(2)) / 4));
        return new Point2D(x1, y1);
    }
}
