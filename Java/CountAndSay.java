/**
 *	The count-and-say sequence is the sequence of integers beginning as follows:
 *	1, 11, 21, 1211, 111221, ...
 *
 *	1 is read off as "one 1" or 11.
 *	11 is read off as "two 1s" or 21.
 *	21 is read off as "one 2, then one 1" or 1211.
 *	Given an integer n, generate the nth sequence.
 *
 *	Note: The sequence of integers will be represented as a string.
 *
 *	Author: matao
 *
 */

public class CountAndSay {
	public static String countAndSay(int n) {
		if(n <= 0) {
			return null;
		}
		String oldString = "1";
		if(n == 1) {
			return oldString;
		}
		for(int i = 1; i < n; i++) {
			oldString = generateNext(oldString);
		}
		return oldString;
    }

    public static String generateNext(String s) {
    	String result;
    	int count = 1;
    	char pre = s.charAt(0);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 1; i < s.length(); i++) {
    		if(s.charAt(i) == pre) {
    			count++;
    		} else {
    			sb.append(count + String.valueOf(pre));
    			pre = s.charAt(i);
    			count = 1;
    		}
    	}
    	sb.append(count + String.valueOf(pre));
    	return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(countAndSay(0));
    	System.out.println(countAndSay(1));
    	System.out.println(countAndSay(2));
    	System.out.println(countAndSay(3));
    	System.out.println(countAndSay(4));
    	System.out.println(countAndSay(5));
    	System.out.println(countAndSay(6));
    }
}