/**
 *	Given an integer, convert it to a roman numeral.
 *
 *	Input is guaranteed to be within the range from 1 to 3999.
 *
 *	Author: matao
 *
 */

public class IntegerToRoman {
	public static String intToRoman(int num) {
        if(num <= 0)
        	return "";
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(num > 0) {
        	int times = num / vals[i];
        	while(times-- > 0) {
        		result.append(symbols[i]);
        	}
        	num %= vals[i];
        	i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
    	System.out.println(intToRoman(1));
    	System.out.println(intToRoman(123));
    	System.out.println(intToRoman(56));
    	System.out.println(intToRoman(24));
    }
}