/**
 *	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *	Integers in each row are sorted from left to right.
 *	The first integer of each row is greater than the last integer of the previous row.
 *	
 *	For example,
 *
 *	Consider the following matrix:
 *		[
 *			[1,   3,  5,  7],
 *			[10, 11, 16, 20],
 *			[23, 30, 34, 50]
 *		]
 *
 *	Author: matao
 */

public class SearchA2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = m*n-1;
		int i, j;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			i = mid / n;
			j = mid % n;
			if(target == matrix[i][j])
				return true;
			else if(target > matrix[i][j])
				start = mid;
			else
				end = mid;
		}
		if (matrix[start/n][start%n] == target) {
			return true;
		}
		if (matrix[end/n][end%n] == target) {
			return true;
		}
		return false;
    }

    public static void main(String[] args) {
    	int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
						};
		System.out.println(searchMatrix(matrix, 0) + "");
		System.out.println(searchMatrix(matrix, 11) + "");
		System.out.println(searchMatrix(matrix, 7) + "");
		System.out.println(searchMatrix(matrix, 16) + "");
		System.out.println(searchMatrix(matrix, 55) + "");
    }
}