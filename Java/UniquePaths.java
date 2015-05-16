/**
 *	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 *	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 *	How many possible unique paths are there?
 *
 *	Author: matao
 *
 */



public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++) {
			a[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			a[0][i] = 1;
		}
		for(int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				a[i][j] = a[i][j-1] + a[i-1][j];
			}
		}
		return a[m-1][n-1];
    }

    public static void main(String[] args) {
    	System.out.println(uniquePaths(3, 7));
    	System.out.println(uniquePaths(2, 3));
    	System.out.println(uniquePaths(100, 90));
    }
}