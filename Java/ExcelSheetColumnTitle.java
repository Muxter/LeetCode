/**
 *	Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 *	For example:
 *
 *  1 -> A
 *  2 -> B
 *  3 -> C
 *   ...
 *  26 -> Z
 *  27 -> AA
 *  28 -> AB 
 *
 *	Author: matao
 */

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
        String s = null;
		StringBuilder sb = new StringBuilder();
        do {
            n = n - 1;
        	int remain = n % 26;
        	char c = (char)('A' + remain);
        	sb.append(c);
        	n = n / 26;
        } while (n != 0);
        s = reverseString(sb.toString());
        return s;
    }
    
    public static String reverseString(String s) {
    	char[] c = s.toCharArray();
    	for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
    		char temp = c[i];
    		c[i] = c[j];
    		c[j] = temp;
    	}
    	return new String(c);
    }

    public static void main(String[] args) {
    	System.out.println(convertToTitle(1));   // A
    	System.out.println(convertToTitle(24));  // X
    	System.out.println(convertToTitle(25));  // Y
    	System.out.println(convertToTitle(26));	 // Z
    	System.out.println(convertToTitle(27));  // AA
    	System.out.println(convertToTitle(28));  // AB
    }
}