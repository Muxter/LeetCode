/**
 *	You are a professional robber planning to rob houses along a street. 
 *	Each house has a certain amount of money stashed, the only constraint stopping you 
 *	from robbing each of them is that adjacent houses have security system connected 
 *	and it will automatically contact the police if two adjacent houses were 
 *	broken into on the same night.
 *
 *	Given a list of non-negative integers representing the amount of money of each house, 
 *	determine the maximum amount of money you can rob tonight without alerting the police.
 *
 *	Author: matao
 *
 */

public class HouseRobber {
	// f[i] = max{f[i-2] + nums[i], f[i-1]}
	public static int rob(int[] nums) {
		int n = nums.length;
		int[] f = new int[n];
		if (n == 1) {
			f[0] = nums[0];
		}
		if(n >= 2) {
			f[1] = f[0] > nums[1] ? f[0] : nums[1];
		}
		for (int i = 2; i < nums.length; i++) {
			f[i] = f[i - 1] > f[i - 2] + nums[i] ? f[i - 1] : f[i - 2] + nums[i];
		}
		return f[n - 1];
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 1, 2, 3, 5};
    	int[] nums2 = {2, 1, 0, 2, 4};
    	System.out.println(rob(nums1));
    	System.out.println(rob(nums2));
    }
}