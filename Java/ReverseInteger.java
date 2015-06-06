/**
 *	Reverse digits of an integer.
 *
 *	Example1: x = 123, return 321
 *	Example2: x = -123, return -321	
 *	
 *	Have you thought about this?
 *	Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 *	If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *
 *	Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
 *	then the reverse of 1000000003 overflows. How should you handle such cases?
 *	
 *	For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 *	Author: matao
 *
 */

public class ReverseInteger {
	public static int reverse(int x) {
		long result = 0;
		while(x != 0) {
			result = result * 10 + x % 10;
			x /= 10;
		}        
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)result;
    }

    public static int reverse2(int x) {
		int result = 0;
		while(x != 0) {
			int tmp = result * 10 + x % 10;
			x /= 10;
			if(tmp/10 != result) {   // overflow judge
				return 0;
			}
			result = tmp;
		}        
		return result;
    }

    public static void main(String[] args) {
    	System.out.println(reverse(-123));
    	System.out.println(reverse(-12345));
    	System.out.println(reverse(1000000003));

    	System.out.println(reverse2(-123));
    	System.out.println(reverse2(-12345));
    	System.out.println(reverse2(1000000003));
    }
}