/**
 *	Follow up for "Find Minimum in Rotated Sorted Array":
 *	What if duplicates are allowed?
 *
 *	Would this affect the run-time complexity? How and why?
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 *	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *	Find the minimum element.
 *
 *	The array may contain duplicates.
 *
 *	Author: matao
 *
 */

public class FindMinimumInRotatedSortedArrayII {
	public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        //  首位数字相同情况，无法进行折半，故一趟循环
        if(nums[start] == nums[end]) {
        	int result = nums[0];
        	for(int i = 1; i < nums.length; i++) {
        		if(result > nums[i]) {
        			result = nums[i];
        		}
        	}
        	return result;
        }

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]) {
                start = mid;
            } else {
            	end = mid;
            }
        }

        if(nums[start] < nums[end]) {
        	return nums[start];
        } else {
        	return nums[end];
        }
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 2, 2, 2};
		int[] nums2 = {4, 5, 5, 6, 7, 0, 1, 2, 2};
		int[] nums3 = {1, 1, 2, 3};
		System.out.println(findMin(nums1));
		System.out.println(findMin(nums2));
		System.out.println(findMin(nums3));
    }
}