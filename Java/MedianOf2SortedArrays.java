/**
 *	There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 *	Find the median of the two sorted arrays. 
 *	The overall run time complexity should be O(log (m+n)).
 *
 *	Author: matao
 *
 * 	log级别的时间复杂度，需联想到二分搜索，借鉴其思想，每次砍掉一半不符合的数据
 */

public class MedianOf2SortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 0)
        	return (findKth(nums1, 0 ,nums2, 0, length / 2) + findKth(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;
        else
        	return findKth(nums1, 0 ,nums2, 0, length / 2 + 1);
    }

    /**
     *	查找nums1, nums2合并后第k大的数
     *	
     *	每次删除k/2个数
	 *	假设 A 和 B 的元素个数都大于 k/2,我们将 A 的第 k/2 个元素(即 A[k/2-1])和 B 的第 k/2 个元素(即 B[k/2-1])进行比较,
	 *	有以下三种情况(为了简化这里先假设 k 为偶数,所得到的结论 对于 k 是奇数也是成立的):
	 *	• A[k/2-1] == B[k/2-1]
	 *	• A[k/2-1] > B[k/2-1] 
	 *	• A[k/2-1] < B[k/2-1]
	 *	如果 A[k/2-1] < B[k/2-1],意味着 A[0] 到 A[k/2-1 的肯定在 A ∪ B 的 top k 元素的范围内,
	 *	换句话说,A[k/2-1 不可能大于 A ∪ B 的第 k 大元素。
	 *
	 *	因此,我们可以放心的删除 A 数组的这 k/2 个元素。同理,当 A[k/2-1] > B[k/2-1] 时,可 以删除 B 数组的 k/2 个元素。
	 *	当 A[k/2-1] == B[k/2-1] 时,说明找到了第 k 大的元素,直接返回 A[k/2-1] 或 B[k/2-1] 即可。
  	 *	因此,
	 *	• 当A或B是空时,直接返回B[k-1]或A[k-1];
	 *	• 当k=1是,返回min(A[0],B[0]);
	 *	• 当A[k/2-1]==B[k/2-1]时,返回A[k/2-1]或B[k/2-1]
	 *
     */
    public static int findKth(int[] nums1, int nums1_start, int[] nums2, int nums2_start, int k) {
    	if(nums1_start >= nums1.length)
    		return nums2[nums2_start + k - 1];
    	if(nums2_start >= nums2.length)
    		return nums1[nums1_start + k - 1];
    	if (k == 1) {
    		return nums1[nums1_start] < nums2[nums2_start] ? nums1[nums1_start] : nums2[nums2_start];
    	}
    	//边界判断
    	int nums1_key = nums1_start + k / 2 - 1 < nums1.length ? nums1[nums1_start + k / 2 - 1] : Integer.MAX_VALUE;
    	int nums2_key = nums2_start + k / 2 - 1 < nums2.length ? nums2[nums2_start + k / 2 - 1] : Integer.MAX_VALUE;
    	if (nums1_key < nums2_key) {
    		return findKth(nums1, nums1_start + k / 2, nums2, nums2_start, k - k / 2);
    	} else
    		return findKth(nums1, nums1_start, nums2, nums2_start + k / 2, k - k / 2);
    }

	public static void main(String[] args) {
		int[] nums1 = {1,2,3,4,5,6};
		int[] nums2 = {2,3,4,5};
		int[] nums3 = {1,2,3};
		int[] nums4 = {4,5};
		int[] nums5 = {1};
		int[] nums6 = {2,3,4,5,6};
		double median1 = findMedianSortedArrays(nums1, nums2);
		System.out.println(median1);
		double median2 = findMedianSortedArrays(nums3, nums4);
		System.out.println(median2);
		double median3 = findMedianSortedArrays(nums5, nums6);
		System.out.println(median3);
	}
}