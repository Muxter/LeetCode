/** Given a string, determine if it is a palindrome, 
 *  considering only alphanumeric characters and ignoring cases.
 * 
 *  For example,
 *	"A man, a plan, a canal: Panama" is a palindrome.
 *	"race a car" is not a palindrome.
 *
 *	Note:
 *	Have you consider that the string might be empty? 
 *  This is a good question to ask during an interview.
 *
 *	For the purpose of this problem, 
 *  we define empty string as valid palindrome.
 */

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		s = removeNoise(s);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String removeNoise(String s) {	
		char[] temp = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.length; i++) {
			if (Character.isLetterOrDigit(temp[i])) {
				sb.append(Character.toLowerCase(temp[i]));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		if(isPalindrome(s)) {
			System.out.println("Yes");
		} else {
			System.out.println("Yes");
		}
	}
}
