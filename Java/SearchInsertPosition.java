/**
 *  Given a sorted array and a target value, return the index if the target is found. 
 *  If not, return the index where it would be if it were inserted in order.
 *
 *  You may assume no duplicates in the array.
 *  Here are few examples. 
 *  [1,3,5,6], 5 → 2
 *  [1,3,5,6], 2 → 1
 *  [1,3,5,6], 7 → 4
 *  [1,3,5,6], 0 → 0
 *
 *  Author: matao
 */

public class SearchInsertPosition {
	// find the 1st position >= target
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid;
            else
                start = mid;
        }
        
        if(nums[start] >= target)
            return start;
        if(nums[end] >= target)
            return end;
        return end + 1;
        
    }

    public static void main(String[] args) {
    	int[] nums = {1,3,5,6};
    	System.out.println(searchInsert(nums, 5));
    	System.out.println(searchInsert(nums, 2));
    	System.out.println(searchInsert(nums, 7));
    	System.out.println(searchInsert(nums, 0));
    	System.out.println(searchInsert(new int[]{1}, 1));
    }
}