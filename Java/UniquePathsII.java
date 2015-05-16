/**
 *	Follow up for "Unique Paths":
 *
 *	Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 *	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 *	For example,
 *	There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 *	[
 * 		[0,0,0],
 * 		[0,1,0],
 * 		[0,0,0]
 *	]
 *	The total number of unique paths is 2.
 *
 *	Author: matao
 *
 */

public class UniquePathsII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        int[][] sum = new int[M][N];
        for (int i = 0; i < M; i++) {
            if (obstacleGrid[i][0] != 1) {
                sum[i][0] = 1;
            } else {
                break;
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (obstacleGrid[0][i] != 1) {
                sum[0][i] = 1; 
            } else {
                break;
            }
        }

        for(int i = 1; i < M; i++) {
        	for (int j = 1; j < N; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			sum[i][j] = 0;
        		} else {
        			sum[i][j] = sum[i-1][j] + sum[i][j-1];
        		}
        	}
        }
        return sum[M-1][N-1];
    }

    public static void main(String[] args) {
    	int[][] obstacleGrid = {{0, 0, 0},
    							{0, 1, 0},
    							{0, 0, 0}};
    	System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}