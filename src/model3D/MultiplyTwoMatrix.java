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
public class MultiplyTwoMatrix {
    public static double[] multiply(double[] matrix1, double[][] matrix2) {
        double[] result = new double[3]; 
        
        for(int i = 0; i < matrix1.length; i++) {
            double sum = 0;
            for(int j = 0; j < matrix2[i].length; j++) {
                sum += (matrix1[j] * matrix2[j][i]);
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}
