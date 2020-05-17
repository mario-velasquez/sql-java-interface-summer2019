package guiPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class func {
	
	public static int rNum(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static int rNum(String min, String max) {
		
		int Smax = Integer.parseInt(max);
		int Smin = Integer.parseInt(min);
		Random r = new Random();
		return r.nextInt((Smax - Smin) + 1) + Smin;
	}
	


	static int determinantOfMatrix(int mat[][], int size) { 
	    int determinant = 0;
	    if (size == 1) return mat[0][0];// Base case
	    
		int storeCofactors[][] = new int[size][size];  
	    int sign = 1;  
	 
	    for (int firstRow = 0; firstRow < size; firstRow++) { 
	        getCofactor(mat, storeCofactors, 0, firstRow, size); 
	        determinant += sign * mat[0][firstRow] * determinantOfMatrix(storeCofactors, size - 1); 
	        sign = -sign; //Switch sign every other time
	    } 
	    return determinant; 
	} 
	public static void getCofactor(int mat[][], int temp[][], int r, int c, int size) {
        int i = 0, j = 0; 
      
        for (int row = 0; row < size; row++) { 
            for (int col = 0; col < size; col++) {  
                if (row != r && col != c){ //Avoiding Col/Row in r,c
                    temp[i][j++] = mat[row][col]; 
                    if (j == size - 1) { 
                        j = 0; 
                        i++; 
                    } 
                } 
            } 
        } 
	}
	  
	/* function for displaying the matrix */
	static void display(int mat[][], int size) 
	{ 
	    for (int i = 0; i < size; i++) 
	    { 
	        for (int j = 0; j < size; j++) 
	            System.out.print(mat[i][j] + " "); 
	              
	        System.out.print("\n"); 
	    } 
	}
	
	//Fill wiht a random range
	static void fillWithRandom(int mat[][], int size, int low, int high) {
		
		int row = size;int col = size;
		
		for (int i = 0; i < row; i++)
	        for (int j = 0; j < col; j++) 
	            mat[i][j] = func.rNum(low,high); 
	}
	
	static void fillWithRandom(int mat[][], int size, String low, String high) {
		int row = size;int col = size;
		for (int i = 0; i < row; i++)
	        for (int j = 0; j < col; j++) 
	            mat[i][j] = func.rNum(low,high); 
	}
	
	//Coppying a matrix
	static void copyMatrix(int victim[][], int newmatrix[][], int size) {
		int row = size; int col = size;
		for (int i = 0; i < row; i++)
	        for (int j = 0; j < col; j++) 
	            victim[i][j] = newmatrix[i][j];
		
		
	}
	
		
	
	
	
	

}
