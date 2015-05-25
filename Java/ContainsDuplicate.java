/** 
 *	Given an array of integers, find if the array contains any duplicates. 
 *	Your function should return true if any value appears at least twice in the array, 
 *	and it should return false if every element is distinct.
 *
 *	Author: matao
 *
 */

import java.util.Map;
import java.util.HashMap;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				return true;
			}	
			map.put(nums[i], nums[i]);
		}
		return false;
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 3, 3};
    	int[] nums2 = {1, 3, 5, 6};
    	System.out.println(containsDuplicate(nums1));
    	System.out.println(containsDuplicate(nums2));
    }
}