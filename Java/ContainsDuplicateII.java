/**
 *	Given an array of integers and an integer k, 
 *	find out whether there there are two distinct indices i and j in the array 
 *	such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 *	Author: matao
 *
 */

import java.util.HashMap;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
        	return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
        		return true;
        	}
        	map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 3, 4, 3};
    	System.out.println(containsNearbyDuplicate(nums1, 2));
    	System.out.println(containsNearbyDuplicate(nums1, 1));
    }
}