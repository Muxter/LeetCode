/**
 *	Given an array and a value, remove all instances of that value in place and return the new length.
 *
 *	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 *	Author: matao
 *	
 *	Hint: 头尾两个指针，头指针若与给定数相等，就用末尾的数进行覆盖
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int i = 0, j = nums.length - 1;
		while( i <= j) {
			if(nums[i] == val) {
				nums[i] = nums[j];
				j--;
			} else {
				i++;
			}
		}
		return j+1;
	} 

	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 4, 4};
		System.out.println(removeElement(nums1, 4));

		int[] nums2 = {1, 1};
		System.out.println(removeElement(nums2, 1));

		int[] nums3 = {2, 2, 1, 2};
		System.out.println(removeElement(nums3, 2));
	}
}