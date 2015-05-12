/**
 *	Given a binary tree, return the inorder traversal of its nodes' values.
 *
 *	For example:
 *	Given binary tree {1,#,2,3},
 *  1
 *   \
 *    2
 *   /
 *  3
 *	return [1,3,2].
 *
 *	Author: matao
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
	TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    } 
}

public class BinaryTreeInorderTraversal {
	// Divide and Conquer
	public static List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
        	return result;
        }

        List<Integer> left = inorderTraversal1(root.left);
        result.addAll(left);

        result.add(root.val);

		List<Integer> right = inorderTraversal1(root.right);
        result.addAll(right);        

        return result;
    }

//------------------------------
    // Recursion
    public static List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
    }

    public static void traverse(TreeNode root, List<Integer> result) {
    	if (root == null) {
    		return;
    	}
    	traverse(root.left, result);
		result.add(root.val);
		traverse(root.right, result);
    }

//------------------------------    	
    // None-recursion
    public static List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) {
    		return result;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode currNode = root;
    	while (currNode != null || !stack.empty()) {
    		while(currNode != null) {
    			stack.push(currNode);
    			currNode = currNode.left;
    		}
    		currNode = stack.pop();
    		result.add(currNode.val);
    		currNode = currNode.right;
    	}
    	return result;
    }

    public static void main(String[] args) {
	/**  1
 	 *    \
 	 *     2
 	 *    /
 	 *   3
 	 *	return [1,3,2]
 	 */
    	TreeNode root = new TreeNode(1);
    	TreeNode node1 = new TreeNode(2);
    	TreeNode node2 = new TreeNode(3);
    	root.right = node1;
    	node1.left = node2;

    	List<Integer> result1 = inorderTraversal1(root);
    	for (Integer integer : result1) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

    	List<Integer> result2 = inorderTraversal2(root);
    	for (Integer integer : result2) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();

    	List<Integer> result3 = inorderTraversal3(root);
    	for (Integer integer : result3) {
    		System.out.print(integer + " ");
    	}
    	System.out.println();
    }
}