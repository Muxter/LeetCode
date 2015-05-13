/**
 *	You are climbing a stair case. It takes n steps to reach to the top.
 *
 *	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *	
 *	Author: matao
 *  
 * 	假设n级台阶共An中走法，则：
 *	n = 1时，A1 = 1;  (走1级)
 *  n = 2时，A2 = 2;  (走2个一级或走1个两级)
 *	所以n级台阶，可以走n-1级后再走1级 或 走n-2级后再走2级
 *	An ＝ An-1 + An-2;
 *	1 2 3 5 8...
 */

public class ClimbingStairs {
	// Recursion
	public static int climbStairs1(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		return climbStairs1(n-1) + climbStairs1(n-2);
    }

    // None-Recursion
    public static int climbStairs2(int n) {
    	if(n == 1)
    		return 1;
    	if(n == 2)
    		return 2;
    	int a = 1, b = 2, sum = 0;
    	for(int i = 3; i <= n; i++) {
    		sum = a+b;
    		a = b;
    		b = sum;
    	}
    	return sum;
    }

    public static void main(String[] args) {
    	System.out.println(climbStairs1(3));
    	System.out.println(climbStairs1(4));
    	System.out.println(climbStairs1(5));
    	System.out.println(climbStairs1(10));

    	System.out.println(climbStairs2(3));
    	System.out.println(climbStairs2(4));
    	System.out.println(climbStairs2(5));
    	System.out.println(climbStairs2(10));
    }
}