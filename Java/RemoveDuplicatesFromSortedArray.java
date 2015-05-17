/**
 *	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *
 *	Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 *	For example,
 *	Given input array nums = [1,1,2],
 *
 *	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *	It doesn't matter what you leave beyond the new length.
 *
 *	Author: matao
 *
 */

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
     	if(nums == null || nums.length == 0) {
     		return 0;
     	}   

     	int count = 0;
     	for(int i = 0; i < nums.length; i++) {
     		if(nums[i] != nums[count]) {
     			nums[++count] = nums[i];
     		}
     	}
     	return count+1;
    }

    public static void main(String[] args) {
    	int[] nums1 = {1, 1, 2};
    	System.out.println(removeDuplicates(nums1));

    	int[] nums2 = {1};
    	System.out.println(removeDuplicates(nums2));

    	int[] nums3 = {1, 1, 2, 2};
    	System.out.println(removeDuplicates(nums3));

    	int[] nums4 = {1, 1, 2, 2, 2, 3};
    	System.out.println(removeDuplicates(nums4));

    	int[] nums5 = {-14,-14,-13,-13,-13,-13,-13,-13,-13,-12,-12,-12,-12,-11,-10,-9,-9,-9,-8,-7,-5,-5,-5,-5,-4,-3,-3,-2,-2,-2,-2,-1,-1,-1,-1,-1,0,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,6,6,6,6,7,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,14,14,14,14,15,16,16,16,18,18,18,19,19,19,19,20,20,20,21,21,21,21,21,21,22,22,22,22,22,23,23,24,25,25};
    	System.out.println(removeDuplicates(nums5));
    }
}