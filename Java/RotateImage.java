/**
 *	You are given an n x n 2D matrix representing an image.
 *
 *	Rotate the image by 90 degrees (clockwise).
 *
 *	Follow up:
 *	Could you do this in-place?
 *
 *	Author: matao
 *
 */

public class RotateImage {

	// 先对矩阵进行转置, 再交换列
	public static void rotate(int[][] matrix) {
		// 转置
		int n = matrix.length;
        for (int i = 0; i < n; i++) {
        	for (int j = i; j < n; j++) {
        		swap(matrix, i, j);
        	}
        }

        int i = 0, j = n - 1;
        while(i < j) {
        	for(int k = 0; k < n; k++) {
        		int temp = matrix[k][i];
        		matrix[k][i] = matrix[k][j];
        		matrix[k][j] = temp;
        	}
        	i++;
        	j--;
        }
    }

    public static void swap(int[][] matrix, int i, int j) {
    	int temp = matrix[i][j];
    	matrix[i][j] = matrix[j][i];
    	matrix[j][i] = temp;
    }

    public static void main(String[] args) {
    	int[][] matrix1 = {
    						{1, 2},
    						{3, 4}
    					};
    	rotate(matrix1);
    	for (int i = 0; i < matrix1.length; i++) {
        	for (int j = 0; j < matrix1[0].length; j++) {
        		System.out.print(matrix1[i][j] + " ");
        	}
        	System.out.println();
        }
        System.out.println();
        System.out.println();

        int[][] matrix2 = {
    						{1, 2, 3},
    						{4, 5, 6},
    						{7, 8, 9}
    					};
    	rotate(matrix2);
    	for (int i = 0; i < matrix2.length; i++) {
        	for (int j = 0; j < matrix2[0].length; j++) {
        		System.out.print(matrix2[i][j] + " ");
        	}
        	System.out.println();
        }
    }
}	