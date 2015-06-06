/**
 *	Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 *  Each element in the array represents your maximum jump length at that position.
 *
 *	Determine if you are able to reach the last index.
 *
 *	For example:
 *	A = [2,3,1,1,4], return true.
 *
 *	A = [3,2,1,0,4], return false.
 *
 *	Author: matao
 *
 */

public class JumpGame {
	// dynamic programming     timeout
	public static boolean canJump1(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}   
		boolean[] can = new boolean[nums.length];
		can[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(can[j] && j + nums[j] >= i) {   // j本身可达，且在j处跳j的最大步幅大于i，则i也可达
					can[i] = true;
					break;
				}
			}
		}
		return can[nums.length - 1];
    }

    // greedy
    public static boolean canJump2(int[] nums) {
    	if(nums == null || nums.length == 0) {
			return false;
		}
		int maxStep = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(i <= maxStep && i + nums[i] >= maxStep) {
				maxStep = i + nums[i];
			}
		}
		return maxStep >= nums.length - 1;
    }

    public static void main(String[] args) {
    	int[] nums1 = {2, 3, 1, 1, 4};
    	int[] nums2 = {3, 2, 1, 0, 4};
    	System.out.println(canJump1(nums1));
    	System.out.println(canJump1(nums2));

    	System.out.println(canJump2(nums1));
    	System.out.println(canJump2(nums2));
    }
}