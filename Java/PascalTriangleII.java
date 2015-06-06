/**
 *	Given an index k, return the kth row of the Pascal's triangle.
 *
 *	For example, given k = 3,
 *	Return [1,3,3,1].
 *
 *	Note:
 *	Could you optimize your algorithm to use only O(k) extra space?
 *
 *	Author: matao
 *
 */

import java.util.List;
import java.util.ArrayList;

public class PascalTriangleII {
	public static List<Integer> getRow1(int rowIndex) {
        if(rowIndex < 0) {
        	return null;
        }
        List<List<Integer>> total = new ArrayList<List<Integer>>();
        for (int i = 0; i <= rowIndex; i++) {
        	List<Integer> item = new ArrayList<Integer>();
        	for (int j = 0; j <= i; j++) {
        		if(j == 0 || j == i) {
        			item.add(1);
        		} else {
        			item.add(total.get(i-1).get(j-1) + total.get(i-1).get(j));
        		}
        	}
        	total.add(item);
        }
        return total.get(rowIndex);
    }

    public static List<Integer> getRow2(int rowIndex) {
    	
    }

    public static void main(String[] args) {
    	System.out.println(getRow1(3));
    	System.out.println(getRow2(3));
    }
}