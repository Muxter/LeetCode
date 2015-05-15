/**	Compare two version numbers version1 and version2.
 *	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 *	You may assume that the version strings are non-empty and contain only digits and the . character.
 *	The . character does not represent a decimal point and is used to separate number sequences.
 *	For instance, 2.5 is not "two and a half" or "half way to version three", 
 *	it is the fifth second-level revision of the second first-level revision.
 *
 *	Here is an example of version numbers ordering:
 *
 *	0.1 < 1.1 < 1.2 < 13.37
 *
 *	Author: matao
 *
 */

public class CompareVersionNumbers {
	public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("[.]");
        String[] s2 = version2.split("[.]");
        if(s1.length < s2.length)
        	return -1 * compareVersion(version2, version1);
        int v1, v2;
        for (int i = 0; i < s1.length; i++) {
			v1 = Integer.parseInt(s1[i]);
        	if(i >= s2.length)
				v2 = 0;
        	else{
        		v2 = Integer.parseInt(s2[i]);
        	}
        	if (v1 < v2) {
        		return -1;
        	} else if(v1 > v2) {
        		return 1;
        	}
        }
        return 0;
    }

    public static void main(String[] args) {
    	System.out.println(compareVersion("0.1", "0.1.1"));
    	System.out.println(compareVersion("0.1", "0.1.0"));
    	System.out.println(compareVersion("0.1", "0.0.1"));
    	System.out.println(compareVersion("0.1", "1.0"));
    	System.out.println(compareVersion("0.1", "1.1"));
    	System.out.println(compareVersion("1.1", "0.1"));
    	System.out.println(compareVersion("1.1", "1.1"));
    	System.out.println(compareVersion("1.1", "1.2"));
    	System.out.println(compareVersion("01", "1"));
    }
}