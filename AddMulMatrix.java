import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class AddMulMatrix
{
public static int[][] matrix_add(int[][] ar1, int[][] ar2) {
    // add matrices
    int[][] ar3 = new  int[ar1.length][ar1[0].length];
    for(int i=0;i<ar1.length;i++){
        for(int j=0;j<ar1[0].length;j++){
            ar3[i][j] = ar1[i][j] + ar2[i][j];
        }
    }

    return ar3;
}


public static int[][] matrix_multi(int[][] ar1, int[][] ar2) {
    // multiply matrices
    int i, j, k;
    int row1 = ar1.length;
    int col1 = ar1[0].length;
    int row2 = ar2.length;
    int col2 = ar2[0].length;
    int[][] ar4 = new int[row1][col2];
    for (i = 0; i < row1; i++) {
        for (j = 0; j < col2; j++) {
            for (k = 0; k < col1; k++) {
                ar4[i][j] += ar1[i][k] * ar2[k][j];
            }
        }
    }

    return ar4;
}

public static void print2DArray(int[][] ar)
{
    for(int i=0;i<ar.length;i++){
        for(int j=0;j<ar[0].length;j++){
            System.out.print(ar[i][j] + " ");
        }
        System.out.println();
    }
}

public static int[][] read2DArray(int rows,int cols) throws IOException
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int a[][]=new int[rows][cols];
    for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
            a[i][j] = Integer.parseInt(br.readLine());
	return a;
}

public static void main(String[] args) throws IOException{
	char answer;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Do you want to use the same matrices for both addition and multiplication? (Y/N)");
	answer=br.readLine().charAt(0);
	if (answer=='Y' || answer=='y')
	{
		System.out.print("Enter number of rows for matrix: ");
		int rows =Integer.parseInt(br.readLine());
		System.out.println("Enter the first matrix elements");
		int a[][]= read2DArray(rows,rows);
		System.out.println("Enter the second matrix elements");
		int b[][]= read2DArray(rows,rows);
      	System.out.println("First Matrix is:");
		print2DArray(a);
		System.out.println("Second Matrix is:");
		print2DArray(b);
		System.out.println("Addition of 2 Matrices:\n");
		int[][] arAdd = matrix_add(a,b);
		print2DArray(arAdd);
		System.out.println("Multiplication of 2 Matrices:\n");
		int[][] arMulti = matrix_multi(a,b);
		print2DArray(arMulti);
	}
	else 
		{
		System.out.print("Enter number of rows for addition: ");
		int rows =Integer.parseInt(br.readLine());
		System.out.print("Enter number of columns for addition: ");
		int cols =Integer.parseInt(br.readLine());
		System.out.println("Enter the first matrix elements");
		int a[][]= read2DArray(rows,cols);
		System.out.println("Enter the second matrix elements");
		int b[][]= read2DArray(rows,cols);
      	System.out.println("First Matrix is:");
		print2DArray(a);
		System.out.println("Second Matrix is:");
		print2DArray(b);
		System.out.println("Addition of 2 Matrices:\n");
		int[][] arAdd = matrix_add(a,b);
		print2DArray(arAdd);
		//MULTIPLICATION
		System.out.print("Enter number of rows for 1st Matrix for Multiplication: ");
		int rows1 =Integer.parseInt(br.readLine());
		System.out.print("Enter number of columns for 1st Matrix or number of rows for 2nd Matrix for Multiplication: ");
		int cols1rows2 =Integer.parseInt(br.readLine());
		System.out.print("Enter number of columns for 2nd Matrix for Multiplication: ");
		int cols2 =Integer.parseInt(br.readLine());
		System.out.println("Enter the first matrix elements");
		a= read2DArray(rows1,cols1rows2);
		System.out.println("Enter the second matrix elements");
		b= read2DArray(cols1rows2,cols2);
      	System.out.println("First Matrix is:");
		print2DArray(a);
		System.out.println("Second Matrix is:");
		print2DArray(b);
		System.out.println("Multiplication of 2 Matrices:\n");
		int[][] arMulti = matrix_multi(a,b);
		print2DArray(arMulti);
		}
	}
}