/**
 *	Given an array of size n, find the majority element. 
 *	The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 *	You may assume that the array is non-empty and the majority element always exist in the array.
 *	
 *	Challenge: O(n) time and O(1) extra space
 *
 *	Author: matao
 *
 */

import java.util.Arrays;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }

    public static void main(String[] args) {
    	int[] nums = {1, 1, 1, 1, 2, 2, 2};
    	System.out.println(majorityElement(nums));
    }
}