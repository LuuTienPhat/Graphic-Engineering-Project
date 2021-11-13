/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model3D;

/**
 *
 * @author Phat
 */
public class Rotation {
    public static Point2D rotateAroundO(int x, int y, double rotation) {
        
        double[] mt1 = new double[] {x, y, 1};
        double[][] mt2 = new double[][]{{ Math.cos(rotation), Math.sin(rotation), 0}, { - Math.sin(rotation), Math.cos(rotation), 0}, {0, 0, 1}};
        double[] result;
        
        result = MultiplyTwoMatrix.multiply(mt1, mt2);
        System.out.println((int) result[0]+ "," + (int) result[1]);
        System.out.println(new Point2D ((int) result[0], (int) result[1]).toString());
        
        return new Point2D ((int) result[0], (int) result[1]);
    }
    
    public void rotateAroundA() {
        
    }
}
