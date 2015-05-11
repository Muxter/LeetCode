/**
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 *	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 *	Find the minimum element.
 *
 *	You may assume no duplicate exists in the array.
 *	
 *	Author: matao
 */

public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] nums) {
		int start = 0, end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] >= nums[end])
                start = mid;
            else
                end = mid;
		}
		if(nums[start] < nums[end])
            return nums[start];
        else
            return nums[end];
	}

	public static void main(String[] args) {
		int[] nums1 = {2, 3, 1};
		int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
		int[] nums3 = {1, 2, 3};
		System.out.println(findMin(nums1));
		System.out.println(findMin(nums2));
		System.out.println(findMin(nums3));
	}
}