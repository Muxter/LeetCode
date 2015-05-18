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
	public static boolean search(int[] nums, int target) {
        // for(int i = 0; i < nums.length; i++) {
        //     if(target == nums[i])
        //         return true;
        // }
        // return false;
        if(nums.length == 0) {
            return false;
        }
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            System.out.println("start: " + start);
            System.out.println("mid: " + mid);
            System.out.println("end: " + end);
            if(nums[mid] == target) {
                return true;
            }
            if(nums[start] < nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if(nums[start] > nums[mid]) {
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }

        if(nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
    	int[] nums1 = {2, 2, 2, 3, 1};
        System.out.println(search(nums1, 1));
    }
}