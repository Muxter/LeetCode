/**
 *	Implement pow(x, n).
 *
 *	Author: matao
 */

public class Power {
	public static double myPow(double x, long n) {
        if(equal(x, 0.0) && n < 0) {
            return Double.POSITIVE_INFINITY;
        }
        int sign = 1;
        if(n < 0) {
            sign = -1;
            n = -n;
        }
        double result = myPowHelper(x, n);
        if(sign == -1) {
            result = 1.0 / result;
        }
        return result;
    }
    
    public static double myPowHelper(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        double result = myPowHelper(x, n >> 1);
        result *= result;
        if((n & 1) == 1) {
            result *= x;
        }
        return result;
    }
    
    public static boolean equal(double num1, double num2) {
        double tmp = num1 - num2;
        if(tmp < 0.000001 && tmp > -0.000001) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	System.out.println(myPow(10, 2));
    	System.out.println(myPow(10, -2));
    	System.out.println(myPow(10, 0));
    	System.out.println(myPow(0, 0));
    	System.out.println(myPow(0, -1));
    }
}