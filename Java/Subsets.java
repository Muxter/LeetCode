/** Given a set of distinct integers, nums, return all possible subsets.
 *
 * 	Note:
 *	Elements in a subset must be in non-descending order.
 *	The solution set must not contain duplicate subsets.
 *	For example,
 *	If nums = [1,2,3], a solution is:
 *
 *	[
 *		[3],
 * 		[1],
 * 		[2],
 * 		[1,2,3],
 * 		[1,3],
 * 		[2,3],
 * 		[1,2],
 * 		[]
 *	]
 *
 *	Author: matao
 * 	动态规划
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return result;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        subsetsHelper(result, list, nums, 0);
        return result;
    }
    
    public static void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
		int[] nums = {1, 2};
		List<List<Integer>> lists = subsets(nums);
		for (List<Integer> arrayList : lists) {
			for (Integer integer : arrayList) {
				System.out.print(integer.toString() + " ");
			}
			System.out.println();
		}
	}
}