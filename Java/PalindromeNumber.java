/**
 *	Determine whether an integer is a palindrome. Do this without extra space.
 *
 *	click to show spoilers.
 *
 *	Some hints:
 *	Could negative integers be palindromes? (ie, -1)
 *
 *	If you are thinking of converting the integer to string, note the restriction of using extra space.
 *	
 *	You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
 * 	you know that the reversed integer might overflow. How would you handle such case?
 *
 *	There is a more generic way of solving this problem.
 *
 *	Author: matao
 *
 */

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
    	if(x < 0) {
    		return false;
    	}   
    	int len = 1;
    	int temp = x;
    	while(temp / 10 != 0) {
    		len *= 10;
    		temp /= 10;
    	}
    	while(x != 0) {
    		int i = x / len;
    		int j = x % 10;
    		if(i != j) {
    			return false;
    		}
    		x = x % len; //去掉最高位
    		x = x / 10;  //去掉最低位
    		len /= 100;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	System.out.println(isPalindrome(121));
    	System.out.println(isPalindrome(1234321));
    	System.out.println(isPalindrome(-1234321));
    	System.out.println(isPalindrome(2147447412));
    	System.out.println(isPalindrome(2142));
    }
}