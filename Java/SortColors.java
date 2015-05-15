/**
 *	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 *
 *	with the colors in the order red, white and blue.
 *
 *	Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 *	Note:
 *	You are not suppose to use the library's sort function for this problem.
 *
 *	Author: matao
 *
 */

public class SortColors {
	// 类似快排，需另用k记录第一个1出现的位置
	public static void sortColors1(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
		int i = 0, j = nums.length - 1, k = 0;
		while(k <= j) {
			switch(nums[k]) {
				case 0:
					swap(nums, i, k);
					i++;
					k = (k > i) ? k : i;
				break;

				case 1:
					k++;
				break;

				case 2:
					swap(nums, k, j);
					j--;
					// k++;
				break;
			}
		}
    }

    public static void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }

    // 统计0, 1, 2出现次数，再赋值
    public static void sortColors2(int[] nums) {
    	int num0 = 0, num1 = 0, num2 = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i] == 0) ++num0;
    		if(nums[i] == 1) ++num1;
    		if(nums[i] == 2) ++num2;
    	}
    	int k = 0;
    	while(num0-- >0) nums[k++] = 0;
    	while(num1-- >0) nums[k++] = 1;
    	while(num2-- >0) nums[k++] = 2;
    }

    public static void main(String[] args) {
    	int[] nums1 = {2, 0, 0, 1, 2, 0, 2};
    	sortColors1(nums1);
    	for (Integer integer: nums1) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

    	int[] nums2 = {0, 1, 2, 0, 1, 2};
    	sortColors1(nums2);
    	for (Integer integer: nums2) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

    	int[] nums3 = {2, 0, 2, 2, 1, 2, 2, 1, 2, 0, 0, 0, 1};
    	sortColors1(nums3);
    	for (Integer integer: nums3) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();
    }
}