/**
 *	Implement atoi to convert a string to an integer.
 *
 *	Hint: Carefully consider all possible input cases. 
 *	If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 *	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 *
 *	You are responsible to gather all the input requirements up front.
 *
 *	Author: matao
 *
 */

public class StringToInteger {
	/**
	 *	注意超过最大，最小值，输入带了正负号，非法输入等情况的处理
	 *
	 */
	public static int myAtoi(String str) {
        if(str == null)
        	return 0;
        str = str.trim();
        if(str.length() == 0)
        	return 0;
        int sign = 1;
        int index = 0;
        if(str.charAt(index) == '+') {
        	index++;
        } else if (str.charAt(index) == '-') {
        	index++;
        	sign = -1;
        }
        long result = 0;
        while(index < str.length()) {
        	if(str.charAt(index) < '0' || str.charAt(index) > '9')
        		break;
        	result = result * 10 + str.charAt(index) - '0';
        	if (result > Integer.MAX_VALUE)
        		break;
        	index++;
        }
        if(sign * result > Integer.MAX_VALUE) 
        	return Integer.MAX_VALUE;
        if(sign * result < Integer.MIN_VALUE) 
        	return Integer.MIN_VALUE;
        return (int)(sign * result);
    }

    public static void main(String[] args) {
    	System.out.println(myAtoi("123"));
    	System.out.println(myAtoi("+123"));
    	System.out.println(myAtoi("-123"));
    	System.out.println(myAtoi("-1123456765436765432"));
    	System.out.println(myAtoi("9223372036854775809"));
    	System.out.println(myAtoi("safd"));
    }
}