/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformation;

import model.Diem2D;

/**
 *
 * @author tuanbuiquoc
 */
public class ThuPhong {
    private double scale;
    private Diem2D diem2D;
    private int r;
    public ThuPhong(int r, double scale){
        this.scale= scale;
        this.r = r;
    }
    public ThuPhong(Diem2D diem2D, double scale){
        this.diem2D = diem2D;
        this.scale= scale;
    }
    public Diem2D ThuPhongDiem(){
        return new Diem2D((int) (this.diem2D.getX()*this.scale),(int) (this.diem2D.getY()*this.scale));
    } 
    public int ThuPhongSize(){
        return  (int) (this.r*this.scale);
    }
}
