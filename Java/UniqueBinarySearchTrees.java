/*
 *	Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 *	For example,
 *	Given n = 3, there are a total of 5 unique BST's.
 *
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *    3     2     1      1   3      2
 *   /     /       \                 \
 *  2     1         2                 3
 *
 *	Author: matao
 *
 */

public class UniqueBinarySearchTrees {

	/**
	 *	n个点中每个点都可以作为root，当 i 作为root时，
	 *	小于i的点都只能放在其左子树中，大于i的点只能放在右子树中，
	 *	此时只需求出左、右子树各有多少种，二者相乘即为以 i 作为root时BST的总数。
	 *	result[n] = ∑ (result[0...n-1] * result[n-1...0])
	 */
	public static int numTrees(int n) {
		if(n < 0) {
			return 0;
		}   
		int[] result = new int[n+1];
		result[0] = 1; //空树
		result[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				result[i] += result[j] * result[i-1-j];	
			}
		}
		return result[n];
    }

    public static void main(String[] args) {
    	System.out.println(numTrees(2));
    	System.out.println(numTrees(3));
    	System.out.println(numTrees(4));
    }
}