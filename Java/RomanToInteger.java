/**
 *	Given a roman numeral, convert it to an integer.
 *
 *	Input is guaranteed to be within the range from 1 to 3999.
 *
 *	Author: matao
 *
 */

import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {

	public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] cArray = s.toCharArray();
        int result = map.get(cArray[0]);
        int pre = map.get(cArray[0]);
        for(int i = 1; i < s.length(); i++) {
        	if(pre >= map.get(cArray[i])) {
        		result += map.get(cArray[i]);
        	} else {
        		result += (map.get(cArray[i]) - 2 * pre);
        	}
        	pre = map.get(cArray[i]);
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println(romanToInt("I"));   		// 1
		System.out.println(romanToInt("IV"));  		// 4
		System.out.println(romanToInt("VI"));		// 6
		System.out.println(romanToInt("VII"));		// 7
		System.out.println(romanToInt("CXXIII"));	// 123
		System.out.println(romanToInt("IX")); 		// 9
	}
}