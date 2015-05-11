/**	A peak element is an element that is greater than its neighbors.
 *
 * 	Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 *
 *	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 *	You may imagine that num[-1] = num[n] = -∞.
 *
 *	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 *	Author: matao
 */

public class FindPeakElement {
	public static int findPeak(int[] nums) {
		int start = 0, end = nums.length-1;
		//A包含三个或以上的数
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if (nums[mid] > nums[mid+1])
                end = mid;
            else
                start = mid;
        }
        //A包含两个数
        if((start + 1 == end) && nums[start] < nums[end])
            return end;
        //A只有一个数
        return start;
	}

	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1, 2};
		int[] nums3 = {2, 1};
		int[] nums4 = {1, 2, 1, 3, 4, 5, 7, 6};
		int[] nums5 = {1, 2, 2, 3};
		System.out.println(findPeak(nums1));
		System.out.println(findPeak(nums2));
		System.out.println(findPeak(nums3));
		System.out.println(findPeak(nums4));
		System.out.println(findPeak(nums5));
	}
}