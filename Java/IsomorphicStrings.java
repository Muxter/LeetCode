/**
 *	Given two strings s and t, determine if they are isomorphic.
 *
 *	Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 *	All occurrences of a character must be replaced with another character while 
 *	preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 *	For example,
 *	Given "egg", "add", return true.
 *
 *	Given "foo", "bar", return false.
 *
 *	Given "paper", "title", return true.
 *
 * 	Note:
 *	You may assume both s and t have the same length.
 *
 *	Author: matao
 *
 */

import java.util.Map;
import java.util.HashMap;

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
        	return false;
        }
        if((s.length() == 1) && (s.charAt(0) != t.charAt(0))) {
        	return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
        	if (map.get(s.charAt(i)) == null) {
        		map.put(s.charAt(i), t.charAt(i));
        	}
        	if(map.get(s.charAt(i)) != t.charAt(i)) {
        		return false;
        	}
        }
        map.clear();
        for (int i = 0; i < s.length(); i++) {
        	if (map.get(t.charAt(i)) == null) {
        		map.put(t.charAt(i), s.charAt(i));
        	}
        	if(map.get(t.charAt(i)) != s.charAt(i)) {
        		return false;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
    	System.out.println(isIsomorphic("paper", "title"));
    	System.out.println(isIsomorphic("foo", "bar"));
    	System.out.println(isIsomorphic("egg", "add"));
    	System.out.println(isIsomorphic("e", "a"));
    	System.out.println(isIsomorphic("ab", "aa"));
    }
}