/**
 *	Rotate an array of n elements to the right by k steps.
 *
 *	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].	
 */

public class RotateArray {

	// Time Limite Exceeded
	// public static void rotate(int[] nums, int k) {
 //        if (nums == null || nums.length == 0)
 //        	return;
 //        k = k % nums.length;
 //        while(k-- > 0) {
 //        	int temp = nums[nums.length - 1];
 //        	for (int i = nums.length - 2; i >= 0; i--) {
 //        		nums[i+1] = nums[i];
 //        	}
 //        	nums[0] = temp;
 //        }
 //    }

	// 三次翻转
	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
        	return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
	}

	public static void reverse(int[] nums, int left, int right) {
		while(left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

    public static void main(String[] args) {
    	int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
    	rotate(nums1, 3);
    	for (int i = 0; i < nums1.length; i++) {
    		System.out.print(nums1[i] + " ");
    	}
    	System.out.println();

    	int[] nums2 = {1, 2};
    	rotate(nums2, 0);
    	for (int i = 0; i < nums2.length; i++) {
    		System.out.print(nums2[i] + " ");
    	}
    	System.out.println();
    }
}