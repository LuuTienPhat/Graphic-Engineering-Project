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
public class TinhTien {
    private int dx, dy;
    private Diem2D diem2D;
    public TinhTien(Diem2D diem2D,int dx,int dy){
        this.diem2D = diem2D;
        this.dx= dx;
        this.dy = dy;
    }


    public Diem2D tinhTienDiem(){
        return new Diem2D(this.diem2D.getX()+this.dx, this.diem2D.getY()-this.dy);
    }
}
