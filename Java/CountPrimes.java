/**
 *	Description:
 *
 *	Count the number of prime numbers less than a non-negative number, n
 *
 *	Author: matao
 * 
 * 	Hint: 埃拉托斯特尼筛法, 若逐个判定则超时
 */

// 小于n的所有素数
public class CountPrimes {
	public static int countPrimes(int n) {
        if (n <= 2) {
        	return 0;
        }
        
        boolean[] sieve = new boolean[n];
        for(int i = 2; i < n; i++) {
        	sieve[i] = true;
        }
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
        	if(sieve[i]) {
        		for (int j = i; i * j < n; j++) {
        			sieve[i * j] = false;
        		}
        	}
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
        	if (sieve[i]) {
        		++count;
        	}
        }
        return count;
    }
    
    // public static boolean isPrime(int x) {
    //     if(x == 0 || x == 1)
    //         return false;
    //     if(x == 2)
    //         return true;
    //     for(int i = 2; i <= (int)Math.sqrt(x); i++) {
    //         if(x % i == 0)
    //             return false;
    //     }
    //     return true;
    // }

    public static void main(String[] args) {
    	int count1 = countPrimes(2);
    	int count2 = countPrimes(999983);
    	int count3 = countPrimes(30);
    	int count4 = countPrimes(65535);
    	System.out.println(count1);
    	System.out.println(count2);
    	System.out.println(count3);
    	System.out.println(count4);
    }
}