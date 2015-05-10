/**
 *	Given a sorted array of integers, find the starting and ending position of a given target value.
 *	Your algorithm's runtime complexity must be in the order of O(log n).
 *	If the target is not found in the array, return [-1, -1].
 *
 *	For example,
 *	Given [5, 7, 7, 8, 8, 10] and target value 8,
 *	return [3, 4].
 *
 *	Author: matao
 */
public class SearchForARange {
	public static int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int[] bound = new int[2];
        //find 1st pos equals target
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                end = mid;
            else if(nums[mid] > target)
                end = mid;
            else
                start = mid;
        }
        if(nums[start] == target)
            bound[0] = start;
        else if(nums[end] == target)
            bound[0] = end;
        else
            bound[0] = -1;
        
        //find last pos equals target
        start = 0;
        end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target)
                start = mid;
            else if(nums[mid] > target)
                end = mid;
            else
                start = mid;
        }
        if(nums[end] == target)
            bound[1] = end;
        else if(nums[start] == target)
            bound[1] = start;
        else
            bound[1] = -1;
        
        return bound;
    }

    public static void main(String[] args) {
    	int[] nums = {5, 7, 7, 8, 8, 10};
    	int[] bound = searchRange(nums, 8);
    	for(int i = 0; i < bound.length; i++)
    		System.out.print(bound[i] + " ");
    }
}