/**
 *	Write an algorithm to determine if a number is "happy".
 *
 *	A happy number is a number defined by the following process: 
 *	Starting with any positive integer, 
 *	replace the number by the sum of the squares of its digits, 
 *	and repeat the process until the number equals 1 (where it will stay), 
 *	or it loops endlessly in a cycle which does not include 1. 
 *	Those numbers for which this process ends in 1 are happy numbers.
 *
 *	Example: 19 is a happy number
 *
 *	1^2 + 9^2 = 82
 *	8^2 + 2^2 = 68
 *	6^2 + 8^2 = 100
 *	1^2 + 0^2 + 0^2 = 1
 *
 *	Author: matao
 *
 */

import java.util.HashSet;

public class HappyNumber {
/**
 *	会超时
 *
 *	public static boolean isHappy(int n) {
 *		while(n < 10) {
 *			n *= n;
 *		}
 *		while(n >= 10) {
 *      	int sum = 0;
 *       	int temp = n;
 *       	while(temp != 0) {
 *       		sum += (temp % 10) * (temp % 10);
 *      		temp /= 10;
 *       	}
 *       	n = sum;
 *       }
 *       return n == 1;
 *   }
 */

	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		while(n != 1) {
			if(set.contains(n))
				return false;
			set.add(n);
			n = getNext(n);
		}
		return true;
	}

	public static int getNext(int n) {
		int sum = 0;
		while(n != 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

    public static void main(String[] args) {
    	System.out.println(isHappy(19));
    	System.out.println(isHappy(7));
    	System.out.println(isHappy(11));
    }
}