/**
 *	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *	For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *	the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 *	Author: matao	
 *
 */

public class MaximumSubarray {

	// Sliding Window 滑动窗口
	public static int maxSubArray1(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int maxSub = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if(max < 0) {
        		max = 0;
        	}
        	max += nums[i];
        	if(max > maxSub) {
        		maxSub = max;
        	}
        }
        return maxSub;
    }

    // Divide & Conquer
    public static int maxSubArray2(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}
    	return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private static int maxSubArrayHelper(int[] nums, int left, int right) {
    	if(left == right) {
    		return nums[left];
    	}

    	int mid = left + (right - left) / 2;
    	int maxLeft = maxSubArrayHelper(nums, left, mid);
    	int maxRight = maxSubArrayHelper(nums, mid + 1, right);

    	// 如果最大值跨过mid，部分左边，部分右边
    	int maxTempLeft = nums[mid], sumTempLeft = nums[mid];
    	for(int i = mid - 1; i >= left; i--) {
    		sumTempLeft += nums[i];
    		if(maxTempLeft < sumTempLeft) {
    			maxTempLeft = sumTempLeft;
    		}
    	}
    	int maxTempRight = nums[mid + 1], sumTempRight = nums[mid + 1];
    	for(int j = mid + 2; j <= right; j++) {
    		sumTempRight += nums[j];
    		if(maxTempRight < sumTempRight) {
    			maxTempRight = sumTempRight;
    		}
    	}
    	int maxMid = maxTempLeft + maxTempRight;

    	return (maxLeft > maxRight ? maxLeft : maxRight) > maxMid ? (maxLeft > maxRight ? maxLeft : maxRight) : maxMid;
    }

	public static void main(String[] args) {
		int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int[] nums2 = {2, 0, -3, 2, 1, 0, 1, -2};
		System.out.println(maxSubArray1(nums1));
		System.out.println(maxSubArray2(nums1));
		System.out.println(maxSubArray1(nums2));
		System.out.println(maxSubArray2(nums2));
	}
}