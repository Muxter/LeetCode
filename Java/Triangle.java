/**
 *	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 *	For example, given the following triangle
 *	[
 *      [2],
 *     [3,4],
 *	  [6,5,7],
 *	 [4,1,8,3]
 *	]
 *	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *	Author: matao
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	// Dynamic Programming from up to bottom
	public static int minimumTotal1(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		int[][] sum = new int[n][n];

		sum[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					sum[i][j] = sum[i-1][j] + triangle.get(i).get(j);
				} else {
					sum[i][j] = Math.min(sum[i-1][j-1], sum[i-1][j]) + triangle.get(i).get(j);
				}
			}
		}
		return minItemOfLineN(sum);
    }

    private static int minItemOfLineN(int[][] sum) {
    	int n = sum.length;
    	int min = sum[n-1][0];
    	for(int i = 1; i < sum[n-1].length; i++) {
    		if(min < sum[n-1][i]) {
    			min = sum[n-1][i];
    		}
    	}
    	return min;
    }

    // Dynamic Prigramming from bottom to up
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
        	return 0;
        }
        int n = triangle.size();
        int[][] sum = new int[n][n];

        for(int i = 0; i < n; i++) {
        	sum[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i = n - 2; i >=0; i--) {
        	for(int j = 0; j <= i; j++) {
        		sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle.get(i).get(j);
        	}
        }
        return sum[0][0];
    }

    public static void main(String[] args) {
    	List<Integer> l1 = new ArrayList<>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		List<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		l3.add(7);
		List<Integer> l4 = new ArrayList<>();
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		List<List<Integer>> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);

		System.out.println(minimumTotal1(list));
		System.out.println(minimumTotal2(list));
    }
}