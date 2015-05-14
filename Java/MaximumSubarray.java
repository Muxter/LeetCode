/**
 *	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 *	Author: matao	
 *
 */

public class MaximumSubarray {

	// sliding window 滑动窗口
	public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxSub = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if(max < 0) {
        		max = 0;
        	}
        	max += nums[i];
        	if(max > maxSub) {
        		maxSub = max;
        	}
        }
        return maxSub;
    }

	public static void main(String[] args) {
		int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray(nums1));
	}
}