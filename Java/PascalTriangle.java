/**
 *	Given numRows, generate the first numRows of Pascal's triangle.
 *
 *	For example, given numRows = 5,
 *	Return
 *	
 *	[
 *    		[1],
 *   	   [1,1],
 *  	  [1,2,1],
 * 		 [1,3,3,1],
 *		[1,4,6,4,1]
 *	]
 *
 *	Author: matao
 *
 */

import java.util.List;
import java.util.ArrayList;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
        	return result;
        }
        for (int i = 0; i < numRows; i++) {
        	List<Integer> item = new ArrayList<Integer>();
        	for (int j = 0; j <= i; j++) {
        		if(j == 0 || j == i) {
        			item.add(1);
        		} else {
        			item.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
        		}
        	}
        	result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
 		List<List<Integer>> result = generate(5);
 		for (List<Integer> list : result) {
 			for (Integer integer : list) {
 				System.out.print(integer + " ");
 			}
 			System.out.println();
 		}
    }
}