/**
 *	Related to question Excel Sheet Column Title
 *
 *	Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 *	For example:
 *
 *  A -> 1
 *   B -> 2
 *   C -> 3
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28 
 *
 *	Author: matao
 */

public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i <= s.length() - 1; i++) {
            result += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
    	System.out.println(titleToNumber("A"));
    	System.out.println(titleToNumber("B"));
    	System.out.println(titleToNumber("Z"));
    	System.out.println(titleToNumber("AA"));
    	System.out.println(titleToNumber("AB"));
    }
}