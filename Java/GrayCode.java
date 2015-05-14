/**
 *	The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 *	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 *	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 *	00 - 0
 *	01 - 1
 *	11 - 3
 *	10 - 2
 *
 *	Note:
 *  For a given n, a gray code sequence is not uniquely defined. 
 *
 *	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 *	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 *	Author: matao
 *
 */

import java.util.List;
import java.util.ArrayList;

public class GrayCode {
	public static List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n <= 1) {
			for (int i = 0; i <= n; i++) {
				result.add(i);
			}
			return result;
		}
		result = grayCode(n - 1);
		List<Integer> reverseResult = reverse(result);

		for(int i = 0; i < reverseResult.size(); i++) {
			result.add((1 << (n-1)) | reverseResult.get(i));
		}
		return result;
	}

	public static List<Integer> reverse(List<Integer> list) {
		List<Integer> rev = new ArrayList<Integer>();
		for (int i = list.size() - 1; i >= 0; i--) {
			rev.add(list.get(i));
		}
		return rev;
	}

    public static void main(String[] args) {
    	List<Integer> result = grayCode(1);
    	for (Integer integer : result) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

		result = grayCode(2);
    	for (Integer integer : result) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

		result = grayCode(3);
    	for (Integer integer : result) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();
    }
}