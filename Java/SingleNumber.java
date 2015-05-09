/**
 *
 *	Given an array of integers, every element appears twice except for one.
 *	Find that single one.
 *
 *	Note:
 *	Your algorithm should have a linear runtime complexity. 
 *	Could you implement it without using extra memory?
 *
 *	author : matao
 */

 public class SingleNumber {
 	/**
	 *	a ^ a = 0,  a ^ 0 = a;
	 */
 	public static int singleNumber(int[] nums) {
		int temp = 0;			
		for(int i = 0; i < nums.length; i++) {
			temp ^= nums[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 4, 1, 2};
		int result = singleNumber(nums);
		System.out.println(result);
	}
 }
