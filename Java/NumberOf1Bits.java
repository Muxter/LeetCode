/**
 *	Write a function that takes an unsigned integer and returns the number of ’1' bits 
 *	it has (also known as the Hamming weight).
 *
 *	For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 *	so the function should return 3.
 *
 *	Author: matao
 *
 */
public class NumberOf1Bits {
	public static int hammingWeight(int n) {
  // 	int count = 0;
  //       while(n > 0) {
  //           if((n & 1) > 0) {
  //               ++count;
  //           }
  //           n >>= 1;
  //       }
  //       return count;

		if(n == 0) {
			return 0;
		}
		int count = 1;
		while((n & (n-1)) > 0) {
			++count;
			n &= (n-1);
		}
		return count;
    }

    public static void main(String[] args) {
    	System.out.println(hammingWeight(0));
    	System.out.println(hammingWeight(1));
    	System.out.println(hammingWeight(3));
    	System.out.println(hammingWeight(10));
    }
}