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
	// HashMap
	public static boolean containsDuplicate1(int[] nums) {
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

    // 排序后再判断, 顺便练习快排
    public static boolean containsDuplicate2(int[] nums) {
    	qSort(nums);
    	for (int i = 0; i < nums.length - 1; i++) {
    		if(nums[i] == nums[i+1]) {
    			return true;
    		}
    	}
    	return false;
    }

    public static void qSort(int[] nums) {
    	quickSort(nums, 0, nums.length - 1);
    } 

    public static void quickSort(int[] nums, int left, int right) {
    	if(left < right) {
    		int i = left, j = right;
    		int pivot = nums[left];
    		while(i < j && nums[j] >= pivot) j--;
    		while(i < j && nums[i] <= pivot) i++;
    		if(i < j) {
    			int temp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;
    		}
    		nums[left] = nums[i];
    		nums[i] = pivot;
    		quickSort(nums, left, i - 1);
    		quickSort(nums, j + 1, right);
    	}
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 3, 3};
    	int[] nums2 = {1, 5, 2, 3, 6};
    	System.out.println(containsDuplicate1(nums1));
    	System.out.println(containsDuplicate1(nums2));
    	System.out.println(containsDuplicate2(nums1));
    	System.out.println(containsDuplicate2(nums2));
    }
}