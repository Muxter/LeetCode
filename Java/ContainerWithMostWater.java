/**
 *	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 *	n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 *	Find two lines, which together with x-axis forms a container, 
 *	such that the container contains the most water.
 *
 *	Note: You may not slant the container
 *
 *	Given [1,3,2], the max area of the container is 2.
 *
 *	Author: matao
 *
 */

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        if(height == null || height.length == 0) {
        	return 0;
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left < right) {
        	int h = height[left] < height[right] ? height[left] : height[right];
        	int w = right - left;
        	int square = h * w;
        	if(max < square) {
        		max = square;
        	}
        	if(height[left] < height[right]) {
        		left++;
        	} else {
        		right--;
        	}
        }
        return max;
    }

    public static void main(String[] args) {
    	int[] height1 = {1, 3, 2};
    	System.out.println(maxArea(height1));
    }
}