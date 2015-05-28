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
	public static int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
    }

    // 每找出两个不同的element，就成对删除即count--，最终剩下的一定就是所求的。时间复杂度：O(n)
    // Moore’s Voting Algorithm
    public static int majorityElement2(int[] nums) {
    	int element = 0;
    	int count = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (count == 0) {
    			element = nums[i];
    			count = 1;
    		} else {
    			if(element == nums[i]) {
    				count++;
    			} else {
    				count--;
    			}
    		}
    	}
    	return element;
    }

    public static void main(String[] args) {
    	int[] nums = {1, 1, 1, 1, 2, 2, 2};
    	System.out.println(majorityElement1(nums));
    	System.out.println(majorityElement2(nums));
    }
}