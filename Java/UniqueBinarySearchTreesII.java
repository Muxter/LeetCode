/**
 *	Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 *	For example,
 *	Given n = 3, your program should return all 5 unique BST's shown below.
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

import java.util.List;
import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}

public class UniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees(int n) {
		return generate(1, n);
    }

    public static List<TreeNode> generate(int start, int end) {
    	List<TreeNode> result = new ArrayList<TreeNode>();
    	if(start > end) {
    		result.add(null);
    		return result;
    	}

    	for (int i = start; i <= end; i++) {
    		List<TreeNode> left = generate(start, i-1);
    		List<TreeNode> right = generate(i+1, end);
    		for (TreeNode l : left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i);
    				root.left = l;
    				root.right = r;
    				result.add(root);
    			}
    		}
    	}
    	return result;
    }

    public static void InOrderTraverse(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	System.out.print(root.val + " ");
    	InOrderTraverse(root.left);
    	InOrderTraverse(root.right);
    }

    public static void main(String[] args) {
    	List<TreeNode> roots0 = generateTrees(0);
    	for (TreeNode root : roots0) {
    		InOrderTraverse(root);
    		System.out.println();
    	}

    	List<TreeNode> roots1 = generateTrees(1);
    	for (TreeNode root : roots1) {
    		InOrderTraverse(root);
    		System.out.println();
    	}

    	List<TreeNode> roots2 = generateTrees(2);
    	for (TreeNode root : roots2) {
    		InOrderTraverse(root);
    		System.out.println();
    	}

    	List<TreeNode> roots3 = generateTrees(3);
    	for (TreeNode root : roots3) {
    		InOrderTraverse(root);
    		System.out.println();
    	}
    }
}