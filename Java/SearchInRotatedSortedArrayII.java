/**
 *	Follow up for "Search in Rotated Sorted Array":
 *	What if duplicates are allowed?
 *
 *	Would this affect the run-time complexity? How and why?
 *
 *	Write a function to determine if a given target is in the array.
 *
 *	Author: matao
 */

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	
    }
}